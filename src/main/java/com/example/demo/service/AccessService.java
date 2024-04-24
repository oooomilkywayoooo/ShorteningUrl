package com.example.demo.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UrlInfo;
import com.example.demo.repository.UrlInfoRepository;

@Service
public class AccessService {

	private final UrlInfoRepository repository;

    public AccessService(UrlInfoRepository repository) {
        this.repository = repository;
    }

    public List<UrlInfo> findByCreatedAt(String createdAt){
        return repository.findByCreatedAt(createdAt);
    }

    public List<UrlInfo> getEntitiesByYearMonth(String yearMonth) {
        Timestamp startOfMonth = Timestamp.valueOf(yearMonth + "-01 00:00:00");

        // endOfMonth の Timestamp を取得する
        Timestamp endOfMonth = Timestamp.valueOf(LocalDate.parse(yearMonth + "-01")
                                            .plusMonths(1)
                                            .atStartOfDay());

        return repository.findByCreatedAtBetween(startOfMonth, endOfMonth);
    }

    public List<String> getAllYearMonths() {
        List<Timestamp> registrationTimestamps = repository.findAll()
                .stream()
                .map(UrlInfo::getCreatedAt)
                .collect(Collectors.toList());

        return registrationTimestamps.stream()
                .map(timestamp -> new SimpleDateFormat("yyyy-MM").format(timestamp))
                .distinct()
                .collect(Collectors.toList());
    }

}
