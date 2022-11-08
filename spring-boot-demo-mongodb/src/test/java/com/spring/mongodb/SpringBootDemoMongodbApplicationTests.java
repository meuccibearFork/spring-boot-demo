package com.spring.mongodb;

import com.spring.mongodb.model.User;
import com.spring.mongodb.repository.UserRepository;
import com.spring.mongodb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class SpringBootDemoMongodbApplicationTests {

    @Resource
    private UserService userService;
    @Resource
    private UserRepository userRepository;


    @Test
    public void run() {
//		userService.create();

        List<User> uses = new ArrayList<>();
        uses.add(User.builder().id("1").build());
        uses.add(User.builder().id("4c614cb8fca74aef83bcc49fc592ca8f").build());

        Iterable<User> allById = userRepository.findAllById(uses);

        log.info("{}", allById);
    }


}
