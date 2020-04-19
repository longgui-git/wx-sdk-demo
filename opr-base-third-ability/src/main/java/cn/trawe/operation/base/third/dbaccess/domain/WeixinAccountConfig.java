package cn.trawe.operation.base.third.dbaccess.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("weixin_account_config")
public class WeixinAccountConfig implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自增主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 应用ID
     */
    private String appid;

    /**
     * 应用别名
     */
    private String alias;

    /**
     * 密钥
     */
    private String appSecret;

    /**
     * token
     */
    private String token;

    /**
     * aes key
     */
    private String aesKey;

    /**
     * 是否加密
     */
    private Integer isEncrypt;

    /**
     * 通知回调地址
     */
    private String notifyUrl;

    /**
     * 账号状态：VALID，INVALID
     */
    private String state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
