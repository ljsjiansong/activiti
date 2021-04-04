package com.ljs.activity.liuchengbianliang;

import com.ljs.activity.UEL.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核，完成流程实例
 */
public class CompleteTask {
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 3、设值key
        String key = "holiday";
        Map<String,Object> map = new HashMap<String, Object>();
        Holiday holiday = new Holiday();
        holiday.setNum(5F);
        map.put("holiday",holiday);
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
        if(!ObjectUtils.isEmpty(task)){
            taskService.complete(task.getId(),map);
        }

    }

}
