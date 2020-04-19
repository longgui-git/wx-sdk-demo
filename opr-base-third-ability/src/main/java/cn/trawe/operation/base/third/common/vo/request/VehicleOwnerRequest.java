package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import cn.trawe.operation.base.third.common.sensitive.SensitiveInfo;
import cn.trawe.operation.base.third.common.sensitive.SensitiveType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "车主信息保存")
@Getter
@Setter
public class VehicleOwnerRequest extends IssueBaseRequest {

	@ApiModelProperty(value = "订单号", required = true)
	@NotBlank(message = "订单号不能为空或null")
	private String orderNo;

	@SensitiveInfo(SensitiveType.CHINESE_NAME)
	@ApiModelProperty(value = "用户姓名", required = true)
	@NotBlank(message = "用户姓名不能为空或null")
//	@Pattern(regexp = "^([a-zA-Z0-9\u4e00-\u9fa5\\·]{1,30})$", message = "持卡人姓名格式不正确")
	private String userName;

	@SensitiveInfo(SensitiveType.ID_CARD)
	@ApiModelProperty(value = "身份证号", required = true)
	@NotBlank(message = "身份证号不能为空或null")
	@Pattern(regexp = "(^([1-6][1-9]|50)\\d{4}\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}$)|(^([1-6][1-9]|50)\\d{4}(18|19|20)\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}[0-9X]$)", message = "身份证号格式不正确")
	private String idCardNo;

}
