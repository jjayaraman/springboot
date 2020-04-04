package com.jai.springboot.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 * You can access the configurations using URL :
 * http://localhost:8888/config/dev
 * http://localhost:8888/config/test
 * http://localhost:8888/config/prod
 *
 * http://localhost:8888/config/dev/master
 * http://localhost:8888/config/test/master
 * http://localhost:8888/config/prod/master
 *
 * http://localhost:8888/config/dev/feature1
 * http://localhost:8888/config/test/feature1
 * http://localhost:8888/config/prod/feature1
 *
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
