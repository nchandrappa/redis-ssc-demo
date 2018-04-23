package demo;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash("session")
public class Session implements Serializable {

	private static final long serialVersionUID = -974401504643248835L;

	private String id;
	private String name;

	@TimeToLive
	private Long expiration;

	public Session(String id, String name, Long expiration) {
		super();
		this.id = id;
		this.name = name;
		this.expiration = expiration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getExpiration() {
		return expiration;
	}

	public void setExpiration(Long expiration) {
		this.expiration = expiration;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", name=" + name + ", expiration=" + expiration + "]";
	}
}
