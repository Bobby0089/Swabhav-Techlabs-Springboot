package com.company.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.curd.dto.FormRequestDto;
import com.company.curd.dto.FormResponseDto;
import com.company.curd.dto.FormloginDto;
import com.company.curd.dto.PageResponseDto;
import com.company.curd.service.FormService;

@CrossOrigin( origins  = "http://localhost:4200")
@RestController
@RequestMapping("/test")
public class FormController {

	@Autowired
	private FormService formService;
	
	@PostMapping("/add")
	public ResponseEntity<FormResponseDto> add(@RequestBody FormRequestDto dto)
	{
		return ResponseEntity.ok(formService.add(dto));
	}
	
	@GetMapping("/get")
	public ResponseEntity<PageResponseDto<FormResponseDto>> getAll(@RequestParam int pageNumber, @RequestParam int pageSize)
	{
		return ResponseEntity.ok(formService.getAll(pageNumber, pageSize));
	}
	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody FormloginDto dto)
	{
		return ResponseEntity.ok(formService.login(dto));
	}
}
