package cn.trawe.operation.base.third.common.webservice.req;

import lombok.Data;

@Data
public class ValidateSMSCodeReq {
	
	private String bankno;
	
	private String bankcardno;
	
	private String mobilecode;

	private String bankserialno;
	
}
