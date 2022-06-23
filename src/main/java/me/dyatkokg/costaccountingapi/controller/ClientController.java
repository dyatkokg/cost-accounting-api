package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.ClientDTO;
import me.dyatkokg.costaccountingapi.entity.Client;
import me.dyatkokg.costaccountingapi.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping("register")
    public ResponseEntity<Client> register(@RequestBody ClientDTO dto) {
        return ResponseEntity.ok(service.register(dto));
    }

}
