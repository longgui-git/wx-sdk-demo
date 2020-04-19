package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "行驶证信息保存")
@Getter
@Setter
public class DrivingLicenseRequest extends IssueBaseRequest {

	@ApiModelProperty(value = "订单号", required = true)
	@NotBlank(message = "订单号不能为空或null")
	private String orderNo;

	@ApiModelProperty(value = "车主姓名")
	@NotBlank(message = "车主姓名不能为空或null")
	private String owner;

	@ApiModelProperty(value = "车辆品牌")
	private String model;

	@ApiModelProperty(value = "车辆识别代码", required = true)
	@NotBlank(message = "车辆识别代码不能为空或null")
	@Pattern(regexp = "^[0-9A-Z]{17}$", message = "车辆识别代码格式不正确")//要求：17位数字和英文大写字母（不保包括I、O和Q）
	private String vin;

	@ApiModelProperty(value = "档案编号")
	private String fileNo;

	@ApiModelProperty(value = "整备质量")
	private String unladenMass;

	@ApiModelProperty(value = "准牵引总质量")
	private String tractionMass;

	@ApiModelProperty(value = " 检验记录")
	private String inspectionRecord;

	@ApiModelProperty(value = "引擎类型")
	private String energyType;

	@ApiModelProperty(value = "机动车所有人地址")
	private String address;

	@ApiModelProperty(value = "车量尺寸（长*宽*高）", required = true)
	@NotBlank(message = "车量尺寸（长*宽*高）不能为空或null")
	@Pattern(regexp = "^([1-9]\\d{0,4})\\*([1-9]\\d{0,4})\\*([1-9]\\d{0,4})$", message = "车量尺寸要求：1-5位数字*1-5位数字*1-5位数字")
	private String overallDimension;

	@ApiModelProperty(value = "车辆发动机号")
	@Pattern(regexp = "^[a-zA-Z0-9]{0,60}$", message = "车辆发动机号仅支持数字和字母填写")
	private String engineNo;

	@ApiModelProperty(value = "注册时间")
	private String registerDate;

	@ApiModelProperty(value = "发证日期")
	private String issueDate;

	@ApiModelProperty(value = "核定载人数")
	private int approvedCount = 0;

	@ApiModelProperty(value = "座位数", required = true)
	@NotNull(message = "座位数不能为空或null")
	private Integer seats;

	@ApiModelProperty(value = "车辆类型", required = true)
	@NotBlank(message = "车辆类型不能为空或null")
	@Pattern(regexp = "^[\u4e00-\u9fa5]{1,30}$", message = "车辆类型仅支持中文填写")
	private String vehicleType;

	@ApiModelProperty(value = "总质量", required = true)
	@NotBlank(message = "总质量不能为空或null")
	@Pattern(regexp = "^[1-9]\\d{0,20}$", message = "总质量仅支持数字填写并且首字母非0")
	private String grossMass;

	@ApiModelProperty(value = "核定载质量")
	private String approvedLoad;

	@ApiModelProperty(value = "车辆使用性质")
	@Pattern(regexp = "^[\u4e00-\u9fa5]{0,30}$", message = "车辆使用性质仅支持中文填写")
	private String vehicleUseCharacter;

	@ApiModelProperty(value = "车轴数", required = true)
	@NotNull(message = "车轴数不能为空或null")
	private Integer axisNum;

	@ApiModelProperty(value = "车轮数", required = true)
	@NotNull(message = "车轮数不能为空或null")
	private Integer wheelNum;

	@ApiModelProperty(value = "轴距")
	private String wheelbase;

	@ApiModelProperty(value = "轴型")
	private String axisType;

}
