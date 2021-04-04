package com.ljs.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

/**
 * 完成待办任务
 */
public class ActivitiCompleteTask {
    public static void main(String[] args) {
        // 1、获取ProcessEngines对象
        ProcessEngine ProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、获取TaskService对象
        TaskService taskService = ProcessEngine.getTaskService();
        // 3、新增接口。根据taskId处理任务。。。前端传任务id。后台执行
        String taskId = "2505";
        // 4、处理当前任务
        taskService.complete(taskId);
    }
}
