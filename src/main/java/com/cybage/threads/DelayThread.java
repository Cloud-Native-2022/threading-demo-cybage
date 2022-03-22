package com.cybage.threads;

import org.springframework.stereotype.Component;

@Component
public class DelayThread extends Thread {
	private Integer id;

	public DelayThread() {
		super();
	}

	public DelayThread(Integer value) {
		super();
		this.id = value;
	}

	public void run() {
		try {
			for (int i = 0; i < 50; i++) {
				sleep(1000*3);
				System.out.println(i + 1 + " seconds spent by thread "+Thread.currentThread().getId());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("deleting value with id : " + id);
	}

}
