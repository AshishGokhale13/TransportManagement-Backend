package com.roadline.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceListDto {

	Long invoice_id;
	String lorryNo;
	String driverName;
	String consignee;
	String consignor;
	double advance;
	double rs;
	Date date;	
}
