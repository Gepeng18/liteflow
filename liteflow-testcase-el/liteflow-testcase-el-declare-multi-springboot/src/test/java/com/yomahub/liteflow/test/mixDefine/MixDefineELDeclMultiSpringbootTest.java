package com.yomahub.liteflow.test.mixDefine;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * springboot环境最普通的例子测试
 *
 * @author Bryan.Zhang
 * @since 2.6.4
 */
@ExtendWith(SpringExtension.class)
@TestPropertySource(value = "classpath:/mixDefine/application.properties")
@SpringBootTest(classes = MixDefineELDeclMultiSpringbootTest.class)
@EnableAutoConfiguration
@ComponentScan({ "com.yomahub.liteflow.test.mixDefine.cmp" })
public class MixDefineELDeclMultiSpringbootTest extends BaseTest {

	@Resource
	private FlowExecutor flowExecutor;

	// 类声明和方法声明一起定义
	@Test
	public void testMixDefine1() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

}
