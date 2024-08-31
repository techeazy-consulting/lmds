package com.techeazy.lmds.repository;

import com.techeazy.lmds.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
