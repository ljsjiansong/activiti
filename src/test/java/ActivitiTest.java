import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class ActivitiTest {
    @Test
    public void testGenTable(){
        // 1、创建ProcessEngineConfiguration对象
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");

        // 2、创建ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();

        // 3、输出ProcessEngine对象是否创建
        System.out.println(processEngine);

    }
}
