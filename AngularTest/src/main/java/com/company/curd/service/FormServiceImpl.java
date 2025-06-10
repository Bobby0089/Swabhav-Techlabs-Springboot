package com.company.curd.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.company.curd.dto.FormRequestDto;
import com.company.curd.dto.FormResponseDto;
import com.company.curd.dto.FormloginDto;
import com.company.curd.dto.PageResponseDto;
import com.company.curd.entity.Form;
import com.company.curd.repository.FormRepository;

@Service
public class FormServiceImpl implements FormService {

	@Autowired
	private FormRepository formRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public FormResponseDto add(FormRequestDto dto) {
		Form form = mapper.map(dto, Form.class);
		formRepository.save(form);
		return mapper.map(form, FormResponseDto.class);
	}

	@Override
	public PageResponseDto<FormResponseDto> getAll(int pageNumer, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumer, pageSize);

		Page<Form> pageForm = formRepository.findAll(pageable);
		PageResponseDto<FormResponseDto> pageResponseDto = new PageResponseDto<>();

		pageResponseDto.setPagenumber(pageForm.getNumber());
		pageResponseDto.setPagesize(pageForm.getSize());
		pageResponseDto.setTotalpages(pageForm.getTotalPages());
		pageResponseDto.setTotalelements(pageForm.getTotalElements());
		List<Form> dbForm = pageForm.getContent();
		List<FormResponseDto> dtoForms = new ArrayList<>();
		for (Form form : dbForm) {
			FormResponseDto dto = mapper.map(form, FormResponseDto.class);
			dtoForms.add(dto);
		}
		pageResponseDto.setContent(dtoForms);
		pageResponseDto.setIslast(pageForm.isLast());
		return pageResponseDto;
	}

	@Override
	public HttpStatus login(FormloginDto dto) {
		if(formRepository.existsByUsername(dto.getUsername()) && formRepository.existsByPassword(dto.getPassword())) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

}
