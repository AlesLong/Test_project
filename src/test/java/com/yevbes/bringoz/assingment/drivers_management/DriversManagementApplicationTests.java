package com.yevbes.bringoz.assingment.drivers_management;

import com.yevbes.bringoz.assingment.drivers_management.controller.Controller;
import com.yevbes.bringoz.assingment.drivers_management.entity.Driver;
import com.yevbes.bringoz.assingment.drivers_management.entity.DriversStatus;
import com.yevbes.bringoz.assingment.drivers_management.service.DriverServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DriversManagementApplicationTests {

    @MockBean
    private DriverServiceImpl driverService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Controller controller;

    private Driver driver = new Driver(5, "John", "Johnson", 25, "Kyiv",
            DriversStatus.AVAILABLE, LocalTime.of(9, 20, 15), LocalTime.of(22, 12, 32));

    private String JSONExample = "{\"id\":\"5\",\"firstName\":\"John\",\"lastName\":\"Johnson\",\"age\":\"25\",\"address\":\" Kyiv\",\"status\":\"AVAILABLE\",\"startWork\":\"09:20:15\",\"endWork\":\"22:12:32\",\"longitude\":\"50\", \"latitude\":\"50\"}";

    private List<Driver> list = new ArrayList<>();

    @Test
    void test() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void statusTest() throws Exception {
        this.mockMvc.perform(get("/api/drivers")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void createDriverExpectingOneCall() throws Exception {
        Mockito.when(driverService.createDriver(driver)).thenReturn(driver);

        mockMvc.perform(post("/api/drivers").
                content(JSONExample)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Mockito.verify(driverService, Mockito.times(1)).saveDriver(driver);
    }

    @Test
    public void getAllDeliveringDriversExpectedOne() throws Exception {
        driver.setStatus(DriversStatus.DELIVERING);
        list.add(driver);

        Mockito.when(driverService.findAllDelivering()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/drivers/status/{status}", "delivering"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(list.get(0).getId()))
                .andExpect(jsonPath("$[0].status").value(list.get(0).getStatus().name()));

        Mockito.verify(driverService, Mockito.times(1)).findAllDelivering();
    }

    @Test
    public void getDriverByIdExpectedOneCall() throws Exception {

        Mockito.when(driverService.getDriver(Mockito.anyInt())).thenReturn(driver);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/drivers/{id}", 5));
        Mockito.verify(driverService, Mockito.times(1)).getDriver(5);
    }

    @Test
    public void deleteDriverByIdExpectedOneCall() throws Exception {

        Mockito.when(driverService.getDriver(Mockito.anyInt())).thenReturn(driver);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/drivers/{id}", 5));
        Mockito.verify(driverService, Mockito.times(1)).deleteDriver(5);
    }

    @Test
    public void getAllAvailableDriversExpectedOne() throws Exception {
        driver.setStatus(DriversStatus.AVAILABLE);
        list.add(driver);

        Mockito.when(driverService.findAllAvailable()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/drivers/status/{status}", "available"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(list.get(0).getId()))
                .andExpect(jsonPath("$[0].status").value(list.get(0).getStatus().name()));

        Mockito.verify(driverService, Mockito.times(1)).findAllAvailable();
    }

    @Test
    public void getAllUnavailableDriversExpectedOne() throws Exception {
        driver.setStatus(DriversStatus.UNAVAILABLE);
        list.add(driver);

        Mockito.when(driverService.findAllUnavailable()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/drivers/status/{status}", "unavailable"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(list.get(0).getId()))
                .andExpect(jsonPath("$[0].status").value(list.get(0).getStatus().name()));

        Mockito.verify(driverService, Mockito.times(1)).findAllUnavailable();
    }

}
