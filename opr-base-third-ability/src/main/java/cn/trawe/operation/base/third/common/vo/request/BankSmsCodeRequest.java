package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import cn.trawe.operation.base.third.common.sensitive.SensitiveInfo;
import cn.trawe.operation.base.third.common.sensitive.SensitiveType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "获取银行验证码")
@Getter
@Setter
public class BankSmsCodeRequest extends IssueBaseRequest {

	@ApiModelProperty(value = "订单号", required = true)
	@NotBlank(message = "订单号不能为空或null")
	private String orderNo;

	@ApiModelProperty(value = "银行编码", required = true)
	@NotBlank(message = "银行编码不能为空或null")
	private String bankNo;

	@SensitiveInfo(SensitiveType.BANK_CARD)
	@ApiModelProperty(value = "银行卡号", required = true)
	@NotBlank(message = "银行卡号不能为空或null")
	@Pattern(regexp = "^\\d{16,19}$", message = "银行卡号格式不正确")
	private String bankCardNo;

	@SensitiveInfo(SensitiveType.CHINESE_NAME)
	@ApiModelProperty(value = "持卡人姓名", required = true)
	@NotBlank(message = "持卡人姓名不能为空或null")
	@Pattern(regexp = "^([a-zA-Z0-9\u4e00-\u9fa5\\·]{1,30})$", message = "持卡人姓名格式不正确")
	private String bankUserName;

	@SensitiveInfo(SensitiveType.MOBILE_PHONE)
	@ApiModelProperty(value = "银行预留手机号", required = true)
	@NotBlank(message = "银行预留手机号不能为空或null")
	@Pattern(regexp = "^1[3-9][0-9]{9}$", message = "银行预留手机号格式不正确")
	private String bankMobile;

}
