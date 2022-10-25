package com.lf.backmanage;

import com.lf.backmanage.controller.RoleController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackmanageApplicationTests {

    @Test
    void contextLoads() {
        RoleController roleController =new RoleController();
    }

}
