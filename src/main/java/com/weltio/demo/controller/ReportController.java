package com.weltio.demo.controller;

import com.weltio.demo.dto.ProductFiltersDto;
import com.weltio.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<Set<ProductFiltersDto>> getReportByFilter(@RequestParam(value = "init") @DateTimeFormat(pattern = "yyyy-MM-dd") Date init
                                              , @RequestParam(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
        return new ResponseEntity<>(productService.findAllBetweenIn2Date(init, end), HttpStatus.OK);
    }
}
