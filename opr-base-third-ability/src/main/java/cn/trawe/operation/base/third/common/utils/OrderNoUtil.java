package cn.trawe.operation.base.third.common.utils;

import java.util.Date;
import java.util.UUID;

import cn.trawe.utils.DateUtils;

public class OrderNoUtil {

	/**
	 * 获取uuid结尾的工单编号
	 *
	 * @param type
	 * @return
	 */
	public static String getOrderNo() {
		return DateUtils.format(new Date(), "yyMMddHHmmssSSS")
				+ String.format("%05d", (int) (1 + Math.random() * 1000));
	}

	/**
	 * 32位uuid
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getUuid() {
		String uuid = UUID.randomUUID().toString(); // 转化为String对象
		uuid = uuid.replace("-", "");
		return uuid;
	}
}
