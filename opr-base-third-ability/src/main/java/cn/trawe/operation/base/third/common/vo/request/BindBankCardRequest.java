package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import cn.trawe.operation.base.third.common.sensitive.SensitiveInfo;
import cn.trawe.operation.base.third.common.sensitive.SensitiveType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "绑定银行卡")
@Getter
@Setter
public class BindBankCardRequest extends IssueBaseRequest {

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

	@ApiModelProperty(value = "短信验证码", required = true)
	@NotBlank(message = "短信验证码不能为空或null")
	private String bankSmsCode;

	@ApiModelProperty(value = "银行短信流水号", required = true)
	@NotBlank(message = "银行短信流水号不能为空或null")
	private String bankSerialNo;

}
