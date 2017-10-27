package com.jai.springboot.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

	@Value("${environment}")
	private String environment;

	@Value("${adminurl}")
	private String adminurl;

	@Value("${middlewareHome}")
	private String middlewareHome;

	@Value("${weblogicHome}")
	private String weblogicHome;

	@Value("${domainHome}")
	private String domainHome;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@GetMapping(path = "/properties", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ConfigRest getDetails() {
		return new ConfigRest(environment, adminurl, middlewareHome, weblogicHome, domainHome);
	}

}

class ConfigRest {

	private String environment;

	private String adminurl;

	private String middlewareHome;

	private String weblogicHome;

	private String domainHome;

	public ConfigRest(String environment, String adminurl, String middlewareHome, String weblogicHome, String domainHome) {
		super();
		this.environment = environment;
		this.adminurl = adminurl;
		this.middlewareHome = middlewareHome;
		this.weblogicHome = weblogicHome;
		this.domainHome = domainHome;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getAdminurl() {
		return adminurl;
	}

	public void setAdminurl(String adminurl) {
		this.adminurl = adminurl;
	}

	public String getMiddlewareHome() {
		return middlewareHome;
	}

	public void setMiddlewareHome(String middlewareHome) {
		this.middlewareHome = middlewareHome;
	}

	public String getWeblogicHome() {
		return weblogicHome;
	}

	public void setWeblogicHome(String weblogicHome) {
		this.weblogicHome = weblogicHome;
	}

	public String getDomainHome() {
		return domainHome;
	}

	public void setDomainHome(String domainHome) {
		this.domainHome = domainHome;
	}

}
