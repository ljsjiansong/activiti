package com.ljs.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * zip压缩包方式实现流程定义部署
 */
public class ActivitiZipDeployment {
    public static void main(String[] args) {
        // 1、获的ProcessEngine对象
        ProcessEngine ProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、获取repositoryService
        RepositoryService repositoryService = ProcessEngine.getRepositoryService();
        // 3、转换出ZipInputStream流对象
        InputStream is = ActivitiZipDeployment.class.getClassLoader().getResourceAsStream("bpmn.zip");
        ZipInputStream zipInputStream = new ZipInputStream(is);

        // 4、进行部署
        Deployment deployment = repositoryService.createDeployment().addZipInputStream(zipInputStream)
                .name("请假申请流程")
                .deploy();
        // 5、输出部署信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }
}
