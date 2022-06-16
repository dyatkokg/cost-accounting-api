package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.ClientDTO;
import me.dyatkokg.costaccountingapi.entity.Client;

public interface ClientService {
    Client register(ClientDTO dto);
}
