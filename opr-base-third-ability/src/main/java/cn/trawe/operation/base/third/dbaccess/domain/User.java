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
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自增主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 用户状态：VALID，INVALID
     */
    private String state;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别 0：未知、1：男、2：女
     */
    private Integer gender;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idNo;

    /**
     * 单位或公司名称
     */
    private String company;

    /**
     * 部门
     */
    private String department;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 关注时间
     */
    private LocalDateTime registerTime;

    /**
     * 是否关注公众号 1：已关注；2：未关注
     */
    private Integer isMember;


}
