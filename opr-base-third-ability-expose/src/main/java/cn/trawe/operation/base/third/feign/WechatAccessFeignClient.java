package cn.trawe.operation.base.third.feign;

import org.springframework.cloud.openfeign.FeignClient;

import cn.trawe.operation.base.third.api.WechatAccessAPI;
import cn.trawe.operation.base.third.constants.Constants;

@FeignClient(name = Constants.SERVICE_NAME)
public interface WechatAccessFeignClient extends WechatAccessAPI {

}
