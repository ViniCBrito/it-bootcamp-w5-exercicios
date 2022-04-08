package br.com.meli.qa_bugs.domain;

import java.time.LocalDate;

public class TestCase {
    private Long id_case;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private LocalDate last_update;
}
