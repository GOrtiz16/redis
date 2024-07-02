package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
class DemoApplicationTests implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    private StringRedisTemplate template;

    @Test
    void contextLoads() {
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

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// class DemoApplicationTests {

// 	@Test
// 	void contextLoads() {
// 	}

// }
