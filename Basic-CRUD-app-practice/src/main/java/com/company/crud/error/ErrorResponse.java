package com.company.crud.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ErrorResponse {

	private String message;
	private int status;
	private long timestamp;
}