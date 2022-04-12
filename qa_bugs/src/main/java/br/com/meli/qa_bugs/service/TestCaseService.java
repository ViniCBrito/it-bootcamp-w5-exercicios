package br.com.meli.qa_bugs.service;

import br.com.meli.qa_bugs.domain.TestCase;
import br.com.meli.qa_bugs.exception.TestCaseNotFoundException;
import br.com.meli.qa_bugs.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

@Service
public class TestCaseService implements IService<TestCase, Long, HashMap<String, String>> {
    private TestCaseRepository testCaseRepository;

    private TestCase findTestCase(Long id) {
        return this.testCaseRepository.findById(id)
                .orElseThrow(() -> new TestCaseNotFoundException(" ID: ".concat(id.toString())));
    }

    public TestCaseService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCase create(TestCase testCase) {
        return this.testCaseRepository.save(testCase);
    }

    @Override
    public Collection<TestCase> listAll(HashMap<String, String> filters) {
        for (String filter : filters.keySet()) {
            switch (filter) {
                case "description":
                    String description = filters.get(filter);
                    return this.testCaseRepository.findByDescriptionContains(description);
                case "tested":
                    Boolean tested = Boolean.valueOf(filters.get(filter));
                    return this.testCaseRepository.findByTestedEquals(tested);
                case "passed":
                    Boolean passed = Boolean.valueOf(filters.get(filter));
                    return this.testCaseRepository.findByPassedEquals(passed);
                case "number_of_tries":
                    Integer number_of_tries = Integer.valueOf(filters.get(filter));
                    return this.testCaseRepository.findByNumberOfTriesEquals(number_of_tries);
                case "last_update":
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    TemporalAccessor parsed = formatter.parse(filters.get(filter));
                    LocalDateTime lastUpdate = LocalDate.from(parsed).atStartOfDay();
                    return this.testCaseRepository.findByLastUpdateBefore(Timestamp.valueOf(lastUpdate));
            }
        }
        return this.testCaseRepository.findAll();
    }

    @Override
    public TestCase find(Long id) {
        return this.findTestCase(id);
    }

    @Override
    public void delete(Long id) {
        Optional<TestCase> foundTestCase = this.testCaseRepository.findById(id);
        if (foundTestCase.isEmpty()) return;
        this.testCaseRepository.delete(foundTestCase.get());
    }

    @Override
    public TestCase update(Long id, TestCase testCase) {
        TestCase foundTestCase = findTestCase(id);
        foundTestCase.setDescription(testCase.getDescription());
        foundTestCase.setTested(testCase.getTested());
        foundTestCase.setPassed(testCase.getPassed());
        foundTestCase.setNumberOfTries(testCase.getNumberOfTries());
        return this.testCaseRepository.save(foundTestCase);
    }
}
