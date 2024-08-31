package com.techeazy.lmds.controller;

import com.techeazy.lmds.entity.Report;
import com.techeazy.lmds.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAllReports(){
        return reportService.getAllReports();
    }
    @GetMapping("/{id}")
    public Report getReportById(@PathVariable Long id){
        return reportService.getReportById(id);
    }
    @PostMapping
    public Report createReport(@RequestBody Report report){
        return reportService.saveReport(report);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id){
        reportService.deleteReport(id);
        return ResponseEntity.ok().build();
    }
}
