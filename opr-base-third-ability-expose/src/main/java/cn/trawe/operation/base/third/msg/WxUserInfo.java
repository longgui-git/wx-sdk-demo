package cn.trawe.operation.base.third.msg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxUserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * unionid
     */
    private String unionid;

    /**
     * openid
     */
    private String openid;

    /**
     * 微信昵称
     */
    private String nickName;

    /**
     * 头像地址
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
     * 语言
     */
    private String language;

    public void setGender(String sex){
        if(sex!=null && "".equals(sex.trim())){
            this.gender=Integer.parseInt(sex);
        }
        else
            this.gender=0;
    }
}
