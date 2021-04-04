package com.ljs.activity.zhenghe;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 流程实例启动时添加bussniesskey
 *
 */
public class BussinessKeyAdd {
    public static void main(String[] args) {
        // 1、得到ProcessEngine对象
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到RuntimeService对象
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();

        // 3、启动流程实例，同时指定业务标识bussniesskey。它本身就是请假单的id
        // 第一个参数流程实例唯一的key。第二个就是bussniesskey
        // 这里的1001是请假单id。也是业务系统的主键id
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday","1001");

        // 4、输出businesskey
        System.out.println(processInstance.getBusinessKey());

    }
}
