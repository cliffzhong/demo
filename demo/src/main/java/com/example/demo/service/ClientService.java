package com.example.demo.service;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto clientDto, Long managerId);

    ClientDto update(ClientDto clientDto);

    boolean deleteByLoginName(String loginName);

    boolean deleteById(Long clientDtoId);

    boolean delete(ClientDto clientDto);

    List<ClientDto> getClients();

    ClientDto getClientById(Long id);

    ClientDto getClientByLoginName(String loginName);
}
