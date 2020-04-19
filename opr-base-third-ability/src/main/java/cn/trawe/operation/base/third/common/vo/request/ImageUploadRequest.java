package cn.trawe.operation.base.third.common.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "图片上传")
@Getter
@Setter
public class ImageUploadRequest extends IssueBaseRequest {

	@ApiModelProperty(value = "订单号", required = true)
	@NotBlank(message = "订单号不能为空或null")
	String orderNo;

	@ApiModelProperty(value = "图片类型 1-身份证正面 2-行驶证 3-车前45度照（同车头照） 4-车辆侧身照 5-车辆登记证书 6-道路运输证 7-车头照（弃用）", required = true)
	@NotNull(message = "图片类型不能为null")
	Integer imageType;

	@JSONField(serialize = false)
	@ApiModelProperty(value = "文件1Base64字符串", required = true)
	@NotBlank(message = "Base64字符串不能为空或null")
	String base64Str;

	@JSONField(serialize = false)
	@ApiModelProperty(value = "文件2Base64字符串")
	String base64Str2;

}
