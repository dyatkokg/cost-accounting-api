package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.WasteDTO;
import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.WasteSumCategoryDTO;
import me.dyatkokg.costaccountingapi.entity.Waste;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface WasteService {
    WasteDTO addWaste(WasteDTO wasteDTO);

    Waste getWaste(UUID id);

    Page<WasteDTO> getAllByClient(int page, int size, DateDTO viewDTO);

    WasteSumCategoryDTO getSumAllWasteByCategory(WasteSumCategoryDTO wasteSumCategoryDTO);
}
