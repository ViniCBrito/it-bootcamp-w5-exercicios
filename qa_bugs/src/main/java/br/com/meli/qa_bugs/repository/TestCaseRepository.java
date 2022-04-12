package br.com.meli.qa_bugs.repository;

import br.com.meli.qa_bugs.domain.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query(value = "from TestCase t where t.description like %:description%")
    List<TestCase> findByDescriptionContains(String description);
    List<TestCase> findByTestedEquals(Boolean tested);
    List<TestCase> findByPassedEquals(Boolean tested);
    List<TestCase> findByNumberOfTriesEquals(Integer numberOfTries);
    List<TestCase> findByLastUpdateBefore(Timestamp last_update);

//    private String description;
//    private Boolean tested;
//    private Boolean passed;
//    private Integer number_of_tries;
//    private Timestamp last_update;
}
