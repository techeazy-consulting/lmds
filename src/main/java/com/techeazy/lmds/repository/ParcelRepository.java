package com.techeazy.lmds.repository;

import com.techeazy.lmds.entity.Message;
import com.techeazy.lmds.entity.Parcel;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.techeazy.lmds")
@EnableJpaRepositories(basePackages = "com.techeazy,lmds.repository")
public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}
