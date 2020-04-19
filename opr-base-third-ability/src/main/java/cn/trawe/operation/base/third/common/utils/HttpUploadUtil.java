package cn.trawe.operation.base.third.common.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpUploadUtil.java
 * 
 * @Description: 上传图片到重庆ETC服务器工具类
 *
 * @Author: puqiang
 *
 * @Date 2019-03-12
 *
 */

public class HttpUploadUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpUploadUtil.class);

	public static String postFile(String url, String fileName, byte[] fileContent) {
		OutputStream out = null;
		BufferedReader reader = null;
		try {
			URL urlObj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			// 设置关键值
			con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false); // post方式不能使用缓存
			// 设置请求头信息
			con.setRequestProperty("charset", "UTF-8");
			con.setRequestProperty("accept", "application/json");
			con.setRequestProperty("Content-length", String.valueOf(fileContent.length));
			// 设置边界
			String BOUNDARY = "----------" + System.currentTimeMillis();
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			// 请求正文信息
			// 第一部分：
			StringBuilder sb = new StringBuilder();
			sb.append("--"); // 必须多两道线
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + fileName + "\"\r\n");
			sb.append("Content-Type:application/octet-stream\r\n\r\n");
			byte[] head = sb.toString().getBytes("utf-8");
			out = new DataOutputStream(con.getOutputStream());// 获得输出流
			out.write(head);// 输出表头
			out.write(fileContent);// 把文件流 推入到url中
			// 结尾部分
			byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
			out.write(foot);
			// 返回值
			StringBuffer strBuf = new StringBuffer();
			System.out.println("ResponseCode：" + con.getResponseCode());
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				strBuf.append(line).append("\n");
			}
			return strBuf.toString();
		} catch (IOException e) {
			logger.error("img_upload上传图片失败：{}", e);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				logger.error("img_upload关闭IO流时异常：{}", e);
			}
		}
		return null;
	}
}
