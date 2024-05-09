package com.roadline.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadline.Dto.InvoiceDto;
import com.roadline.Dto.InvoiceListDto;
import com.roadline.mapper.InvoiceMapper;
import com.roadline.models.Invoice;
import com.roadline.repo.InvoiceRepo;
import com.roadline.service.InvoiceService;

@Service
public class InvoiceServiceImpl  implements InvoiceService {
	
	@Autowired
	InvoiceRepo invRepo;
	@Override
	public InvoiceDto addInvoiceDto(InvoiceDto obj) {
		return InvoiceMapper.mapToDto(invRepo.save(InvoiceMapper.mapToEntity(obj)));
	}
	@Override
	public InvoiceDto getInVoice(Long id) {
			
		Invoice obj=invRepo.findById(id).orElse(null);
		if(obj!=null)
			return  InvoiceMapper.mapToDto(obj);
		return null;
	}
	@Override
	public Long nextId() {
		Long a=invRepo.getNextId();
		if (a>0)
			return a+1;	
		return 0l;
	}
	@Override
	public List<InvoiceListDto> getInvoiceList() {
		// TODO Auto-generated method stub
		return  invRepo.findAll().stream().map(e->InvoiceMapper.mapToListDto(e)).collect(Collectors.toList());

	}
	@Override
	public InvoiceDto updateInvoiceDto(Long id,InvoiceDto obj) {
		
		Invoice invoice=invRepo.findById(id).orElse(null);
		if(invoice!=null) {
			invoice=invRepo.save(InvoiceMapper.mapToEntity(obj));
			return InvoiceMapper.mapToDto(invoice);
		}
		return null;
	}
	@Override
	public boolean deleteInvoice(long id) {
		Invoice invoice=invRepo.findById(id).orElse(null);
		if(invoice!=null) {
			invRepo.delete(invoice);
			return true;
		}
		return false;
	}
	
	
	
	
}
