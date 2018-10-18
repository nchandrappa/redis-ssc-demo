package demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Configuration
@ConfigurationProperties("vcap.services.yedis.credentials")
public @Data class YugabyteProperties {
	
	private String yedis;

}
