package org.v66.springexecdemo;

import org.springframework.beans.factory.annotation.Autowired;

public class TaskExecutorExample {

	@Autowired
    private MessagePrinterTask task;

    public void printMessages() {
        for(int i = 0; i < 25; i++) {
            task.printMessage();
        }
    }
    
    public void printMsgs() {
    	for(int i = 0; i < 25; i++) {
            task.printMsg();
        }
    }
}
