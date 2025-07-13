package com.expertise.csv.report.generator.example.controller;

import com.expertise.csv.report.generator.example.service.ReportServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportServiceI reportServiceI;
}
