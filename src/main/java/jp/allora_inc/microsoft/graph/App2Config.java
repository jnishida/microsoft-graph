package jp.allora_inc.microsoft.graph;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import lombok.Value;

@Value
public class App2Config {
	private String redirectUri;
	private String clientId;

	public App2Config() throws IOException {
		Resource resource = new ClassPathResource("/application.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(resource);
		redirectUri = props.getProperty("app2.redirectUri");
		clientId = props.getProperty("app2.client.id");
	}
}
