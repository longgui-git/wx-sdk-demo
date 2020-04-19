package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "车牌申请办理")
@Getter
@Setter
public class VehicleApplyRequest extends IssueBaseRequest {

	@ApiModelProperty(value = "车型 1-客车 2-货车", required = true)
	@NotNull(message = "车型不能为null")
	Integer vehType;

}
