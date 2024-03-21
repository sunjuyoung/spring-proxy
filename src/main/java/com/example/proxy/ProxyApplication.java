package com.example.proxy;

import com.example.proxy.config.AppV1Config;
import com.example.proxy.config.AppV2Config;
import com.example.proxy.config.v1_proxy.InterfaceProxyConfig;
import com.example.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import com.example.proxy.logTrace.LogTrace;
import com.example.proxy.logTrace.ThreadLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


//@Import(AppV1Config.class)
//@Import({AppV1Config.class,AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
@Import(DynamicProxyBasicConfig.class)
@SpringBootApplication(scanBasePackages = "com.example.proxy.v1")
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace(){
		return new ThreadLogTrace();
	}

}
