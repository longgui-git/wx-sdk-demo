package cn.trawe.operation.base.third.api;

import cn.trawe.operation.base.third.msg.ResultBody;
import cn.trawe.operation.base.third.msg.request.TemplateMsgSendRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wx/template-msg")
public interface WxTemplateMsgApi {

    @PostMapping("/send")
    ResultBody sendTemplateMsg(@RequestBody TemplateMsgSendRequest templateMsgSendRequest);
}
