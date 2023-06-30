package com.example.network.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.alibaba.druid.util.HttpClientUtils;
import com.example.network.VO.ResponseVO;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import com.example.network.utils.Apis;
import org.springframework.web.service.invoker.HttpClientAdapter;
import sun.net.www.http.HttpClient;

public class ProjectController {
    @PostMapping("/projects")
    public ResponseVO createProject(@RequestBody JSONObject jsonObject){
        return ResponseVO.buildSuccess(Apis.sendPOSTRequest("/v2/projects",jsonObject));
    }
    @PostMapping("/projects/{project_id}")
    public ResponseVO deleteProject(@PathVariable String project_id){
        return ResponseVO.buildSuccess(Apis.sendDeleteRequest("v2/projects/"+project_id));
    }
    @PostMapping("/projects/{project_id}/nodes")
    public ResponseVO createNode(@RequestBody JSONObject jsonObject,@PathVariable String project_id){
        return ResponseVO.buildSuccess(Apis.sendPOSTRequest("/v2/projects/"+project_id+"/nodes",jsonObject));
    }
    @DeleteMapping("/projects/{project_id}/nodes/{node_id}")
    public ResponseVO deleteNode(@PathVariable("project_id") String project_id,@PathVariable("node_id") String node_id){
        return ResponseVO.buildSuccess(Apis.sendDeleteRequest("/v2/projects/"+project_id+"/nodes/"+node_id));
    }
    @PostMapping("/projects/{project_id}/links")
    public ResponseVO createLink(@RequestBody JSONObject jsonObject,@PathVariable String project_id){
        return ResponseVO.buildSuccess(Apis.sendPOSTRequest("/v2/projects/"+project_id+"/links",jsonObject));
    }
    @DeleteMapping("/projects/{project_id}/links/{link_id}")
    public ResponseVO deleteLink(@PathVariable("project_id") String project_id,@PathVariable("link_id") String link_id){
        return ResponseVO.buildSuccess(Apis.sendDeleteRequest("/v2/projects/"+project_id+"/links/"+link_id));
    }
    @GetMapping("/projects/{project_id}/nodes/{node_id}/start")
    public ResponseVO startNode(@PathVariable("project_id") String project_id,@PathVariable("node_id") String node_id){
        return ResponseVO.buildSuccess(Apis.sendPOSTRequest("/v2/projects/"+project_id+"/nodes/"+node_id+"/start",new JSONObject()));
    }
    @GetMapping("/projects/{project_id}/nodes/{node_id}/end")
    public ResponseVO endNode(@PathVariable("project_id") String project_id,@PathVariable("node_id") String node_id){
        return ResponseVO.buildSuccess(Apis.sendPOSTRequest("/v2/projects/"+project_id+"/nodes/"+node_id+"/end",new JSONObject()));
    }
}
