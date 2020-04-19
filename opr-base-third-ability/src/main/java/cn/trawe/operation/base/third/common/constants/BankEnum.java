package cn.trawe.operation.base.third.common.constants;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum BankEnum {

	ABC_BACK("01", "中国农业银行"),

	CCB_BACK("02", "中国建设银行"),

	HXB_BACK("03", "中国华夏银行"),

	ABC("11", "中国农业银行"),

	CCB("12", "中国建设银行"),

	HXBANK("13", "中国华夏银行"),

	CQRCB("14", "中国重庆农村商业银行"),

	PSBC("15", "中国邮政储蓄银行"),

	ICBC("16", "中国工商银行"),

	CITIC("17", "中国中信银行"),

	BOC("18", "中国银行"),

	CQBANK("19", "重庆银行"),

	CMB("20", "招商银行"),

	COMM("21", "交通银行");

	private String bankNo;

	private String bankName;

	BankEnum(String bankNo, String bankName) {
		this.bankNo = bankNo;
		this.bankName = bankName;
	}

	private static final Map<String, String> bank = new HashMap<>();

	static {
		for (BankEnum bankEnum : EnumSet.allOf(BankEnum.class)) {
			bank.put(bankEnum.getBankNo(), bankEnum.getBankName());
		}
	}

	public static String getNameByNo(String bankNo) {
		return bank.get(bankNo);
	}

}
