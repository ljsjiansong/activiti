package com.ljs.activity.zurenwu;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 组任务办理
 */
public class GroupTest {
    public static void main(String[] args) {
        // 1、获取processEngine
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、获取TaskSerivce
        TaskService taskService = defaultProcessEngine.getTaskService();
        // 3、设置参数。流程定义key和候选用户
        String key = "holiday";
        String user = "zhangsan";
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskCandidateUser(user).list();
        // 4、遍历任务
        for(Task task:list){
            System.out.println(task.getProcessDefinitionId());
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getAssignee());// 主要看是否为null，如果是null则表示。当前zhangsan是候选人。并不是执行人
        }
    }

}
