package com.ljs.activity.liuchengbianliang;

import com.ljs.activity.UEL.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * 启动流程实例并且赋值pojo类
 */
public class StartEngine {
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、得到RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 3、设值key
        String key = "holiday";
        Map<String,Object> map = new HashMap<String, Object>();
        Holiday holiday = new Holiday();
        holiday.setNum(5F);
        map.put("holiday",holiday);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, map);
        // 4、输出流程实例
        System.out.println(processInstance.getName());
        System.out.println(processInstance.getProcessDefinitionId());
    }

}
