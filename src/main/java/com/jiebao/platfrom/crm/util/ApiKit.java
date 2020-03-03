package com.jiebao.platfrom.crm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Map;

/**
 * ApiKit 金智CRM接口调用工具类
 * 2020年02月19日
 * @copyright 2020 www.jbx.cn 湖南捷报信息技术有限公司 All rights reserved.
 * @author Kunkka
 */

public class ApiKit {

    private static final int TIMEOUT = 30000;
    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "utf-8";
    private static final String secretId = "vtF7DHXFUjRb";
    private static final String secretKey = "40e8e5b1-6f63-4395-b93b-10c03415ae20";

    /***
     * 生产Authorization 签名字段
     * @param id
     * @param type
     * @param postData
     * @return
     * @throws Exception
     */
    public static String appSign(String id, String type, String postData) throws Exception {
        String plainText = id + type + postData;
        System.out.println("plainText:" + plainText);
        byte[] hmacDigest = hmacsha1(plainText, secretKey);
        //return URLEncoder.encode(Base64Encode(hmacDigest));
        System.out.println(Base64Encode(hmacDigest));
        System.out.println(Base64Encode(hmacDigest).toUpperCase());
        String a = URLEncoder.encode(Base64Encode(hmacDigest).toUpperCase(), ENCODING);
        return a;
    }

    /***
     * 生产base64编码
     * @param binaryData
     * @return
     */
    public static String Base64Encode(byte[] binaryData) {
        String encodedstr = Base64.getEncoder().encodeToString(binaryData);
        return encodedstr;
    }

    /***
     * 生产 hmacsha1 签名
     * @param binaryData
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] HmacSha1(byte[] binaryData, String key) throws Exception {
        Mac mac = Mac.getInstance(MAC_NAME);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), MAC_NAME);
        mac.init(secretKey);
        byte[] HmacSha1Digest = mac.doFinal(binaryData);
        return HmacSha1Digest;
    }

    /***
     * 生产hmacSha1 签名
     * @param plainText
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] hmacsha1(String plainText, String key) throws Exception {
        return HmacSha1(plainText.getBytes(), key);
    }

    /**
     * 分页请求数据接口
     * @param appid
     * @param type list_simple
     * @param postMap {datatype:数据类型ID;page:分页页码;pagesize:分页数量;customerid:默认为空即可}
     * @return JSONObject类型分页数据
     */
    public static JSONObject request(String appid, String type, Map<String, String> postMap) {
        String postData = JSON.toJSONString(postMap);
        String appSign = "";
        try {
            appSign = appSign(appid, type, postData);
        }catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String payUrl = "http://crmapi.jzsoft.cn/apigetdata.aspx?sign=" + appSign + "&key=" + secretId + "&appid=" + appid + "&type=" + type;
        return httpPost(payUrl, postData);
    }

    /**
     * post请求传输String参数
     * 例如：name=Jack&sex=1&type=2
     * Content-type:application/x-www-form-urlencoded
     * @param url            url地址
     * @param strParam       参数
     * @return
     */
    public static JSONObject httpPost(String url, String strParam) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(TIMEOUT).setConnectTimeout(TIMEOUT).build();
        httpPost.setConfig(requestConfig);
        try {
            if(null != strParam) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(strParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/x-www-form-urlencoded");
                //                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // 请求发送成功，并得到响应
            if(result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }else {
                String getError = EntityUtils.toString(result.getEntity(), "utf-8");
            }
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

}

