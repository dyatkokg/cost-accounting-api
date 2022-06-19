package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.ClientDTO;
import me.dyatkokg.costaccountingapi.entity.Client;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ClientService extends UserDetailsService {
    Client register(ClientDTO dto);
}
