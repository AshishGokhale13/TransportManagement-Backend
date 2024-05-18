package com.roadline.service;

import java.util.List;

import com.roadline.Dto.InvoiceDto;
import com.roadline.Dto.InvoiceListDto;
import com.roadline.Dto.KpiDto;
import com.roadline.Dto.MonthlyTargets;
import com.roadline.Dto.Percentage;

public interface InvoiceService {

	InvoiceDto addInvoiceDto(InvoiceDto obj);
	InvoiceDto getInVoice(Long id);
	Long nextId();
	List<InvoiceListDto> getInvoiceList();
	InvoiceDto updateInvoiceDto(Long id,InvoiceDto obj);
	boolean deleteInvoice(long id);
	
	//getKpiCount
	KpiDto getKpi();
	
	//getPercentage
	Percentage percentage();
	
	// get Yearly Targets
	List<MonthlyTargets> getMothlyTarget();
}
