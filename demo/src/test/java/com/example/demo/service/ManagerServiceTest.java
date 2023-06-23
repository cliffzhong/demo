package com.example.demo.service;

import com.example.demo.dao.hibernate.ClientDao;
import com.example.demo.dao.hibernate.ManagerDao;
import com.example.demo.dao.hibernate.ProductDao;
import com.example.demo.dto.ManagerDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.Manager;
import com.example.demo.service.impl.ManagerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ManagerServiceTest {

    private final Logger logger = LoggerFactory.getLogger(ManagerServiceTest.class);

    @Mock
    private ManagerDao mockManagerDao;

    @Mock
    private ClientDao mockClientDao;

    @Mock
    private ProductDao mockProductDao;

    @InjectMocks
    private ManagerServiceImpl managerServiceImpl;

    @BeforeEach
    private void initEach(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveManagerDto(){
        ManagerDto mockManagerDto = mock(ManagerDto.class);
        Manager mockManager = mock(Manager.class);

        when(mockManagerDto.convertManagerDtoToManager()).thenReturn(mockManager);
        when(mockManager.convertManagerToManagerDto()).thenReturn(mockManagerDto);

        when(mockManagerDao.save(mockManager)).thenReturn(mockManager);

       managerServiceImpl.save(mockManagerDto);

        verify(mockManagerDao, times(1)).save(mockManager);
        verify(mockManager,times(1)).convertManagerToManagerDto();
        verify(mockManagerDto,times(1)).convertManagerDtoToManager();

    }


    @Test
    public void testUpdateManagerDto(){
        ManagerDto mockManagerDto = mock(ManagerDto.class);
        Manager mockManager = mock(Manager.class);

        when(mockManagerDto.convertManagerDtoToManager()).thenReturn(mockManager);
        when(mockManager.convertManagerToManagerDto()).thenReturn(mockManagerDto);

        when(mockManagerDao.update(mockManager)).thenReturn(mockManager);

        managerServiceImpl.update(mockManagerDto);

        verify(mockManagerDao, times(1)).update(mockManager);
        verify(mockManager,times(1)).convertManagerToManagerDto();
        verify(mockManagerDto,times(1)).convertManagerDtoToManager();

    }


    @Test
    public void testDeleteMajorByName(){
        when(mockManagerDao.deleteByName(anyString())).thenReturn(false);

        boolean deleteResult = managerServiceImpl.deleteByName((anyString()));

        assertFalse(deleteResult);
        verify(mockManagerDao,times(1)).deleteByName(anyString());
    }

    @Test
    public void testGetAllManagers_usingSpyList(){
//        List<Manager> managerList = new ArrayList<>();
//        List<Manager> spyManagerList = spy(managerList);

        List<Manager> spyManagerList = spy(ArrayList.class);

        Manager mockManager = mock(Manager.class);

        spyManagerList.add(mockManager);
        spyManagerList.add(mockManager);
        spyManagerList.add(mockManager);

        ManagerDto mockManagerDto = mock(ManagerDto.class);

        when(mockManager.convertManagerToManagerDto()).thenReturn(mockManagerDto);
        when(mockManagerDao.getManagers()).thenReturn(spyManagerList);

//        List<Client> spyClientList = spy(ArrayList.class);
//        when(mockClientDao.getClients()).thenReturn(spyClientList);

        List<ManagerDto> managerDtoList = managerServiceImpl.getManagers();

        assertEquals(3,managerDtoList.size());

        verify(mockManagerDao,times(1)).getManagers();
        verify(mockManager, times(3)).convertManagerToManagerDto();

//        verify(mockClientDao,times(1)).getClients();

    }
}
