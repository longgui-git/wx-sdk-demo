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
@TableName("weixin_bonus_pack_record")
public class WeixinBonusPackRecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自增主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 红包金额，单位：分。
     */
    private Integer recharge;

    /**
     * 状态：已发放/待发放/发放失败
     */
    private String state;

    /**
     * 发放时间
     */
    private LocalDateTime sentTime;

    /**
     * 到账时间
     */
    private LocalDateTime payTime;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 发起支付商户订单号
     */
    private String outOrderNo;

    /**
     * 微信交易订单号
     */
    private String tradeNo;

    /**
     * 红包来源
     */
    private String source;

    /**
     * 红包说明
     */
    private String remark;

    /**
     * 红包标题
     */
    private String packTitle;

    /**
     * 红包封面地址
     */
    private String packCover;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
