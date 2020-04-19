package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import cn.trawe.operation.base.third.common.sensitive.SensitiveInfo;
import cn.trawe.operation.base.third.common.sensitive.SensitiveType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "获取短信验证码")
@Getter
@Setter
public class MobileSmsCodeRequest extends IssueBaseRequest {

	@ApiModelProperty(value = "订单号", required = true)
	@NotBlank(message = "订单号不能为空或null")
	private String orderNo;

	@SensitiveInfo(SensitiveType.MOBILE_PHONE)
	@ApiModelProperty(value = "联系电话", required = true)
	@NotBlank(message = "联系电话不能为空或null")
	@Pattern(regexp = "^1[3-9][0-9]{9}$", message = "联系电话格式不正确（目前仅支持手机号）")
	private String mobile;

}
