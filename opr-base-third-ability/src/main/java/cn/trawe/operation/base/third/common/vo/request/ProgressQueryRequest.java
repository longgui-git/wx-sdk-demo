package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "办理进度查询")
@Getter
@Setter
public class ProgressQueryRequest {

	@ApiModelProperty(value = "用户唯一标识", required = true)
	String openid;

	@ApiModelProperty(value = "车牌号", required = true)
	@NotBlank(message = "车牌号不能为空或null")
	String plateNo;

	@ApiModelProperty(value = "车牌颜色", required = true)
	@NotNull(message = "车牌颜色不能为null")
	Integer plateColor;
}
