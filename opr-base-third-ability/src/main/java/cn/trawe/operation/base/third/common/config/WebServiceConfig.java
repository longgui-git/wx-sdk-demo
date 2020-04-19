package cn.trawe.operation.base.third.common.config;

public class WebServiceConfig {

	// webservice method
	public static final String webserviceMethod = "deal";
	
	// webservice bank_no
	public static final String webserviceBankNo = "05";
	
	// webservice 标志 1客2货
	public static final String webserviceCarFlag = "1";

	// openid
//	public static String webserviceWechatacct = "chongqinggateway";
//	public static final String webserviceWechatacct = "oOlL1t9wbIguXzAYhLoztVLbJ9tM";

	// 接口编号020010
	public static final String webserviceModuleID1 = "020010";

	// 接口编号120010
	public static final String webserviceModuleID2 = "120010";

	// 渠道id
//	public static final String webserviceAppID = "0003";
	public static final String webserviceAppID = "WECHAT";

	// 签约类型 - 车辆校验-客车
	public static final String wsValidateCarType = "170000";
	
	// 签约类型 - 车辆校验-货车
	public static final String wsValidateTruckType = "120600";
	
	// 签约类型 - 银行卡号校验
	public static final String wsValidateBankNoType = "110000";
	
	// 签约类型 - 银行卡号校验
	public static final String wsValidateSMSCodeType = "119900";

	// 签约类型 - 客户录入信息保存
	public static final String wsOrderSubmitType = "120700";
	
	// 签约类型 - 更新图片
	public static final String wsImageUploadType = "120800";

	// 签约类型 - 进度查询
	public static final String wsProgressQueryType = "140000";

	// 错误码 0-成功 1-失败
	public static final String respSuccessCode = "0";
	
	//错误码 0-成功 1-失败
	public static final String respFailCode = "1";

}
