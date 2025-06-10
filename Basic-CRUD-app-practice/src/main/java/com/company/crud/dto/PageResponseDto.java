package com.company.crud.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class PageResponseDto<T> {

	private List<T> content;
	private int pageNumber;
	private int pageSize;
	private int totalPages;
	private long totalElement;
	private boolean isLast;

}
