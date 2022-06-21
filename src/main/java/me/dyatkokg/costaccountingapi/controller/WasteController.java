package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.WasteDTO;
import me.dyatkokg.costaccountingapi.entity.Waste;
import me.dyatkokg.costaccountingapi.service.WasteService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("waste")
@RequiredArgsConstructor
public class WasteController {

    private final WasteService service;

    @PostMapping
    public ResponseEntity<WasteDTO> addWaste(@RequestBody @Validated WasteDTO wasteDTO) {
        return ResponseEntity.ok(service.addWaste(wasteDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<Waste> getWasteByID(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.getWaste(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Waste>> getAllWasteByClient() {
        return ResponseEntity.ok(service.getAllByClient());
    }
}
