package com.ljs.activity.zurenwu;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 拾取组任务
 */
public class ClaimGroup {
    public static void main1(String[] args) {
        // 1、获取processEngine
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、获取TaskSerivce
        TaskService taskService = defaultProcessEngine.getTaskService();
        // 3、设置参数。流程定义key和候选用户
        String key = "holiday";
        String user = "zhangsan";
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskCandidateUser(user).singleResult();
        System.out.println(task.getProcessDefinitionId());
        System.out.println(task.getId());
        System.out.println(task.getName());
        System.out.println(task.getAssignee());// 主要看是否为null，如果是null则表示。当前zhangsan是候选人。并不是执行人

        // 查询到组任务之后，可以拾取组任务
        if (!ObjectUtils.isEmpty(task)) {
            taskService.claim(task.getId(), user);
            System.out.println("任务拾取完成");
        }
    }

    public static void main2(String[] args) {
        // 查询当前组任务的个人任务。
        // 1、获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、获取TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3、根据key和当前用户筛选list列表
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskCandidateUser("zhangsan")
                .singleResult();

        // 4、遍历输出list列表展示
        System.out.println("流程实例id:"+task.getProcessInstanceId());
        System.out.println("任务名称:"+task.getName());
        System.out.println("任务id:"+task.getId());
        System.out.println("任务负责人:"+task.getAssignee());

        // 5、拾取组任务
        if (!ObjectUtils.isEmpty(task)){
            taskService.claim(task.getId(),"zhangsan");
        }


/*
        // 5、完成当前任务
        if (!ObjectUtils.isEmpty(task)){
            taskService.complete(task.getId());
            System.out.println("当前用户任务完成");
        }*/
    }

    public static void main3(String[] args) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = defaultProcessEngine.getTaskService();
        // 6、归还组任务
        // 查询当前用户是否是任务的执行人
        Task task = taskService.createTaskQuery()
                .taskAssignee("zhangsan")
                .singleResult();
        if (!ObjectUtils.isEmpty(task)){
            taskService.setAssignee(task.getId(),null);
        }
    }


    public static void main(String[] args) {
        // 1、zhangsan重新拾取组任务
       /* ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = defaultProcessEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .taskCandidateUser("zhangsan")
                .singleResult();
        if (!ObjectUtils.isEmpty(task)){
            taskService.claim(task.getId(),"zhangsan");
            System.out.println("任务拾取成功");
        }*/

        // 2、判断当前用户是否为任务负责人。如果是则交接任务给lisi
       /* ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = defaultProcessEngine.getTaskService();
        Task task1 = taskService.createTaskQuery()
                .taskAssignee("zhangsan")
                .singleResult();
        if (!ObjectUtils.isEmpty(task1)){
            taskService.setAssignee(task1.getId(),"lisi");
            System.out.println("任务交接完毕");
        }*/

        // 3、lisi完成任务
        // 先看自己是不是任务负责人。如果是才可以完成
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = defaultProcessEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .taskAssignee("lisi")
                .singleResult();
        if (!ObjectUtils.isEmpty(task)){
            taskService.complete(task.getId());
            System.out.println("lisi完成任务");
        }
    }
}
