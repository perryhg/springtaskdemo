package org.v66.springexecdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class SpringDemoMain{

	private static Logger logger = LoggerFactory.getLogger(SpringDemoMain.class);
	
	
	public static void main(String[] args) {	
		logger.debug("begin!");
//		ApplicationContext ctx;
//		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext ctx =
			     new AnnotationConfigApplicationContext();
			 ctx.register(AppConfig.class);
			 ctx.refresh();
			 
		String msg = ctx.getBean(String.class);
		msg = (String) ctx.getBean("msg");
		logger.debug("msg: {}", msg);
		String[] beanDefNames = ctx.getBeanDefinitionNames();
		for(String bdn:beanDefNames)
		{
			logger.debug("bean def name: {}", bdn);
		}
		
//		MessagePrinterTask task = ctx.getBean(MessagePrinterTask.class);
//		task.printMessage();
		
		ctx.register(TaskExecutorExample.class);
		
		TaskExecutorExample tee = ctx.getBean(TaskExecutorExample.class);
		tee.printMessages();
		tee.printMsgs();
		
		Object myexec1 = ctx.getBean("myExecutor1");
		logger.debug("myexec1 type:{}", myexec1.getClass().getName());
		ThreadPoolTaskExecutor tpt1 = (ThreadPoolTaskExecutor)myexec1;
		
		
		Object myexec2 = ctx.getBean("myExecutor2");
		logger.debug("myexec2 type:{}", myexec2.getClass().getName());
		ThreadPoolTaskExecutor tpt2 = (ThreadPoolTaskExecutor)myexec2;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tpt1.shutdown();
		tpt2.shutdown();
		
	}

	private void run() {
		// TODO Auto-generated method stub
		TaskExecutorExample te = new TaskExecutorExample();
		te.printMessages();
	}

}
