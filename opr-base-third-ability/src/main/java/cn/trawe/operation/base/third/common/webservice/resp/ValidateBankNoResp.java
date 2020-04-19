package cn.trawe.operation.base.third.common.webservice.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "获取银行验证码响应信息")
@Data
public class ValidateBankNoResp {

	@ApiModelProperty(value = "新开户还是增加车", notes = "弃用")
	private String isadd;

	@ApiModelProperty(value = "脱敏手机号码")
	private String cardphone;

	@ApiModelProperty(value = "银行短信流水号")
	private String bankSerialNo;

}
