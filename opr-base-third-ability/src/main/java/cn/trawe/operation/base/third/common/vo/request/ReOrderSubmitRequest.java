package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "订单重新提交")
@Getter
@Setter
public class ReOrderSubmitRequest {
	
	@ApiModelProperty(value = "订单号", required = true)
	@NotBlank(message = "订单号不能为空或null")
	private String orderNo;

	@ApiModelProperty(value = "用户唯一标识", required = true)
	@NotBlank(message = "用户唯一标识不能为空或null")
	String openid;

}
