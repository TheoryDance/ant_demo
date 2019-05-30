package com;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import com.utils.MyLogger;

public class Luncher {

	public static void main(String[] args) {
		try {
			// quartz配置，设置quartz.properties的classpath，并启动任务
			MyLogger.logger.info("config quartz's task and start schema.");
			System.setProperty("org.quartz.properties", "quartz/quartz.properties");
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
		} catch (Exception ex) {
			MyLogger.logger.warn(ex);
		}
	}
}
