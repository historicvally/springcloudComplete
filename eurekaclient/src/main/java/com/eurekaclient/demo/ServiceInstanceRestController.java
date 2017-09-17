package com.eurekaclient.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController
class ServiceInstanceRestController {

	 	@Autowired
		private DiscoveryClient discoveryClient;

	    @Value("${author}")
		private String author;

			@RequestMapping("/get-service-name/{applicationName}")
			public List<ServiceInstance> serviceInstancesByApplicationName(
					@PathVariable String applicationName) {
				return this.discoveryClient.getInstances(applicationName);
			}

			@Value("${server.port}")
			String port;
			@RequestMapping("/hi")
			public String home(@RequestParam String name) {
				return author+" say: "+"Hi "+name+",i am from port:" +port;
			}
			//输入localhost:8011/xxxx/eurekaclient1 试试





}