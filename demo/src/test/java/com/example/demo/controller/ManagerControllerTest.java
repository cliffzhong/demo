package com.example.demo.controller;

import com.example.demo.dto.ManagerDto;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.service.impl.ManagerServiceImpl;
import org.apache.catalina.authenticator.SavedRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;



import static org.mockito.Mockito.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ManagerControllerTest {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ManagerServiceImpl mockManagerService;

    @InjectMocks
    private ManagerController managerController;

    @BeforeEach
    public void initEach(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllManagers() throws Exception {
        List<ManagerDto> managerDtoList = new ArrayList<>();
        ManagerDto  managerDto = createManagerByName("abc");
        Long managerId = 100L;
        managerDto.setId(managerId);
        managerDtoList.add(managerDto);

        when(mockManagerService.getManagers()).thenReturn(managerDtoList);
        String responseJsonString = JsonStringUtil.convertObjectToJsonString(managerDtoList);

        String restUriForFindingAllManagers = "/project_bank/managers";
        mockMvc.perform(get(restUriForFindingAllManagers)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().json(responseJsonString))
                .andExpect(status().isOk());

    }

    @Test
    public void testFindManagerByManagerId_happy_path() throws Exception {
        ManagerDto  managerDto = createManagerByName("abc");
        Long managerId = 100L;
        managerDto.setId(managerId);

        when(mockManagerService.getManagerById(anyLong())).thenReturn(managerDto);
        String requestJsonString = JsonStringUtil.convertObjectToJsonString(managerDto);
        String responseJsonString = JsonStringUtil.convertObjectToJsonString(managerDto);

        String restUriForGettingManagerById = "/project_bank/managers/{id}";

        /*
         *  not using RequestBuilder
         */
        mockMvc.perform(get(restUriForGettingManagerById,managerId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJsonString))
                .andDo(print())
                .andExpect(content().json(responseJsonString))
                .andExpect(status().isOk());

        /*
         *  using RequestBuilder
         */

//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get(restUriForGettingManagerById,managerId)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(requestJsonString);
//
//        mockMvc.perform(requestBuilder)
//                .andDo(print())
//                .andExpect(content().json(responseJsonString))
//                .andExpect(status().isOk());

        verify(mockManagerService,times(1)).getManagerById(anyLong());
    }


    @Test
    public void testFindManagerByManagerId_Not_Found() throws Exception {
        ManagerDto managerDto = createManagerByName("aaa");
        Long managerId = 12L;
        managerDto.setId(managerId);

        when(mockManagerService.getManagerById(anyLong())).thenThrow(new ItemNotFoundException());
        String requestJsonString = JsonStringUtil.convertObjectToJsonString(managerDto);
        //String responseJsonString = JsonStringUtil.convertObjectToJsonString(managerDto);

        String testFindManagerByManagerId_Not_Found = "/project_bank/managers/{id}";

        /*
         *  not using RequestBuilder
         */
        mockMvc.perform(get(testFindManagerByManagerId_Not_Found)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJsonString))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is("Something Wrong")))
                .andExpect(jsonPath("$.description", is("Could not find Manager with id = "+ managerId)));
    }

    @Test
    public void testCreateManagerDto() throws Exception {
        String managerName = "aaa";
        ManagerDto inputManagerDto = createManagerByName(managerName);

        ManagerDto savedManagerDto = createManagerByName(managerName);
        Long managerId = 12L;
        savedManagerDto.setId(managerId);

        String requestJsonString = JsonStringUtil.convertObjectToJsonString(inputManagerDto);
        String responseJsonString = JsonStringUtil.convertObjectToJsonString(savedManagerDto);

        when(mockManagerService.save(inputManagerDto)).thenReturn(savedManagerDto);

        String restUriForCreatingManagerDto = "/project_bank/managers";

        mockMvc.perform(post(restUriForCreatingManagerDto)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJsonString))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJsonString));

        verify(mockManagerService,times(1)).save(inputManagerDto);
    }


    @Test
    public void testUpdatedManagerDto() throws Exception {
        String managerName = "aaa";
        ManagerDto inputManagerDto = createManagerByName(managerName);
        Long managerId = 100L;
        inputManagerDto.setId(managerId);

        ManagerDto updatedManagerDto = createManagerByName(managerName);
        updatedManagerDto.setId(managerId);
        updatedManagerDto.setDescription(updatedManagerDto.getDescription() + "_updated");

        String requestJsonString = JsonStringUtil.convertObjectToJsonString(inputManagerDto);
        String responseJsonString = JsonStringUtil.convertObjectToJsonString(updatedManagerDto);

        when(mockManagerService.update(inputManagerDto)).thenReturn(updatedManagerDto);

        String restUriForUpdatingManagerDto = "/project_bank/managers";

        mockMvc.perform(put(restUriForUpdatingManagerDto)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJsonString))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJsonString))
                .andExpect(jsonPath("$.id", is(managerId.longValue())))
                .andExpect(jsonPath("$.name",comparesEqualTo(updatedManagerDto.getName())))
                .andExpect(jsonPath("$.description", comparesEqualTo(updatedManagerDto.getDescription())))
        ;

        verify(mockManagerService,times(1)).update(inputManagerDto);
    }

    @Test
    public void testDeleteManagerById_happy_path() throws Exception {
        when(mockManagerService.deleteById(anyLong())).thenReturn(true);

        Long managerId = 111L;
        String requestJsonString = JsonStringUtil.convertObjectToJsonString(managerId);

        String restUriForDeletingManagerById = "/project_bank/managers/{id}";
        mockMvc.perform(delete(restUriForDeletingManagerById,managerId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJsonString))
                .andDo(print())
                .andExpect(status().isOk());

        verify(mockManagerService, times(1)).deleteById(managerId);
    }

    @Test
    public void testDeleteManagerById_failed() throws Exception {
        when(mockManagerService.deleteById(anyLong())).thenReturn(false);

        Long managerId = 111L;
        String requestJsonString = JsonStringUtil.convertObjectToJsonString(managerId);

        String restUriForDeletingManagerById = "/project_bank/managers/{id}";
        mockMvc.perform(delete(restUriForDeletingManagerById,managerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJsonString))
                .andDo(print())
                .andExpect(status().isOk());

        verify(mockManagerService, times(1)).deleteById(managerId);
    }

    private ManagerDto createManagerByName(String name) {
        ManagerDto managerDto = new ManagerDto();
        managerDto.setName(name);
        managerDto.setDescription(name+"123");
        return managerDto;
    }
}
