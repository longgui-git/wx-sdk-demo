package cn.trawe.operation.base.third.common.config;

import cn.trawe.operation.base.third.dbaccess.domain.WeixinAccountConfig;
import cn.trawe.operation.base.third.dbaccess.service.impl.WeixinAccountConfigServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WxConfiguration {

    @Autowired
    private WeixinAccountConfigServiceImpl weixinAccountConfigService;

    @Bean
    public WxMpProperties initWxProperties() {

        List<WeixinAccountConfig> accountConfigs = weixinAccountConfigService.list();

        WxMpProperties wxMpProperties = new WxMpProperties();
        List<WxMpProperties.MpConfig> configs = new ArrayList<>();

        for (WeixinAccountConfig weixinAccountConfig : accountConfigs) {
            WxMpProperties.MpConfig mpConfig = new WxMpProperties.MpConfig();
            mpConfig.setAppId(weixinAccountConfig.getAppid());
            mpConfig.setSecret(weixinAccountConfig.getAppSecret());
            mpConfig.setToken(weixinAccountConfig.getToken());
            mpConfig.setAesKey(weixinAccountConfig.getAesKey());

            configs.add(mpConfig);
        }

        wxMpProperties.setConfigs(configs);

        return wxMpProperties;
    }
}
