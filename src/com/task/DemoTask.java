package com.task;

import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.service.DemoService;
import com.utils.MyLogger;

/**
 * 国控站数据异常判断告警
 */
public class DemoTask implements Job{
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		DemoService service = new DemoService();
		List<Map<String,Object>> list = service.getDevUnitMap();
		MyLogger.logger.info(list);
		MyLogger.logger.info(service.addItem());
	}

}
