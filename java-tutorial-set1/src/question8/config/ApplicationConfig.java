package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:db.properties")
public class ApplicationConfig {
	
	@Autowired
	Environment environment;
	@Bean("dbConfig")
	MyDBConfig getDbConfig(){
		MyDBConfig config = new MyDBConfig();
		config.setDbHost(environment.getProperty("db.host.url"));
		config.setDbPort(environment.getProperty("db.port.number"));
		config.setDbService(environment.getProperty("db.service.name"));
		config.setDbUrl(environment.getProperty("db.user"));
		config.setDbPassword(environment.getProperty("db.password"));
		return config;
		
	}
}
