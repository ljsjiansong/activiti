package com.ljs.activity.liuchengbianliang;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 创建流程变量的测试类
 */
public class ValibleTest {
    // 新的请假流程定义部署
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3、进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("holiday2.bpmn") // 添加bpmn资源
                .addClasspathResource("holiday2.png")  // 添加png资源
                .name("新请假流程申请") // 流程名
                .deploy();//部署

        // 4、输出部署信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());

    }
}
