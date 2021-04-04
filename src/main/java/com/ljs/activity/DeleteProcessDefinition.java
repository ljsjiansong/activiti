package com.ljs.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

/**
 * 流程定义删除
 */
public class DeleteProcessDefinition {
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3、执行删除流程定义。参数代表流程定义部署id
        repositoryService.deleteDeployment("1");
    }
}
