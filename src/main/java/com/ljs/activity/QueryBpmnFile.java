package com.ljs.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 用户需求：实现资源文件保存
 */
public class QueryBpmnFile {
    public static void main(String[] args) throws IOException {
        // 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 得到流程定义查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        // 设置查询条件
        processDefinitionQuery.processDefinitionKey("holiday");
        // 查询当前可控的单条流程定义
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        // 通过流程定义信息获取流程定义部署Id
        String deploymentId = processDefinition.getDeploymentId();
        // 构建输入流：通过RepositoryService对象实现读取bpmn信息，读取png文件信息
        InputStream pngIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        InputStream bpmnIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());
        // 构建输出流
        // 需要传输到pc磁盘的路径
        OutputStream pngOs = new FileOutputStream("E:\\test\\"+processDefinition.getDiagramResourceName());
        OutputStream bpmnOs = new FileOutputStream("E:\\test\\"+processDefinition.getResourceName());
        // 借助工具进行输入输出流转换
        IOUtils.copy(pngIs,pngOs);
        IOUtils.copy(bpmnIs,bpmnOs);
        // 关闭流
        pngOs.close();
        bpmnOs.close();
        pngIs.close();
        bpmnIs.close();
    }
}
