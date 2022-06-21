package com.digitech.reciskmodule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branches")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Branche extends AbstractEntity {
    private List<Alias> alias = new ArrayList <> ();
    private String code;
    private float is_parent;
    private String name;
    private String parent_branch_id;
    private float status;
    private String type;
}
