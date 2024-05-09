package com.roadline.service;

import java.util.List;

import com.roadline.Dto.InvoiceDto;
import com.roadline.Dto.InvoiceListDto;

public interface InvoiceService {

	InvoiceDto addInvoiceDto(InvoiceDto obj);
	InvoiceDto getInVoice(Long id);
	Long nextId();
	List<InvoiceListDto> getInvoiceList();
	InvoiceDto updateInvoiceDto(Long id,InvoiceDto obj);
	boolean deleteInvoice(long id);
}
