/**
 * 2019年8月19日
 * Copyright ©2015-2019 北京特微智能科技有限公司. All rights reserved.
 * 特微智能专有/机密 使用须遵守许可条款.
 */

package cn.trawe.operation.base.third.wxclient.controller;

import cn.trawe.operation.base.third.api.WechatAccessAPI;
import cn.trawe.operation.base.third.common.config.WxMpServiceUtil;
import cn.trawe.operation.base.third.dbaccess.domain.WeixinAccountConfig;
import cn.trawe.operation.base.third.dbaccess.service.impl.WeixinAccountConfigServiceImpl;
import cn.trawe.operation.base.third.msg.ResultBody;
import cn.trawe.operation.base.third.msg.WxUserInfo;
import cn.trawe.operation.base.third.msg.request.WxAuthCodeRequest;
import cn.trawe.operation.base.third.wxclient.constants.Constants;
import cn.trawe.operation.base.third.wxclient.service.WeChatService;
import cn.trawe.operation.base.third.wxclient.utils.HttpClientUtil;
import cn.trawe.pay.common.client.RedisClient;
import cn.trawe.util.L;
import cn.trawe.utils.ValidateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <P>获取<B>微信小程序<B/>相关的授权url、用户信息、校验信息等.
 *
 * @author houmq
 * @date 2020.03.05
 */
@SuppressWarnings("all")
@RestController
@RequestMapping(value = "/")
@Slf4j
public class WxInterfaceController implements WechatAccessAPI{

    @Autowired
    WeChatService weChatService;

    @Autowired
    WeixinAccountConfigServiceImpl weixinAccountConfigServiceImpl;

    @Autowired
    RedisClient redisClient;

    @Autowired
    private WxMpServiceUtil wxMpServiceUtil;

    @Override
    public ResultBody<WxUserInfo> getUserInfo(WxAuthCodeRequest wxAuthCode) {
        // 获取code
        String code = wxAuthCode.getCode();
        String authType = wxAuthCode.getAuthType();

        //校验可能为空的参数
        if(ValidateUtil.isEmpty(authType))
            authType="userinfo";

        //从数据库获取微信账号信息  todo: 该信息需要缓存在redis中
        LambdaQueryWrapper<WeixinAccountConfig> queryWrapper = new QueryWrapper<WeixinAccountConfig>().lambda();
        queryWrapper.eq(WeixinAccountConfig::getAlias, "WEIXIN_H5");
        WeixinAccountConfig weixinAccountConfig = weixinAccountConfigServiceImpl.getBaseMapper()
                .selectOne(queryWrapper);

        // 获取openid和access_token
        String wxres = weChatService.getOpenid(code, weixinAccountConfig.getAppid(),weixinAccountConfig.getAppSecret());
        log.info(L.b(code).b("wxAccess").opt("getOpenid").opr("true").m(wxres).s());

        JSONObject jsonObject = JSONObject.parseObject(wxres);
        String openid = jsonObject.getString("openid");
        String accessToken = jsonObject.getString("access_token");

        // 获取用户信息
        String userInfo = weChatService.getUserInfo(accessToken, openid);
        log.info(L.b(weixinAccountConfig.getAppid()).bt("【授权登录】").sbt("【获取用户信息】").opt("getUserInfo")
                .opr(jsonObject.getString("errcode")).m(jsonObject.getString("errmsg")).d("userInfo", userInfo).s());

        WxUserInfo wxUserInfo=new WxUserInfo();

        if(jsonObject.containsKey("nickname"))
            wxUserInfo.setNickName(jsonObject.getString("nickname"));
        if(jsonObject.containsKey("headimgurl"))
            wxUserInfo.setAvatar(jsonObject.getString("headimgurl"));
        if(jsonObject.containsKey("city"))
            wxUserInfo.setCity(jsonObject.getString("city"));
        if(jsonObject.containsKey("country"))
            wxUserInfo.setCountry(jsonObject.getString("country"));
        if(jsonObject.containsKey("sex"))
            wxUserInfo.setGender(jsonObject.getString("sex"));
        if(jsonObject.containsKey("language"))
            wxUserInfo.setLanguage(jsonObject.getString("language"));
        if(jsonObject.containsKey("province"))
            wxUserInfo.setProvince(jsonObject.getString("province"));
        if(jsonObject.containsKey("unionid"))
            wxUserInfo.setUnionid(jsonObject.getString("unionid"));
        wxUserInfo.setOpenid(openid);


        return new ResultBody<WxUserInfo>().ok().data(wxUserInfo);
    }

    public JSONObject authLogin(WxAuthCodeRequest wxAuthCode) {
        // 获取code
        String code = wxAuthCode.getCode();

        LambdaQueryWrapper<WeixinAccountConfig> queryWrapper = new QueryWrapper<WeixinAccountConfig>().lambda();
        queryWrapper.eq(WeixinAccountConfig::getAlias, "WEIXIN_H5");
        WeixinAccountConfig weixinAccountConfig = weixinAccountConfigServiceImpl.getBaseMapper()
                .selectOne(queryWrapper);

        // 获取openid和access_token
        String wxres = weChatService.getOpenid(code, weixinAccountConfig.getAppid(),
                weixinAccountConfig.getAppSecret());
        log.info("getOpenid resp: " + wxres);

        JSONObject jsonObject = JSONObject.parseObject(wxres);
        String openid = jsonObject.getString("openid");
        String accessToken = jsonObject.getString("access_token");
        log.info(L.b(weixinAccountConfig.getAppid()).bt("【授权登录】").sbt("【获取微信openid接口】").opt("getOpenid")
                .opr(jsonObject.getString("errcode")).m(jsonObject.getString("errmsg")).d("openid", openid).s());

        // 获取用户信息
        String userInfo = weChatService.getUserInfo(accessToken, openid);
        log.info(L.b(weixinAccountConfig.getAppid()).bt("【授权登录】").sbt("【获取用户信息】").opt("getUserInfo")
                .opr(jsonObject.getString("errcode")).m(jsonObject.getString("errmsg")).d("userInfo", userInfo).s());
        return JSON.parseObject(userInfo);
    }

    @RequestMapping(value = "/wx/ping")
    public String wxPing() {
        return "pong wx";
    }


    @Override
    public JSONObject getAccessToken(String alias) {

        if(ValidateUtil.isEmpty(alias)) {
            alias="WEIXIN_H5";
        }
        String accessToken = redisClient.get(Constants.WX_ACCESS_TOKEN, "");
        JSONObject tokenObj = new JSONObject();
        if (ValidateUtil.isEmpty(accessToken)) {
            LambdaQueryWrapper<WeixinAccountConfig> queryWrapper = new QueryWrapper<WeixinAccountConfig>().lambda();
            queryWrapper.eq(WeixinAccountConfig::getAlias, alias);
            WeixinAccountConfig account = weixinAccountConfigServiceImpl.getBaseMapper().selectOne(queryWrapper);

            String requestUrl = Constants.WX_GZH_ACCESS_TOKEN_URL;
            requestUrl = requestUrl.replace("APPID", account.getAppid()).replace("SECRET", account.getAppSecret());
            String resData = null;
            try {
                resData = HttpClientUtil.doGet(requestUrl);
            } catch (Exception e) {
                log.error("获取微信token失败：{}", e);
            }
            tokenObj = JSONObject.parseObject(resData);
            redisClient.set(Constants.WX_ACCESS_TOKEN, tokenObj.getString("access_token"),
                    tokenObj.getIntValue("expires_in") - 1200);
        }else {
            tokenObj.put("access_token", accessToken);
            tokenObj.put("expire_in", redisClient.ttl(Constants.WX_ACCESS_TOKEN));
        }
        return tokenObj;
    }

    @Override
    public ResultBody getAccessToken2(String appId) {
        WxMpService wxMpService = wxMpServiceUtil.getWxMpService(appId);
        try {
            String accessToken = wxMpService.getAccessToken();
//            String openid = "oubMLxFSuvldkBswSmo404qUypWY";
            String openid = "test";
            String requestUrl = Constants.WX_USER_INFO_URL;
            requestUrl = requestUrl.replace("TOKEN", accessToken).replace("OPENID", openid);
            String resData = null;
            try {
                resData = HttpClientUtil.doGet(requestUrl);
            } catch (Exception e) {
                log.error("验证token失败", e);
            }
            JSONObject userInfo = JSONObject.parseObject(resData);
            Integer errCode = userInfo.getInteger("errcode");
            if (ValidateUtil.isNotEmpty(errCode) && 40001 == errCode) {
                accessToken = wxMpService.getAccessToken(true);
            }
            return ResultBody.ok().data(accessToken);
        } catch (WxErrorException e) {
            log.info("获取access_token失败,appId={}", e, appId);
        }
        return ResultBody.failed();
    }


    @Override
    public JSONObject getToken(String alias) {
        if (ValidateUtil.isEmpty(alias)) {
            alias = "WEIXIN_H5";
        }
        LambdaQueryWrapper<WeixinAccountConfig> queryWrapper = new QueryWrapper<WeixinAccountConfig>().lambda();
        queryWrapper.eq(WeixinAccountConfig::getAlias, alias);
        WeixinAccountConfig account = weixinAccountConfigServiceImpl.getBaseMapper().selectOne(queryWrapper);
        ResultBody rb = getAccessToken2(account.getAppid());
        JSONObject tokenObj = new JSONObject();
        tokenObj.put("access_token", rb.getData());
        return tokenObj;
        // JSONObject obj = getAccessToken(alias);
        // String token = obj.getString("access_token");
        // JSONObject tokenObj = new JSONObject();
        // tokenObj.put("access_token", refreshToken(token));
        // return tokenObj;
    }

    private String getTokenString(String alias) {
        JSONObject obj = getToken(alias);
//        JSONObject obj = getAccessToken(alias);
        String token = obj.getString("access_token");
        return token;
//        return refreshToken(token);
    }


    @Override
    public JSONObject getSubscribeUserList(String alias, String nextopenid) {
        if(ValidateUtil.isEmpty(alias)) {
            alias="WEIXIN_H5";
        }
        String requestUrl = Constants.WX_MEMBER_USER_LIST_URL;
        requestUrl = requestUrl.replace("TOKEN", getTokenString("")).replace("OPENID", ValidateUtil.isEmpty(nextopenid)?"":nextopenid);
        String resData = null;
        try {
            resData = HttpClientUtil.doGet(requestUrl);
        } catch (Exception e) {
            log.error("获取微信公众号关注用户openid列表失败：{}", e);
        } 
        JSONObject userList = JSONObject.parseObject(resData);
        return userList;
    }


    @Override
    public JSONObject getUserInfo(String openid) {
        String requestUrl = Constants.WX_USER_INFO_URL;
        requestUrl = requestUrl.replace("TOKEN", getTokenString("")).replace("OPENID", openid);
        String resData = null;
        try {
            resData = HttpClientUtil.doGet(requestUrl);
        } catch (Exception e) {
            log.error("获取微信公众号关注用户openid列表失败：{}", e);
        } 
        JSONObject userInfo = JSONObject.parseObject(resData);
        return userInfo;
    }


    @Override
    public JSONObject getUserInfoList(List<String> openids) {
        String requestUrl = Constants.WX_BATCH_USER_INFO_URL;
        JSONObject obj = new JSONObject();
        JSONArray openidArray = new JSONArray();
        for(Object openid:openids) {
            JSONObject idObj = new JSONObject();
            idObj.put("openid", openid);
            idObj.put("lang", "zh_CN");
            openidArray.add(idObj);
        }
        obj.put("user_list", openidArray);
        requestUrl = requestUrl.replace("TOKEN", getTokenString(""));
        JSONObject resData = null;
        try {
            resData = HttpClientUtil.postPay(requestUrl, new HashMap(), obj);
        } catch (Exception e) {
            log.error("获取微信用户信息失败：{}", e);
        }         
        return resData;
    }
    
    private String refreshToken(String token) {
        String openid = "oubMLxFSuvldkBswSmo404qUypWY";
        String requestUrl = Constants.WX_USER_INFO_URL;
        requestUrl = requestUrl.replace("TOKEN", token).replace("OPENID", openid);
        String resData = null;
        try {
            resData = HttpClientUtil.doGet(requestUrl);
        } catch (Exception e) {
            log.error("验证token失败", e);
        }
        JSONObject userInfo = JSONObject.parseObject(resData);
        Integer errCode = userInfo.getInteger("errcode");
        if (ValidateUtil.isNotEmpty(errCode) && 40001==errCode) {
            LambdaQueryWrapper<WeixinAccountConfig> queryWrapper = new QueryWrapper<WeixinAccountConfig>().lambda();
            queryWrapper.eq(WeixinAccountConfig::getAlias, "WEIXIN_H5");
            WeixinAccountConfig account = weixinAccountConfigServiceImpl.getBaseMapper().selectOne(queryWrapper);

            String requestTokenUrl = Constants.WX_GZH_ACCESS_TOKEN_URL;
            requestUrl = requestTokenUrl.replace("APPID", account.getAppid()).replace("SECRET", account.getAppSecret());
            String resDataToken = null;
            try {
                resDataToken = HttpClientUtil.doGet(requestTokenUrl);
            } catch (Exception e) {
                log.error("获取微信token失败：{}", e);
            }
            JSONObject tokenObj = JSONObject.parseObject(resDataToken);
            redisClient.del(Constants.WX_ACCESS_TOKEN);
            redisClient.set(Constants.WX_ACCESS_TOKEN, tokenObj.getString("access_token"),
                    tokenObj.getIntValue("expires_in") - 1200);
            return tokenObj.getString("access_token");
        }else {
            return token;
        }
    }

}
