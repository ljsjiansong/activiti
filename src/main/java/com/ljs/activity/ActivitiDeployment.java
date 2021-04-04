package com.ljs.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

public class ActivitiDeployment {
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3、进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("holiday.bpmn") // 添加bpmn资源
                .addClasspathResource("holiday.png")  // 添加png资源
                .name("请假流程申请") // 流程名
                .deploy();//部署

        // 4、输出部署信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }
}
