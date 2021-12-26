package com.example.topology_end;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TelnetClientController {
    @RequestMapping(value = "/")
    public String hello() {
        return "动态路由后端，Running on http://localhost:8999/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String telnet_login(@RequestBody JSONObject data) {
        //login device
        Logger logger = LoggerFactory.getLogger(TelnetClientController.class);
        logger.info("POST Request, telnet login");

        String dev_no = (String) data.get("dev_no");
        String ip = (String) data.get("ip");
        String pwd = (String) data.get("pwd");
        return TopologyEndApplication.telnet_controller.telnet_login(dev_no, ip, pwd);
    }

    @RequestMapping(value = "/init/serial", method = RequestMethod.POST)
    public String init_serial(@RequestBody JSONObject data) {
        //login device
        Logger logger = LoggerFactory.getLogger(TelnetClientController.class);
        logger.info("POST Request, init serial");

        String dev_no = (String) data.get("dev_no");
        JSONArray json_ip_list = data.getJSONArray("ip_list");
        String[] ip_list = get_stringArray_from_jsonArray(json_ip_list);

        JSONArray json_mask_list = data.getJSONArray("mask_list");
        String[] mask_list = get_stringArray_from_jsonArray(json_mask_list);

        return TopologyEndApplication.telnet_controller.init_serial(dev_no, ip_list, mask_list);
    }


    @RequestMapping(value = "/init/loopback", method = RequestMethod.POST)
    public String init_loopback(@RequestBody JSONObject data) {
        //login device
        Logger logger = LoggerFactory.getLogger(TelnetClientController.class);
        logger.info("POST Request, init loopback");

        String dev_no = (String) data.get("dev_no");
        String port = (String) data.get("port");
        String ip = (String) data.get("ip");
        String mask = (String) data.get("mask");

        return TopologyEndApplication.telnet_controller.init_loopback(dev_no, port, ip, mask);
    }


    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String get_info(@RequestBody JSONObject data) {
        //login device
        Logger logger = LoggerFactory.getLogger(TelnetClientController.class);
        logger.info("POST Request, get device info");

        String dev_no = (String) data.get("dev_no");

        return TopologyEndApplication.telnet_controller.get_info(dev_no);
    }

    @RequestMapping(value = "/config/rip", method = RequestMethod.POST)
    public String config_rip(@RequestBody JSONObject data) {
        //login device
        Logger logger = LoggerFactory.getLogger(TelnetClientController.class);
        logger.info("POST Request, config rip");
        JSONObject result = new JSONObject();
        String dev_no = (String) data.get("dev_no");
        JSONArray json_network_list = data.getJSONArray("network_list");
        String[] network_list = get_stringArray_from_jsonArray(json_network_list);

        JSONArray json_mask_list = data.getJSONArray("mask_list");
        String[] mask_list = get_stringArray_from_jsonArray(json_mask_list);

        return TopologyEndApplication.telnet_controller.config_rip(dev_no, network_list, mask_list);
    }

    @RequestMapping(value = "/config/ospf", method = RequestMethod.POST)
    public String config_ospf(@RequestBody JSONObject data) {
        //login device
        Logger logger = LoggerFactory.getLogger(TelnetClientController.class);
        logger.info("POST Request, config rip");
        JSONObject result = new JSONObject();
        String dev_no = (String) data.get("dev_no");
        JSONArray json_network_list = data.getJSONArray("network_list");
        String[] network_list = get_stringArray_from_jsonArray(json_network_list);

        JSONArray json_area_list = data.getJSONArray("area_list");
        String[] area_list = get_stringArray_from_jsonArray(json_area_list);

        JSONArray json_mask_list = data.getJSONArray("mask_list");
        String[] mask_list = get_stringArray_from_jsonArray(json_mask_list);

        return TopologyEndApplication.telnet_controller.config_ospf(dev_no, network_list, mask_list, area_list);

    }

    @RequestMapping(value = "/ping", method = RequestMethod.POST)
    public String ping(@RequestBody JSONObject data) {
        //login device
        Logger logger = LoggerFactory.getLogger(TelnetClientController.class);
        logger.info("POST Request, ping");
        JSONObject result = new JSONObject();
        String dev_no = (String) data.get("dev_no");
        String ip = (String) data.get("ip");

        return TopologyEndApplication.telnet_controller.ping(dev_no, ip);
    }


    private String[] get_stringArray_from_jsonArray(JSONArray jsonArray) {
        String[] result = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            result[i] = (String) jsonArray.get(i);
        }
        return result;
    }
}