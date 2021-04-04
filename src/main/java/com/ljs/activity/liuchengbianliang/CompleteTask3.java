package com.ljs.activity.liuchengbianliang;

import com.ljs.activity.UEL.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核，通过任务id设置流程变量
 */
public class CompleteTask3 {
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、设值key
        String key = "holiday";
        Map<String,Object> map = new HashMap<String, Object>();
        Holiday holiday = new Holiday();
        holiday.setNum(5F);
        map.put("holiday",holiday);
        TaskService taskService = processEngine.getTaskService();

        // 4、根据流程实例id设置流程变量
        // 设置单个变量
        // 参数1：流程实例id 参数2：流程变量key 参数3：流程变量value
        // 设置全局变量
        taskService.setVariable("2505",key,holiday);
        // 设置局部变量
        //taskService.setVariableLocal("2505",key,holiday);
    }

}
