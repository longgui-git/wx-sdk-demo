package cn.trawe.operation.base.third.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@ConfigurationProperties(prefix = "wx.defalut")
@Component
public class WxDefaultProperties {
    private String appId;

}
