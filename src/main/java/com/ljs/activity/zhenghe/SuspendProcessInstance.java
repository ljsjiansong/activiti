package com.ljs.activity.zhenghe;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 全部流程实例的挂起与激活
 */
public class SuspendProcessInstance {
    public static void main(String[] args) {
        // 1、得到ProcessEngine对象
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到RepositoryService对象
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();

        // 3、查询流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("holiday")
                .singleResult();
        // 4、得到当前流程定义的实例是否都为暂停状态
        boolean suspended = processDefinition.isSuspended();
        String processDefinitionId = processDefinition.getId();
        if(suspended){
            // 是暂停，激活
            repositoryService.activateProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("流程定义:"+ processDefinitionId +"激活");
        }else{
            // 不是暂停，挂起
            repositoryService.suspendProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("流程定义:"+ processDefinitionId +"挂起");
        }

    }

}
