package com.insurance.hcis.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponseDto {
	private String message;
	private int statusCode;
	private List<HospitalResponse> listOfHospitals;

}
