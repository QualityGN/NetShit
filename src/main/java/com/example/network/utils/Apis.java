package com.example.network.utils;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
public class Apis {
    public static String gns_url="http://192.168.1.12:80";
    public static String sendPOSTRequest(String url, JSONObject jsonObject) {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 将请求头部和参数合成一个请求
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(jsonObject, headers);
        // 执行HTTP请求，将返回的结构使用String类格式化
        ResponseEntity<String> response = client.exchange(gns_url+url, method, requestEntity, String.class);
        return response.getBody();
    }
    public static String sendDeleteRequest(String url) {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.DELETE;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 执行HTTP请求，将返回的结构使用String类格式化
        ResponseEntity<String> response = client.exchange(gns_url+url, method, null, String.class);
        return response.getBody();
    }

}