package com.raj.listener;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.RequestContext;

public class MyFlowListener extends FlowExecutionListenerAdapter {
	private static Logger logger = Logger.getLogger("Listenerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	@Override
	public void requestSubmitted(RequestContext context) {
		// TODO Auto-generated method stub
		super.requestSubmitted(context);
		logger.log(Priority.INFO, "requestSubmitted");
		
	}
	
	
	@Override
	public void resuming(RequestContext context) {
		// TODO Auto-generated method stub
		super.resuming(context);
		logger.info("RESUMING");
	}

	@Override
	public void eventSignaled(RequestContext context, Event event) {
		// TODO Auto-generated method stub
		super.eventSignaled(context, event);
		logger.info("EVENT SIGNALLED:" + event);
	}
	
	@Override
	public void paused(RequestContext context) {
		// TODO Auto-generated method stub
		super.paused(context);
		
		logger.info("PAUSED" + context.getActiveFlow());
	}
}
