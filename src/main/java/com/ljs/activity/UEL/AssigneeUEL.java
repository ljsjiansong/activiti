package com.ljs.activity.UEL;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * 启动流程实例，动态设置assignee
 */
public class AssigneeUEL {
    public static void main(String[] args) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 得到RuntimeService
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();

        // 设置assignee的取值。用户可以在界面上设置流程的执行人
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("assignee0","zhangsan");
        map.put("assignee1","lisi");
        map.put("assignee2","wangwu");

        // 启动流程实例,同时设定流程定义assignee的值
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday", map);

    }
}

