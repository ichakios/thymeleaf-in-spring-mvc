package com.intalio.victors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class VictorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VictorsApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    CommandLineRunner loadData() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) {


                jdbcTemplate.execute("insert into student (id, name, age) "
                        + "values (1, 'Emile', 32)");
                jdbcTemplate.execute("insert into student (id, name, age) "
                        + "values (2, 'Elias', 22)");
                jdbcTemplate.execute("insert into student (id, name, age) "
                        + "values (3, 'Victor', 42)");
                jdbcTemplate.execute("insert into student (id, name, age) "
                        + "values (4, 'Jean', 38)");
                jdbcTemplate.execute("insert into student (id, name, age) "
                        + "values (5, 'Rabih', 34)");
                jdbcTemplate.execute("insert into student (id, name, age) "
                        + "values (6, 'Ziad', 33)");

                jdbcTemplate.execute("insert into course (id, name, description, steps, student_id) "
                        + "values (1, 'Math', 'Algebra Math Formulas', '001', 1)");
                jdbcTemplate.execute("insert into course (id, name, description, steps, student_id) "
                        + "values (2, 'Biology', 'Digestive Phenomenon', '002', 1)");
                jdbcTemplate.execute("insert into course (id, name, description, steps, student_id) "
                        + "values (3, 'History', 'Country History', '003', 2)");
            }
        };
    }
}
