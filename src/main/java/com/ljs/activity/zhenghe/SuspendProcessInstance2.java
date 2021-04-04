package com.ljs.activity.zhenghe;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 单个流程实例的挂起与激活
 */
public class SuspendProcessInstance2 {
    public static void main(String[] args) {
        // 1、得到ProcessEngine对象
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到runtimeService对象
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();

        // 3、查询流程实例
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey("holiday")
                .singleResult();
        // 4、得到当前流程定义的实例是否都为暂停状态
        boolean suspended = processInstance.isSuspended();
        String processInstanceId = processInstance.getId();
        if(suspended){
            // 是暂停，激活
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例:"+ processInstanceId +"激活");
        }else{
            // 不是暂停，挂起
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程实例:"+ processInstanceId +"挂起");
        }

    }

}
