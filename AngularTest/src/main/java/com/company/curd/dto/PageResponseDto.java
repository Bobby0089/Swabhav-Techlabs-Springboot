package com.company.curd.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class PageResponseDto<T> {
	
	private List<T> content;
	private int pagesize;
	private int pagenumber;
	private int totalpages;
	private long totalelements;
	private boolean islast;

}
