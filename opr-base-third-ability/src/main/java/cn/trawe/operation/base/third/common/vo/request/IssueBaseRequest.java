package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "发行基础请求类")
@Data
public class IssueBaseRequest {

	@ApiModelProperty(value = "用户唯一标识", required = true)
	@NotBlank(message = "用户唯一标识不能为空或null")
	String openid;

	@ApiModelProperty(value = "车牌号", required = true)
	@NotBlank(message = "车牌号不能为空或null")
	String plateNo;

	@ApiModelProperty(value = "车牌颜色", required = true)
	@NotNull(message = "车牌颜色不能为null")
	Integer plateColor;

}
