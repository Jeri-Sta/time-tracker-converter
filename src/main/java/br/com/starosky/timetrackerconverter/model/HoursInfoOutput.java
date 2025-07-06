package br.com.starosky.timetrackerconverter.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HoursInfoOutput {
    LocalDate date;
    Double hcmHours;
    Double jiraHours;
}
