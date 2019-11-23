package com.group15.msm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 22-11-2019
 * Time: 17:29
 */
@Getter
@Setter
@AllArgsConstructor
public class TestModel {
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    @JsonProperty("bdate")
    private LocalDate birthDay;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime lastDate;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date today;
}
