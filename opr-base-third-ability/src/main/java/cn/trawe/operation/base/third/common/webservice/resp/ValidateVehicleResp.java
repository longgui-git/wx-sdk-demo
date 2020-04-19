package cn.trawe.operation.base.third.common.webservice.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "车牌申请办理响应信息")
@Data
public class ValidateVehicleResp {

	@ApiModelProperty(value = "申请表ID")
	private String ucid;

	@ApiModelProperty(value = "是否有数据")
	private String whetherData;

	@ApiModelProperty(value = "校验码")
	private String verifyKey;

	@ApiModelProperty(value = "车主姓名")
	private String cardName;

	@ApiModelProperty(value = "机动车所有人证件号")
	private String ownerIdNum;

	@ApiModelProperty(value = "机动车所有人地址")
	private String address;

	@ApiModelProperty(value = "车长")
	private String vehSizeL;

	@ApiModelProperty(value = "车宽")
	private String vehSizeW;

	@ApiModelProperty(value = "车高")
	private String vehSizeH;
	
	@ApiModelProperty(value = "外廓尺寸（长×宽×高）")
	private String overallDimension;

	@ApiModelProperty(value = "车轴数")
	private String axisNum;

	@ApiModelProperty(value = "注册时间")
	private String registerDate;

	@ApiModelProperty(value = "车辆识别代码")
	private String vin;

	@ApiModelProperty(value = "行驶证车辆类型")
	private String vehicleType;

	@ApiModelProperty(value = "车辆发动机号")
	private String engineNo;

	@ApiModelProperty(value = "发证日期")
	private String issueDate;

	@ApiModelProperty(value = "核定载人数")
	private String approvedCount;

	@ApiModelProperty(value = "座位数")
	private String seats;

	@ApiModelProperty(value = "总质量")
	private String grossMass;

	@ApiModelProperty(value = "核定载质量")
	private String approvedLoad;

	@ApiModelProperty(value = "车辆品牌")
	private String model;

}
