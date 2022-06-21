package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.WasteDTO;
import me.dyatkokg.costaccountingapi.entity.Waste;

import java.util.List;
import java.util.UUID;

public interface WasteService {
    WasteDTO addWaste(WasteDTO wasteDTO);

    Waste getWaste(UUID id);

    List<Waste> getAllByClient();
}
