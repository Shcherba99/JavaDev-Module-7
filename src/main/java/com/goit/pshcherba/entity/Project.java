package com.goit.pshcherba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Project {
    private int id;
    private int clientId;
    private LocalDate startDate;
    private LocalDate finishDate;
}
