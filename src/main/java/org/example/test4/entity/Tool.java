package org.example.test4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer   id;

    private String    toolCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "tool_type_id")
    private ToolType toolType;

    private String    brand;
}
