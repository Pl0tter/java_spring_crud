package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//@Component
@ConfigurationProperties(prefix = "sqltemplate")

public class SqlTemplate {
    private String insertQuery;
    private String deleteQuery;
    private String updateQuery;
    private String selectAllQuery;

}
