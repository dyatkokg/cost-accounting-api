package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.WasteDTO;
import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.WasteSumCategoryDTO;
import me.dyatkokg.costaccountingapi.entity.Waste;
import me.dyatkokg.costaccountingapi.service.WasteService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<WasteDTO>> getAllWasteByClientsAccount(@RequestParam(value = "size", required = false, defaultValue = "10") int page,
                                                                      @RequestParam(value = "page", required = false, defaultValue = "0") int size,
                                                                      @RequestBody DateDTO viewDTO) {
        return ResponseEntity.ok(service.getAllByClient(page, size, viewDTO));
    }

    @GetMapping("sum")
    public ResponseEntity<WasteSumCategoryDTO> getSumWasteByCategory(@RequestBody WasteSumCategoryDTO sumDTO) {
        return ResponseEntity.ok(service.getSumAllWasteByCategory(sumDTO));
    }
}
