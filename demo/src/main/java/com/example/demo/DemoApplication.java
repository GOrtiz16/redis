package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private StringRedisTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "testkey";
        if (!this.template.hasKey(key)) {
            ops.set(key, "Hello World");
            LOGGER.info("Add a key is done");
        }
        LOGGER.info("Return the value from the cache: {}", ops.get(key));
    }
}


// package com.example.demo;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class DemoApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(DemoApplication.class, args);
// 	}

// }
