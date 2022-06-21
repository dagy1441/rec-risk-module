package com.digitech.reciskmodule.dto;

import com.digitech.reciskmodule.model.Alias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrancheDto {

    private String code;
    private float isParent;
    private String name;
    private String parentBranchId;
    private float status;
    private String type;
    private List<Alias> alias = new ArrayList<>();
}
