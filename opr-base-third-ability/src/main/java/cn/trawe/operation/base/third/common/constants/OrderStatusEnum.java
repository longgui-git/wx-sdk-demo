package cn.trawe.operation.base.third.common.constants;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

	DEFAULT(0, "0", "初始状态"),

	ORDER_SAVE(1, "1", "录入信息保存成功"),

	ORDER_SUBMIT(4, "4", "订单提交成功"),
	
	AUDIT_FAIL(10, "10", "审核失败");

	private int status;
	
	private String value;

	private String desc;

	OrderStatusEnum(int status, String value, String desc) {
		this.status = status;
		this.value = value;
		this.desc = desc;
	}

}
