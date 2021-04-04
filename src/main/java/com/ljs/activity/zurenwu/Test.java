package com.ljs.activity.zurenwu;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.util.ObjectUtils;

/**
 * 组任务测试
 */
public class Test {
    public static void main1(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3、进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("holiday3.bpmn") // 添加bpmn资源
                /*.addClasspathResource("holiday3.png")*/  // 添加png资源
                .name("请假流程申请") // 流程名
                .deploy();//部署

        // 4、输出部署信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }

    public static void main2(String[] args) {
        // 启动流程实例
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、得到RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 3、创建流程实例(必须提前得知key是什么这里是：holiday)
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday");
        // 4、输出id
        System.out.println("流程部署id:"+processInstance.getDeploymentId());
        System.out.println("流程定义id:"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例id:"+processInstance.getId());
        System.out.println("活动id:"+processInstance.getActivityId());
    }

    public static void main(String[] args) {
        // 完成请假单
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、获取TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3、根据key和当前用户筛选list列表
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("xiangwang")
                .singleResult();

        // 4、遍历输出list列表展示
        System.out.println("流程实例id:"+task.getProcessInstanceId());
        System.out.println("任务名称:"+task.getName());
        System.out.println("任务id:"+task.getId());
        System.out.println("任务负责人:"+task.getAssignee());

        // 5、完成当前待办任务
        if(!ObjectUtils.isEmpty(task)){
            taskService.complete(task.getId());
            System.out.println("用户任务执行完毕");
        }

    }
}
