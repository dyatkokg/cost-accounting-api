package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.ClientDTO;
import me.dyatkokg.costaccountingapi.entity.Client;
import me.dyatkokg.costaccountingapi.mapper.ClientMapper;
import me.dyatkokg.costaccountingapi.repository.ClientRepository;
import me.dyatkokg.costaccountingapi.service.ClientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    private final ClientMapper mapper;

    private final PasswordEncoder encoder;

    @Override
    public Client register(ClientDTO dto) {
        Client client = mapper.toEntity(dto);
        String encode = encoder.encode(dto.getPassword());
        client.setPassword(encode);
        return repository.save(client);
    }



}
