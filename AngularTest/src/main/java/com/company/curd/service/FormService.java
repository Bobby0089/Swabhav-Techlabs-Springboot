package com.company.curd.service;



import org.springframework.http.HttpStatus;

import com.company.curd.dto.FormRequestDto;
import com.company.curd.dto.FormResponseDto;
import com.company.curd.dto.FormloginDto;
import com.company.curd.dto.PageResponseDto;

public interface FormService {
	
	FormResponseDto add(FormRequestDto dto);
	
	PageResponseDto<FormResponseDto> getAll(int pageNumer, int pageSize);

	HttpStatus login(FormloginDto dto);
	
}
