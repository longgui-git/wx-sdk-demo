package cn.trawe.operation.base.third.templatemsg.controller;

import cn.trawe.operation.base.third.api.WxTemplateMsgApi;
import cn.trawe.operation.base.third.common.config.WxMpServiceUtil;
import cn.trawe.operation.base.third.msg.ResultBody;
import cn.trawe.operation.base.third.msg.request.TemplateMsgSendRequest;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
@Slf4j
public class WxTemplateMsgController implements WxTemplateMsgApi {

    @Autowired
    private WxMpServiceUtil wxMpServiceUtil;

    @Override
    public ResultBody sendTemplateMsg(@RequestBody TemplateMsgSendRequest templateMsgSendRequest) {

        log.info("发送模板消息openId={}", templateMsgSendRequest.getToUser());

        WxMpService wxMpService = wxMpServiceUtil.getWxMpService(templateMsgSendRequest.getAppId());
        WxMpTemplateMsgService templateMsgService = wxMpService.getTemplateMsgService();
        try {
            WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
            BeanUtils.copyProperties(templateMsgSendRequest, wxMpTemplateMessage);
            String s = templateMsgService.sendTemplateMsg(wxMpTemplateMessage);
            log.info("发送模板消息返回数据",s);
            return ResultBody.ok();
        } catch (WxErrorException e) {
            log.info("发送模板消息异常",e);
            return ResultBody.failed().msg(e.getMessage());
        }
    }

    public static void main(String[] args) {

        TemplateMsgSendRequest templateMsgSendRequest = new TemplateMsgSendRequest();
        templateMsgSendRequest.setTemplateId("28ViIxZ1r6Qs8mk5uFsiGboogUi20ZudO1m0dUiVDFM");
        templateMsgSendRequest.setToUser("oubMLxK757gFCkl2EeVRDp4MD77w");
        templateMsgSendRequest.setUrl("http://www.baidu.com");

        LinkedList<WxMpTemplateData> list = new LinkedList<>();
        list.add(new WxMpTemplateData("first","特微会议信息","#173177"));
        list.add(new WxMpTemplateData("keyword1","陕西运营","#173177"));
        list.add(new WxMpTemplateData("keyword2","2020年3月09日 上午8点","#173177"));
        list.add(new WxMpTemplateData("keyword3","特微办公室","#173177"));
        list.add(new WxMpTemplateData("keyword4","很好","#173177"));
        list.add(new WxMpTemplateData("remark","请按时参加","#173177"));

        System.out.println(JSON.toJSONString(list));

        templateMsgSendRequest.setData(list);

        System.out.println(JSON.toJSONString(templateMsgSendRequest));

    }
}
