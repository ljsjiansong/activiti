package com.ljs.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 查询当前用户的任务列表
 */
public class ActivitiTaskQuery {
    public static void main(String[] args) {
        // 1、获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、获取TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3、根据key和当前用户筛选list列表
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .singleResult();

        // 4、遍历输出list列表展示
        System.out.println("流程实例id:"+task.getProcessInstanceId());
        System.out.println("任务名称:"+task.getName());
        System.out.println("任务id:"+task.getId());
        System.out.println("任务负责人:"+task.getAssignee());

        // 5、完成当前待办任务
        taskService.complete(task.getId());
    }
}
