package com.cybage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.service.IThreadService;
import com.cybage.threads.DelayThread;

@RestController
@RequestMapping("/thread")
public class DemoController {

	@Autowired
	IThreadService threadService;

	@GetMapping("/test")
	public List<String> testMethod() throws InterruptedException {
		List<String> list = new ArrayList<String>();
		Integer value = threadService.insertValue();

		System.out.println("Creating delayThread ..!!");
		DelayThread delayThread = new DelayThread(value);
		System.out.println("delayThread created");
		delayThread.start();
		System.out.println("REPONSE SENT...!!!!!");
		System.out.println("delayThread started");

		list.add("This value is returned from controller :" + value);
		return list;
	}

	@GetMapping("/check/{threadId}")
	public String terminateThread(@PathVariable("threadId") Integer threadId) throws InterruptedException {
		// Give you set of Threads
		Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();

		// Iterate over set to find yours
		for (Thread thread : setOfThread) {
			if (thread.getId() == threadId) {
				thread.interrupt();
				return "Thread Terminated";
			}
		}
		return "Thread Termination Failed";
	}

	@PostMapping()
	public String placeOrder() {
		
		return "";
	}
}
