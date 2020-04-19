/**
 * ValidateCodeGenUtil.java
 * 2018年12月04日
 * ©2015-2018 北京特微智能科技有限公司. All rights reserved.
 */
package cn.trawe.operation.base.third.common.utils;

/**
 * 验证码生成工具类
 * @Author liangshenghui
 * @Date 2018年12月04日
 */
public class ValidateCodeGenUtil {

    private static final String OPTIONAL_CHARACTER = "123456789";
    private static final int OPTIONAL_LENGTH_6 = 6;

    private ValidateCodeGenUtil() {}

    /**
     * 生成6位长度的验证码，纯数字验证码
     * @return
     */
    public static String gen() {
        return gen(OPTIONAL_LENGTH_6);
    }

    /**
     * 生成指定长度的验证码，纯数字验证码
     * @param size
     * @return
     */
	public static String gen(int size) {
        String optional = OPTIONAL_CHARACTER;
        StringBuilder sb = new StringBuilder();
        int len = optional.length() - 1;
        double r;
        for (int i = 0; i < size; i++) {
            r = (Math.random()) * len;
            sb.append(optional.charAt((int) r));
        }
        return sb.toString();
    }

}
