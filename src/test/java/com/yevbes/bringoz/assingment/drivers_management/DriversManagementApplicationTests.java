package com.yevbes.bringoz.assingment.drivers_management;

import com.yevbes.bringoz.assingment.drivers_management.controller.Controller;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DriversManagementApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Controller controller;

    @Test
    void test() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void statusTest() throws Exception {
        this.mockMvc.perform(get("/api/drivers")).andDo(print()).andExpect(status().isOk());
    }

}
