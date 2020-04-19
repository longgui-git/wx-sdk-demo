package cn.trawe.operation.base.third.msg.request;

import lombok.Data;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

@Data
public class TemplateMsgSendRequest extends WxMpTemplateMessage {

    /**
     * 推送模板消息的app
     */
    private String appId;

}
