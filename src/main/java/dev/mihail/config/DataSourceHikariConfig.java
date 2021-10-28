package dev.mihail.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceHikariConfig {

//    @Bean
//    @Primary
//    @ConfigurationProperties("app.datasource.main")
//    public HikariDataSource hikariDataSource(){
//       return DataSourceBuilder.create()
//               .type(HikariDataSource.class)
//               .build();
//    }

//    @Bean
//    public JdbcTemplate jdbcTemplateOfHikari(HikariDataSource hikariDataSource){
//        return new JdbcTemplate(hikariDataSource);
//    }

}
