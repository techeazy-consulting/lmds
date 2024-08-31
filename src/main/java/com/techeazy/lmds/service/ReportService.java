package com.techeazy.lmds.service;

import com.techeazy.lmds.repository.ReportRepository;
import com.techeazy.lmds.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }
    public Report getReportById(Long id){
        return reportRepository.findById(id).orElse(null);
    }
    public Report saveReport(Report report){
        return reportRepository.save(report);
    }
    public void deleteReport(Long id){
        reportRepository.deleteById(id);
    }
}
