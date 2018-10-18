package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
@Profile("cloud")
public class Config {
	
	private String yedisHost;
	private int yedisPort;

	@Bean
	public RedisConnectionFactory connectionFactory(YugabyteProperties yugabyteProperties) {
		
		parseConnectionInfo(yugabyteProperties.getYedis());
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(yedisHost, yedisPort);
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<?, ?> redisTemplate() {

		RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
		return template;
	}
	
	private void parseConnectionInfo(String yedisConnectionString) {
		
		String[] yedisHostPortInfo = yedisConnectionString.split(":");
		
		yedisHost = yedisHostPortInfo[0];
		yedisPort = Integer.parseInt(yedisHostPortInfo[1]);
		
	}
}
