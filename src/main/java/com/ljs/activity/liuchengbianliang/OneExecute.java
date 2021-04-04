package com.ljs.activity.liuchengbianliang;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.util.ObjectUtils;

/**
 * 流程变量，第一个流程实例完成
 */
public class OneExecute {
    public static void main(String[] args) {
        // 1、获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、获取TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3、根据key和当前用户筛选list列表
        String key = "holiday";
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee("lisi")
                .singleResult();
        // 4、查询是否有任务。有则完成任务
        if (!ObjectUtils.isEmpty(task)){
            taskService.complete(task.getId());
            System.out.println("任务完成");
        }
    }
}
