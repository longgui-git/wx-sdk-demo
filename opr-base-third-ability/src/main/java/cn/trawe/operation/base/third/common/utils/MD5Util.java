package cn.trawe.operation.base.third.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

	public static String getMD5(File file) {
		FileInputStream fis = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			fis = new FileInputStream(file);
			byte[] buffer = new byte[8192];
			int length = -1;
			while ((length = fis.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}
	        return new BigInteger(1, md.digest()).toString(16);// 16进制数字
//			return convertToHexString(md.digest());
		} catch (IOException ex) {
			return null;
		} catch (NoSuchAlgorithmException ex) {
			return null;
		} finally {
			try {
				fis.close();
			} catch (IOException ex) {
			}
		}
	}
	public static String getMD5Two(File file) {
		try {
			return DigestUtils.md5Hex(new FileInputStream(file));
		} catch (IOException ex) {
			return null;
		}
	}

//	private static String convertToHexString(byte data[]) {
//		StringBuffer strBuffer = new StringBuffer();
//		for (int i = 0; i < data.length; i++) {
//			strBuffer.append(Integer.toHexString(0xff & data[i]));
//		}
//		return strBuffer.toString();
//	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String path = "E:\\test\\save\\test.zip";
		File file = new File(path);
		String md5 = getMD5(file);
		System.out.println(md5);
		String md52 = getMD5Two(file);
		System.out.println(md52);
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("1水水水水水水水水水水水水水水水水水".getBytes());
        byte[] digest = md.digest();
		//将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, digest).toString(16);// 16进制数字
        System.out.println(md5code);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        System.out.println(md5code);
        
	}
}
