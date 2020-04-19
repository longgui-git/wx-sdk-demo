/**
 * 2019年8月19日
 * Copyright ©2015-2019 北京特微智能科技有限公司. All rights reserved.
 * 特微智能专有/机密 使用须遵守许可条款.
 */

package cn.trawe.operation.base.third.wxclient.constants;

/**
 * description:
 * 常量管理类
 *
 * @author zxg
 * @date 2019.8.19
 */
public class Constants {

    /**
     * 获取微信CODE链接
     */
    public static final String WX_REQUEST_AUTH_CODE_URL = "https://open.weixin.qq.com/connect/qrconnect?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE";

    /**
     * 获取微信开放平台access_token链接
     */
    public static final String WX_OPEN_PLATFORM_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    /**
     * 微信access-token key
     */
    public static final String WX_ACCESS_TOKEN_KEY = "vehicleowner:weixin:access-token:{0}";

    /**
     * 获取微信用户基本信息链接
     */
    public static final String WX_REQUEST_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";

    /**
     * 获取微信小程序access_token链接
     */
    public static final String WX_MINI_PROGRAM_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 微信小程序登录凭证校验链接
     */
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";


    /**
     * 获取支付宝CODE链接
     */
    public static final String ALIPAY_REQUEST_AUTH_CODE_URL = "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=APPID&scope=SCOPE&redirect_uri=ENCODED_URL&state=STATE";

    /**
     * 获取支付宝CODE链接
     */
    public static final String ALIPAY_REQUEST_GATEWAY_URL = "https://openapi.alipay.com/gateway.do;";

    /**
     * 状态 有效：VALID
     */
    public static final String VALID_NAME = "VALID";

    /**
     * 状态 无效：INVALID
     */
    public static final String INVALID_NAME = "INVALID";
    
    public static final String WX_GZH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
    
    public static final String WX_ACCESS_TOKEN = "WX_ACCESS_TOKEN";
    
    public static final String WX_MEMBER_USER_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=TOKEN&next_openid=OPENID";
    
    public static final String WX_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=TOKEN&openid=OPENID&lang=zh_CN";
    
    public static final String GET_USER_LIST_TASK = "GET_USER_LIST_TASK";
    
    public static final String WX_BATCH_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=TOKEN";
    
    public static final String WX_LAST_OPENID = "WX_LAST_OPENID";
}
