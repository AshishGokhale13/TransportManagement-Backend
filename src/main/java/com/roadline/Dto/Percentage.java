package com.roadline.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Percentage {
	double advancePercentage;
	double remainingPercentage;
	double totalAmount;
	double remainingAmount;
	double paidAmount;
}
