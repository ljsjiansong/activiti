package com.ljs.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 查询流程定义
 */
public class QueryProcessDefinition {
    public static void main(String[] args) {
        // 1、获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、得到RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3、得到流程定义查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        // 4、设置查询条件
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("holiday").orderByProcessDefinitionVersion().desc().list();

        // 5、输出流程定义信息
        for (ProcessDefinition processDefinition: list){
            System.out.println("流程定义名："+processDefinition.getName());
            System.out.println("流程定义id："+processDefinition.getId());
            System.out.println("流程定义key:"+processDefinition.getKey());
            System.out.println("流程定义版本："+processDefinition.getVersion());
            System.out.println("流程定义部署id:"+processDefinition.getDeploymentId()); // 用于后期删除流程定义
        }
    }
}
