package cn.trawe.operation.base.third.common.config;

import java.text.MessageFormat;

public class RedisKeyConfig {

	/** 过期时间 60s */
	public static final int expireOneMinute = 60;

	/** 过期时间 5mins */
	public static final int expireFiveMinutes = 5 * 60;

	/** 过期时间 15mins */
	public static final int expireQuarterHour = 15 * 60;

	/** 过期时间 半小时 */
	public static final int expireHalfHour = 30 * 60;

	/** 过期时间 一小时 */
	public static final int expireOneHour = 60 * 60;

	/** 过期时间 两小时 */
	public static final int expireTwoHour = 2 * 60 * 60;

	/** 过期时间 一天 */
	public static final int expireOneDay = 24 * 60 * 60;

	/** 发行-车牌校验 key */
	public static final String issueVehicleCheckKey = "etc:issue:vehicle:check:{0}";

	/** 发行-短信验证码 key */
	public static final String issueSmsValidatCodeKey = "etc:issue:sms:validat_code:{0}";

	public static String getCheckKey(String plateNo) {
		return MessageFormat.format(RedisKeyConfig.issueVehicleCheckKey, plateNo);
	}

	public static String getSmsKey(String mobileNo) {
		return MessageFormat.format(RedisKeyConfig.issueSmsValidatCodeKey, mobileNo);
	}

}
