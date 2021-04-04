package com.ljs.activity.liuchengbianliang;

import com.ljs.activity.UEL.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核，通过流程实例id设置流程变量
 */
public class CompleteTask2 {
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、设值key
        String key = "holiday";
        Map<String,Object> map = new HashMap<String, Object>();
        Holiday holiday = new Holiday();
        holiday.setNum(5F);
        map.put("holiday",holiday);
        // 3、获取RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 4、根据流程实例id设置流程变量
        // 设置单个变量
        // 参数1：流程实例id 参数2：流程变量key 参数3：流程变量value
        runtimeService.setVariable("2501","holiday",holiday);


    }

}
