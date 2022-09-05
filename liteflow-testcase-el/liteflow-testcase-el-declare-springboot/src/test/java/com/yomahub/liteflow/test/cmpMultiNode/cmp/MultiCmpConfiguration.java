package com.yomahub.liteflow.test.cmpMultiNode.cmp;

import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.core.NodeIfComponent;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;
import org.springframework.context.annotation.Configuration;

/**
 * 多cmp配置
 *
 * @author sorghum
 */
@Configuration
public class MultiCmpConfiguration {

    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS,nodeId = "a",cmpClass = NodeComponent.class)
    public void processA(NodeComponent bindCmp) {
        System.out.println("ACmp executed!");
    }

    @LiteflowMethod(value = LiteFlowMethodEnum.IS_ACCESS,nodeId = "a",cmpClass = NodeComponent.class)
    public boolean isAccessA(NodeComponent bindCmp) {
        System.out.println("ACmp isAccessA!");
        return true;
    }

    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS,nodeId = "b",cmpClass = NodeIfComponent.class)
    public void processB(NodeComponent bindCmp) {
        System.out.println("BCmp executed!");
    }

    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS,nodeId = "c")
    public void processC(NodeComponent bindCmp) {
        System.out.println("CCmp executed!");
    }

    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS,nodeId = "d")
    public void processD(NodeComponent bindCmp) {
        System.out.println("DCmp executed!");
    }

    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS,nodeId = "e")
    public void processE(NodeComponent bindCmp) {
        System.out.println("ECmp executed!");
    }

}
