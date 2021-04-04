package com.ljs.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 创建流程实例，启动流程实例
 */
public class ActivitiStartInstance {
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、得到RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 3、创建流程实例(必须提前得知key是什么这里是：holiday)
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday");
        // 4、输出id
        System.out.println("流程部署id:"+processInstance.getDeploymentId());
        System.out.println("流程定义id:"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例id:"+processInstance.getId());
        System.out.println("活动id:"+processInstance.getActivityId());
    }
}
