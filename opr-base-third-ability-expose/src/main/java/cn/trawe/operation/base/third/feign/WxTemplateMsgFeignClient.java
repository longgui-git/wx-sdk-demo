package cn.trawe.operation.base.third.feign;

import cn.trawe.operation.base.third.api.WxTemplateMsgApi;
import cn.trawe.operation.base.third.constants.Constants;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = Constants.SERVICE_NAME)
public interface WxTemplateMsgFeignClient extends WxTemplateMsgApi {

}
