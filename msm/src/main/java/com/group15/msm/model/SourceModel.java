package com.group15.msm.model;

import lombok.Getter;
import lombok.Setter;
import org.dozer.Mapping;

import javax.validation.constraints.*;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 20-11-2019
 * Time: 22:32
 */
@Getter
@Setter
public class SourceModel {

    private int id;
    @NotBlank
    @Mapping("name1")
    @Size(min=3, max = 50)
    private String name;
    @Min(10)
    private double score;
}
