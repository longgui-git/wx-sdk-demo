package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import cn.trawe.operation.base.third.common.sensitive.SensitiveInfo;
import cn.trawe.operation.base.third.common.sensitive.SensitiveType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "订单提交")
@Getter
@Setter
public class OrderSubmitRequest extends IssueBaseRequest {

	@ApiModelProperty(value = "订单号", required = true)
	@NotBlank(message = "订单号不能为空或null")
	private String orderNo;

	@SensitiveInfo(SensitiveType.CHINESE_NAME)
	@ApiModelProperty(value = "收货人姓名", required = true)
	@NotBlank(message = "收货人姓名不能为空或null")
	@Pattern(regexp = "^[a-zA-Z\u4e00-\u9fa5\\·]{1,30}$", message = "收货人姓名仅支持中文、字母和·填写")
	private String name;

	@SensitiveInfo(SensitiveType.MOBILE_PHONE)
	@ApiModelProperty(value = "联系电话", required = true)
	@NotBlank(message = "联系电话不能为空或null")
	@Pattern(regexp = "^1[3-9][0-9]{9}$", message = "联系电话格式不正确（目前仅支持手机号）")
	private String mobile;

	@SensitiveInfo(SensitiveType.REGION)
	@ApiModelProperty(value = "收货人地区（省市县）", required = true)
	@NotBlank(message = "收货人地区不能为空或null")
	@Pattern(regexp = "^[\u4e00-\u9fa5]{1,60}$", message = "收货人地区（省市县）仅支持中文填写")
	private String region;

	@SensitiveInfo(SensitiveType.ADDRESS)
	@ApiModelProperty(value = "收货人详细地址", required = true)
	@NotBlank(message = "收货人详细地址不能为空或null")
	@Pattern(regexp = "^[a-zA-Z0-9\u4e00-\u9fa5]{1,100}$", message = "收货人详细地址仅支持由中文、数字和字母填写")
	private String address;

//	@ApiModelProperty(value = "短信验证码", required = true)
//	@NotBlank(message = "短信验证码不能为空或null")
//	@Pattern(regexp = "^[0-9]{6}$", message = "短信验证码由6位数字填写")
//	private String smsCode;

}
