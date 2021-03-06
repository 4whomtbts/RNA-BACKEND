package com.dna.rna.controller;

import com.dna.rna.domain.School.School;
import com.dna.rna.domain.School.SchoolRepository;
import com.dna.rna.exception.ApiErrorResponse;
import com.dna.rna.service.SchoolService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    private final Logger logger= LoggerFactory.getLogger(getClass());

    private final SchoolService schoolService;

    @Autowired
    SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/school")
    public ResponseEntity createSchool(@RequestBody SchoolCreateForm schoolCreateForm) {
        String schoolName = schoolCreateForm.getSchoolName();

        School result = schoolService.createSchool(schoolName);

        return new ResponseEntity(HttpStatus.OK);
    }

}

@Getter
@Setter
class SchoolCreateForm {
    private String schoolName;
}