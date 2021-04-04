package com.ljs.activity.gateway;

import com.ljs.activity.UEL.Holiday;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试并行网关
 */
public class TestpallentGateway {
    public static void main1(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3、进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("holiday5.bpmn") // 添加bpmn资源
                .addClasspathResource("holiday5.png")
                .name("请假流程申请") // 流程名
                .deploy();//部署

        // 4、输出部署信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());

        // 5、创建流程实例时设置全局流程变量(必须提前得知key是什么这里是：holiday)
        Holiday holiday = new Holiday();
        holiday.setNum(5f);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("holiday",holiday);
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1",map);
        // 6、输出id
        System.out.println("流程部署id:"+processInstance.getDeploymentId());
        System.out.println("流程定义id:"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例id:"+processInstance.getId());
        System.out.println("活动id:"+processInstance.getActivityId());
    }

    public static void main(String[] args) {
        // 完成当前任务
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = defaultProcessEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .taskAssignee("lichen")
                .singleResult();
        if (!ObjectUtils.isEmpty(task)){
            taskService.complete(task.getId());
            System.out.println("任务完成");
        }
    }
}
