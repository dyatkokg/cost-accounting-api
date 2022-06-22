package me.dyatkokg.costaccountingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dyatkokg.costaccountingapi.entity.Client;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private String name;

    private Client client;

    private String type;
}
