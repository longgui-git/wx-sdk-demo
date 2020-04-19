package cn.trawe.operation.base.third.common.config;

import cn.trawe.operation.base.third.dbaccess.domain.WeixinAccountConfig;
import cn.trawe.operation.base.third.dbaccess.service.impl.WeixinAccountConfigServiceImpl;
import cn.trawe.pay.common.exception.TraweServiceException;
import cn.trawe.utils.ValidateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.config.impl.WxMpRedisConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Component
@Slf4j
public class WxMpServiceUtil {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private WeixinAccountConfigServiceImpl weixinAccountConfigService;

    //    @Value("${wx.defalut.appId}")
//    private String defaultAppId;
//
//    @Value("${sms.smsnurl}")
//    private String smsnurl;
    @Autowired
    private WxDefaultProperties wxDefaultProperties;

    public WxMpService getWxMpService(String appId) {
        
        if (ValidateUtil.isEmpty(appId)) {
//            log.info("wxDefaultAppId2-->"+appId);
//            log.info("smsnurl2-->"+smsnurl);
            log.info("appId" + wxDefaultProperties.getAppId());
            appId = wxDefaultProperties.getAppId();

        }

        boolean switchover = wxMpService.switchover(appId);
        if (!switchover) {
            // 切换失败，从数据库查询下
            LambdaQueryWrapper<WeixinAccountConfig> queryWrapper = new QueryWrapper<WeixinAccountConfig>().lambda();
            queryWrapper.eq(WeixinAccountConfig::getAppid, appId);
            try {
                WeixinAccountConfig one = weixinAccountConfigService.getOne(queryWrapper);
                if (ValidateUtil.isNotEmpty(one)) {
                    log.info("配置参数：" + JSON.toJSONString(one));
                    WxMpRedisConfigImpl configStorage = new WxMpRedisConfigImpl(jedisPool);
                    configStorage.setAppId(one.getAppid());
                    configStorage.setSecret(one.getAppSecret());
                    configStorage.setToken(one.getToken());
                    configStorage.setAesKey(one.getAesKey());

                    wxMpService.addConfigStorage(one.getAppid(), configStorage);

                    wxMpService.switchover(appId);
                } else {
                    log.info("无法获取appId配置1，请检查参数");
                    throw new TraweServiceException("无法获取appId配置1，请检查参数");
                }
            } catch (Exception e) {
                throw new TraweServiceException("无法获取appId配置，请检查参数");
            }

        }

        return wxMpService;
    }

}
