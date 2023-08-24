package com.yomahub.liteflow.test.base;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

import javax.annotation.Resource;

/**
 * springboot环境EL常规的例子测试
 *
 * @author Bryan.Zhang
 */
@TestPropertySource(value = "classpath:/base/application.properties")
@SpringBootTest(classes = BaseELSpringbootTest.class)
@EnableAutoConfiguration
@ComponentScan({ "com.yomahub.liteflow.test.base.cmp" })
public class BaseELSpringbootTest extends BaseTest {

	@Resource
	private FlowExecutor flowExecutor;

	// 最简单的情况

	/**
	 * THEN(a,b,WHEN(c,d));
	 * 底层源码为：在 flowExecutor.execute2Resp 中先获取chain，然后chain.execute。
	 * 而chain的execute则是循环调用conditionList中每个condition的execute方法
	 * 一开始是一个ThenCondition，它由两个Node和一个WhenCondition组成，我们先调用ThenCondition的方法，即调用Executable#execute方法
	 * Node的execute方法即借助nodeExecutor来调用instance的execute()方法
	 * 而上面的ThenCondition的最后一个Executable是whenCondition，而WhenCondition则是并行调用两个Node。
	 * 最后整个流程结束
	 */
	@Test
	public void testBase1() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

	// switch节点最简单的测试用例
	@Test
	public void testBase2() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain2", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

	// then,when,switch混用的稍微复杂点的用例,switch跳到一个then上
	@Test
	public void testBase3() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain3", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

	// 一个非常复杂的例子，可以看base目录下的img.png这个图示
	@Test
	public void testBase4() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain4", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

	// 用变量来声明短流程
	@Test
	public void testBase5() throws Exception {
		LiteflowResponse response = flowExecutor.execute2Resp("chain5", "arg");
		Assertions.assertTrue(response.isSuccess());
	}

}
