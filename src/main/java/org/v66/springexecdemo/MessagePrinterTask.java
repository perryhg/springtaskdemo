package org.v66.springexecdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinterTask {
	
	private static Logger logger = LoggerFactory.getLogger(MessagePrinterTask.class);
	public MessagePrinterTask()
	{
		logger.debug("mpt inited");
	}

    @Autowired
    private String message;

    @Async("myExecutor2")
    public void printMessage() {
    	logger.debug("task.printmsg:{}",message);
    	System.out.println(message);
    }

	public void run() {
		// TODO Auto-generated method stub
		logger.debug("mpt run");
	}

	@Async("myExecutor1")
	public void printMsg() {
		logger.debug("task.printmsg111:{}",message);
    	System.out.println("1---"+message);
	}

}
