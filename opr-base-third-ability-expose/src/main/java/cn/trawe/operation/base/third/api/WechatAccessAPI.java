package cn.trawe.operation.base.third.api;

import java.util.List;

import cn.trawe.operation.base.third.msg.ResultBody;
import cn.trawe.operation.base.third.msg.WxUserInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

import cn.trawe.operation.base.third.msg.request.WxAuthCodeRequest;

/**
  * 微信API访问相关接口
 *
 * @author Song Qi
 * @date 2020.3.9
 */
public interface WechatAccessAPI {
    @RequestMapping(value = "/wx/userinfo", method = RequestMethod.POST)
    public ResultBody<WxUserInfo> getUserInfo(@RequestBody WxAuthCodeRequest wxAuthCode);

    //向微信发起微信授权
    //http://127.0.0.1:21090/wx/auth
    @RequestMapping(value = "/wx/auth", method = RequestMethod.POST)
    public JSONObject authLogin(@RequestBody WxAuthCodeRequest wxAuthCode);

    //向微信请求获取token
    //http://127.0.0.1:21090/wx/requesttoken
    @RequestMapping(value = "/wx/requesttoken", method = RequestMethod.GET)
    public JSONObject getAccessToken(@RequestParam(value = "alias", required = false) String alias);

    @RequestMapping(value = "/wx/requesttoken2", method = RequestMethod.GET)
    public ResultBody getAccessToken2(@RequestParam(value = "appId", required = false) String appId);

    //获取微信access_token
    //http://127.0.0.1:21090/wx/token
    @RequestMapping(value = "/wx/token", method = RequestMethod.GET)
    public JSONObject getToken(@RequestParam(value = "alias", required = false) String alias);


    //获取公众号关注微信用户列表
    //http://127.0.0.1:21090/wx/subscriberlist
    @RequestMapping(value = "/wx/subscriberlist", method = RequestMethod.GET)
    public JSONObject getSubscribeUserList(@RequestParam(value = "alias", required = false) String alias,
            @RequestParam(value = "nextopenid", required = false) String nextopenid);

    //获取单个用户信息
    //http://127.0.0.1:21090/wx/userinfo?openid=oubMLxMWJZ_mohYyZIONGkIIL_Wk
    @RequestMapping(value = "/wx/userinfo", method = RequestMethod.GET)
    public JSONObject getUserInfo(@RequestParam(value = "openid", required = true) String openid);

    //获取一组用户信息，微信限制每次最多获取100个用户的信息。
    //http://127.0.0.1:21090/wx//userinfolist
    //params: oubMLxK757gFCkl2EeVRDp4MD77w,oubMLxEWDPtdmto8AtIwI66gwmdA
    @RequestMapping(value = "/wx/userinfolist", method = RequestMethod.POST)
    public JSONObject getUserInfoList(@RequestParam(value = "openids", required = true) List<String> openids);
}
