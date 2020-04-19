/**
 * 2019年8月19日
 * Copyright ©2015-2019 北京特微智能科技有限公司. All rights reserved.
 * 特微智能专有/机密 使用须遵守许可条款.
 */

package cn.trawe.operation.base.third.wxclient.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Song Qi
 * @Description http client util
 * @date 2019/9/9
 */
@Slf4j
public class HttpClientUtil {
    private static CloseableHttpClient httpclient;
    private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
    private static final int DEFAULT_TIME_OUT = 30000;

    private HttpClientUtil(){
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * get请求
     *
     * @return
     */
    public static String doGet(String url) {
        String result = null;
        CloseableHttpResponse httpResp = null;
        try {
            httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            //设置请求和传输超时时间
            httpGet.setConfig(requestConfig);
            httpResp = httpclient.execute(httpGet);
            int statusCode = httpResp.getStatusLine().getStatusCode();
            // 判断是够请求成功
            if (statusCode == HttpStatus.SC_OK) {
                // 获取返回的数据
                result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
                log.info("请求成功!", result);
            } else {
                log.info("HttpGet方式请求失败!", httpResp.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            log.error("httpGet", e);
        } finally {
            try {
                if (httpResp != null) {
                    httpResp.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (Exception e) {
                log.error("httpGet", e);
            }
        }
        return result;
    }

    /**
     * Post:访问数据库并返回数据字符串
     *
     * @param params 向服务器端传的参数
     * @param url
     * @return String 数据字符串
     * @throws Exception
     */
    public static String doPost(List<NameValuePair> params, String url) {
        String result = null;
        CloseableHttpResponse httpResp = null;
        try {
            httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            //设置请求和传输超时时间
            httpPost.setConfig(requestConfig);
            httpResp = httpclient.execute(httpPost);
            int statusCode = httpResp.getStatusLine().getStatusCode();
            // 判断是够请求成功
            if (statusCode == HttpStatus.SC_OK) {
                // 获取返回的数据
                result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
                log.info("请求成功!", result);
            } else {
                log.info("状态码:"
                        + httpResp.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            log.error("httpGet", e);
        } finally {
            try {
                if (httpResp != null) {
                    httpResp.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (Exception e) {
                log.error("httpGet", e);
            }
        }
        return result;
    }
    
    public static Integer postMap(String url, Map<String, String> headerMap, JSONObject json) {
        Integer code = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(DEFAULT_TIME_OUT)
                .setConnectionRequestTimeout(DEFAULT_TIME_OUT).setSocketTimeout(DEFAULT_TIME_OUT).build();
        post.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            for (Entry<String, String> elem : headerMap.entrySet()) {
                post.addHeader(elem.getKey(), elem.getValue());
            }
            StringEntity reqEntity = new StringEntity(json.toJSONString(), StandardCharsets.UTF_8);
            post.setEntity(reqEntity);

            log.info("The http request header to be sent is {}", Arrays.toString(post.getAllHeaders()));
            log.info("The http request body to be sent is {}", JSON.toJSONString(json));

            // 发送请求并接收返回数据
            response = httpClient.execute(post);

            if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 获取response的body部分
                HttpEntity entity = response.getEntity();
                // 读取response的body部分并转化成JSONObject
                JSONObject resultJsonObject = JSON.parseObject(EntityUtils.toString(entity));
                log.info("The http response is {}", JSON.toJSONString(resultJsonObject));
                code = resultJsonObject.getInteger("code");
            }
            return code;
        } catch (IOException e) {
            log.error("httpPost", e);
        } finally {
            try {
                httpClient.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error("httpPost", e);
            }
        }
        return null;
    }

    public static JSONObject postPay(String url, Map<String, String> headerMap, JSONObject json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(DEFAULT_TIME_OUT)
                .setConnectionRequestTimeout(DEFAULT_TIME_OUT).setSocketTimeout(DEFAULT_TIME_OUT).build();
        post.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        JSONObject resultJsonObject = null;
        try {
            for (Entry<String, String> elem : headerMap.entrySet()) {
                post.addHeader(elem.getKey(), elem.getValue());
            }
            StringEntity reqEntity = new StringEntity(json.toJSONString(), StandardCharsets.UTF_8);
            post.setEntity(reqEntity);

            log.info("The http request header to be sent is {}", Arrays.toString(post.getAllHeaders()));
            log.info("The http request body to be sent is {}", JSON.toJSONString(json));

            // 发送请求并接收返回数据
            response = httpClient.execute(post);

            if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 获取response的body部分
                HttpEntity entity = response.getEntity();
                // 读取response的body部分并转化成JSONObject
                resultJsonObject = JSON.parseObject(EntityUtils.toString(entity));
                log.info("The http response is {}", JSON.toJSONString(resultJsonObject));
            }
            return resultJsonObject;
        } catch (IOException e) {
            log.error("httpPost", e);
        } finally {
            try {
                httpClient.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error("httpPost", e);
            }
        }
        return resultJsonObject;
    }
    public static void main(String[] args) {
//        String url = "http://api.kakahui.net/lanjinrong-wechat-customer/api/v1/tewei/notify/heika";
//        String mobile = "13876534589";
//        String transactionId = "77970868721946624";
//        
//        Map<String, String> headers = new HashMap<>();
//        long timeStamp = System.currentTimeMillis();
//        Date dateS = new Date();
//        headers.put("Content-Type", "application/json");
//        headers.put("timestamp", String.valueOf(timeStamp));
//        
//        log.info("原始请求参数：");
//        log.info("timeStamp is {}", timeStamp);
//        log.info("privateKey is {}", "29fcab89ba4e63a60b50302801060f33c3a3aa1a");
//        log.info("mobile is {}", mobile);
//        log.info("status is {}", "1");
//        log.info("status_time is {}", DateUtils.format(dateS, DateUtils.YYYY_MM_DD_HH_MM_SS));
//        log.info("transactionId is {}", transactionId);
//
//        String timeStampSign = Base64.encodeBase64String(String.valueOf(timeStamp).getBytes());
//        String privateKey = DigestUtils.md5Hex("29fcab89ba4e63a60b50302801060f33c3a3aa1a");
//        headers.put("sign", DigestUtils.md5Hex(timeStampSign + privateKey + mobile + "1"
//                + DateUtils.format(dateS, DateUtils.YYYY_MM_DD_HH_MM_SS) + transactionId));
//
//        log.info("sign加密参数：");
//        log.info("base64(timestamp) is {}", timeStampSign);
//        log.info("md5(私钥) is {}", privateKey);
//        log.info("mobile的值 is {}", mobile);
//        log.info("status的值 is {}", "1");
//        log.info("status_time的值 is {}", DateUtils.format(dateS, DateUtils.YYYY_MM_DD_HH_MM_SS));
//        log.info("transactionId的值 is {}", transactionId);
//
//        log.info("sign is {}", DigestUtils.md5Hex(timeStampSign + privateKey + mobile + "1"
//                + DateUtils.format(dateS, DateUtils.YYYY_MM_DD_HH_MM_SS) + transactionId));
//
//        JSONObject postData = new JSONObject();
//        postData.put("transactionId", transactionId);
//        postData.put("mobile", mobile);
//        postData.put("status", "1");
//        postData.put("status_time", DateUtils.format(dateS, DateUtils.YYYY_MM_DD_HH_MM_SS));
//        log.info("response is {}", postMap(url, headers, postData));
    }
}

