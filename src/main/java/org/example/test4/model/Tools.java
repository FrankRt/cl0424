package org.example.test4.model;

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
public class Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer   id;

    private String    toolCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "tool_types_id")
    private ToolTypes toolTypes;

    private String    brand;
}
