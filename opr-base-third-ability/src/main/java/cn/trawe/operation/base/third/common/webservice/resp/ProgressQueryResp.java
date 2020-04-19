package cn.trawe.operation.base.third.common.webservice.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "办理进度查询响应信息")
@Data
public class ProgressQueryResp {

	@ApiModelProperty(value = "签约申请表ID")
	private String ucid;

	@ApiModelProperty(value = "当前状态")
	private String stepStatus;

	@ApiModelProperty(value = "车牌号")
	private String vehPlate;

	@ApiModelProperty(value = "车牌颜色")
	private String vehColor;

	@ApiModelProperty(value = "签约卡号")
	private String bankCardNo;

	@ApiModelProperty(value = "当前状态说明")
	private String statusText;

	@ApiModelProperty(value = "快递公司")
	private String express;

	@ApiModelProperty(value = "快递单号")
	private String expressNo;

	@ApiModelProperty(value = "错误提示")
	private String appErr;
	
	@ApiModelProperty(value = "订单号")
	private String orderNo;

}
