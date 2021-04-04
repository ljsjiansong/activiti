package com.ljs.activity.zhenghe;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.util.ObjectUtils;

/**
 * 业务系统与activiti框架整合查询bussniessId
 */
public class BussinessKeyAdd2 {
    public static void main(String[] args) {
        // 1、得到ProcessEngine对象
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到RuntimeService对象
        TaskService taskService = defaultProcessEngine.getTaskService();

        // 3、得到task对象
        Task task = taskService.createTaskQuery().processDefinitionKey("holiday").taskAssignee("zhangsan").singleResult();
        if (!ObjectUtils.isEmpty(task)){
            String processInstanceId = task.getProcessInstanceId();

            // 5、通过流程实例id查询流程实例
            RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

            // 6、拿到bussniessId
            String businessKey = processInstance.getBusinessKey();

            // 7、就可以查询业务系统了
            System.out.println("businesskey："+businessKey);

            // 拓展点。执行完成待办任务
            // 拿到流程实例就可以complete任务。之前需做权限教研。这个人是否有这个权限
            taskService.complete(task.getId());
            System.out.println("当前任务已完成。完成人:"+task.getAssignee());
        }
        System.out.println("task为空");
    }
}
