package br.com.meli.qa_bugs.controller;

import br.com.meli.qa_bugs.domain.TestCase;
import br.com.meli.qa_bugs.dto.TestCaseDTO;
import br.com.meli.qa_bugs.service.TestCaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("")
    public ResponseEntity<TestCaseDTO> createNewTestCase(@RequestBody @Valid TestCaseDTO testCaseDTO, UriComponentsBuilder uriBuilder) {
        TestCase testCase = new TestCase();
        BeanUtils.copyProperties(testCaseDTO, testCase);
        testCase = this.testCaseService.create(testCase);
        BeanUtils.copyProperties(testCase, testCaseDTO);
        URI uri = uriBuilder.path("/api/testcases/{id}").buildAndExpand(testCaseDTO.getId_case()).toUri();
        return ResponseEntity.created(uri).body(testCaseDTO);
    }

    @GetMapping("")
    public ResponseEntity<Collection<TestCaseDTO>> getAllTestCases(@RequestParam(required = false) HashMap<String, String> t) {
        Collection<TestCase> foundTestCases = this.testCaseService.listAll(t);
        List<TestCaseDTO> result = foundTestCases.stream()
                .map(f -> {
                    TestCaseDTO c = new TestCaseDTO();
                    BeanUtils.copyProperties(f, c);
                    return c;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable("id") Long id) {
        System.out.println("ID informado: " + id);
        TestCase foundTestCase = this.testCaseService.find(id);
        TestCaseDTO result = new TestCaseDTO();
        BeanUtils.copyProperties(foundTestCase, result);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> putTestCaseById(@PathVariable("id") Long id, @RequestBody @Valid TestCaseDTO testCaseDTO, UriComponentsBuilder uriBuilder) {
        TestCase testCase = new TestCase();
        BeanUtils.copyProperties(testCaseDTO, testCase);
        testCase = this.testCaseService.update(id, testCase);
        BeanUtils.copyProperties(testCase, testCaseDTO);
        return ResponseEntity.ok(testCaseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTestCaseById(@PathVariable("id") Long id) {
        this.testCaseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
