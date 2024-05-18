package com.roadline.service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.roadline.Dto.Consignee;
import com.roadline.Dto.Consignor;
import com.roadline.Dto.Driver;
import com.roadline.Dto.InvoiceDto;
import com.roadline.Dto.InvoiceListDto;
import com.roadline.Dto.KpiDto;
import com.roadline.Dto.MonthlyTargets;
import com.roadline.Dto.Percentage;
import com.roadline.Dto.Vehicle;
import com.roadline.mapper.InvoiceMapper;
import com.roadline.models.Invoice;
import com.roadline.repo.InvoiceRepo;
import com.roadline.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepo invRepo;

	@Override
	public InvoiceDto addInvoiceDto(InvoiceDto obj) {
		return InvoiceMapper.mapToDto(invRepo.save(InvoiceMapper.mapToEntity(obj)));
	}

	@Override
	public InvoiceDto getInVoice(Long id) {

		Invoice obj = invRepo.findById(id).orElse(null);
		if (obj != null)
			return InvoiceMapper.mapToDto(obj);
		return null;
	}

	@Override
	public Long nextId() {
		Long a = invRepo.getNextId();
		if (a > 0)
			return a + 1;
		return 0l;
	}

	@Override
	public List<InvoiceListDto> getInvoiceList() {
		// TODO Auto-generated method stub
		return invRepo.findAll().stream().map(e -> InvoiceMapper.mapToListDto(e)).collect(Collectors.toList());

	}

	@Override
	public InvoiceDto updateInvoiceDto(Long id, InvoiceDto obj) {

		Invoice invoice = invRepo.findById(id).orElse(null);
		if (invoice != null) {
			invoice = invRepo.save(InvoiceMapper.mapToEntity(obj));
			return InvoiceMapper.mapToDto(invoice);
		}
		return null;
	}

	@Override
	public boolean deleteInvoice(long id) {
		Invoice invoice = invRepo.findById(id).orElse(null);
		if (invoice != null) {
			invRepo.delete(invoice);
			return true;
		}
		return false;
	}

	@Override
	public KpiDto getKpi() {

		KpiDto obj = new KpiDto();
		Page<Consignor> consignorPage = invRepo.findDistinctConsignors(PageRequest.of(0, 10));
		Page<Consignee> consigneePage = invRepo.findDistinctConsignees(PageRequest.of(0, 10));
		Page<Driver> driverPage = invRepo.findDistinctDrivers(PageRequest.of(0, 10));
		Page<Vehicle> vehiclePage = invRepo.findDistinctVehicles(PageRequest.of(0, 10));

		List<Consignor> consignors = consignorPage.getContent();
		List<Consignee> consignees = consigneePage.getContent();
		List<Driver> dirivers = driverPage.getContent();
		List<Vehicle> vehicles = vehiclePage.getContent();

		obj.setConsignor(consignors);
		obj.setConsignee(consignees);
		obj.setDriver(dirivers);
		obj.setVehicles(vehicles);
		obj.setConsigneeCount(consigneePage.getTotalElements());
		obj.setConsignorCount(consignorPage.getTotalElements());
		obj.setDriverCount(driverPage.getTotalElements());
		obj.setVehicleCount(vehiclePage.getTotalElements());

		return obj;
	}

	public Percentage percentage() {
		Object[] sumOfAmounts = invRepo.getTotalAdvanceAndRate();

		sumOfAmounts = (Object[]) sumOfAmounts[0];

		double totalAdvance = (double) sumOfAmounts[0];
		double totalRate = (double) sumOfAmounts[1];
		double advancePercentage = (totalAdvance / totalRate) * 100;
		double remainingPercentage = 100 - advancePercentage;
		return new Percentage(advancePercentage, remainingPercentage, totalRate, totalRate - totalAdvance,
				totalAdvance);

	}

	@Override
	public List<MonthlyTargets> getMothlyTarget() {
		LocalDate startDate = LocalDate.of(2024, 1, 1); // January 1st, 2024
		LocalDate endDate = LocalDate.now(); // Current date

		Timestamp startTimestamp = Timestamp.valueOf(startDate.atStartOfDay());
		Timestamp endTimestamp = Timestamp.valueOf(endDate.atStartOfDay());

		return  invRepo.findByDateBetween(startTimestamp, endTimestamp);

			}

}
