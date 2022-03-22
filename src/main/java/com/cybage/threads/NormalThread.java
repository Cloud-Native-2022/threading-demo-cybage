package com.cybage.threads;

import org.springframework.stereotype.Component;

import com.cybage.service.ThreadServiceImpl;

@Component
public class NormalThread extends Thread {
	private Integer value;

	@Override
	public void run() {
		ThreadServiceImpl threadService = new ThreadServiceImpl();
		value = threadService.insertValue();
		System.out.println("in normal thread run method");
	}

	public Integer getValue() {
		run();
		return value;
	}

}
