package cn.trawe.operation.base.third.msg.request;

import lombok.Data;

@Data
public class WxAuthCodeRequest {
    private String code;
    private String authType="userinfo";  //userinfo：微信显示授权，base：微信静默授权
}
