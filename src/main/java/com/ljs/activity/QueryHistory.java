package com.ljs.activity;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * 历史数据查询
 */
public class QueryHistory {
    public static void main(String[] args) {
        // 1、创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、得到HistoryService实例
        HistoryService historyService = processEngine.getHistoryService();

        // 3、得到HistoricActivitiInstanceQuery对象
        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();

        // 4、设置流程实例id
        historicActivityInstanceQuery.processInstanceId("2501");
        // 5、根据时间升序排序
        List<HistoricActivityInstance> list = historicActivityInstanceQuery.orderByHistoricActivityInstanceStartTime().asc().list();

        // 6、遍历查询结果
        for(HistoricActivityInstance instance:list){
            System.out.println(instance.getActivityId());
            System.out.println(instance.getActivityName());
            System.out.println(instance.getProcessDefinitionId());
            System.out.println(instance.getProcessInstanceId());
            System.out.println("======================================");
        }
    }
}
