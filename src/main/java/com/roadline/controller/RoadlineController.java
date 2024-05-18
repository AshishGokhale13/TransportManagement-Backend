package com.roadline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roadline.Dto.InvoiceDto;
import com.roadline.Dto.InvoiceListDto;
import com.roadline.Dto.KpiDto;
import com.roadline.Dto.MonthlyTargets;
import com.roadline.Dto.Percentage;
import com.roadline.responses.Response;
import com.roadline.service.InvoiceService;

@RestController
@RequestMapping("/admin")
public class RoadlineController {

	@Autowired
	InvoiceService invServ;

	@PostMapping("/invoice")
	public ResponseEntity<Response> saveInvoice(@RequestBody InvoiceDto obj) {
		
		InvoiceDto invoice =invServ.addInvoiceDto(obj);
		if(invoice!=null)
			return new ResponseEntity<>(Response.success(invoice),HttpStatusCode.valueOf(200));
		return new ResponseEntity<>(Response.error(400,null,400,"System error"),HttpStatusCode.valueOf(400));
		
	}

	@GetMapping("/invoice/{id}")
	public Object saveInvoice(@PathVariable Long id) {
		
		InvoiceDto invoice =invServ.getInVoice(id);
		if(invoice!=null)
			return new ResponseEntity<>(Response.success(invoice),HttpStatusCode.valueOf(200));
		return new ResponseEntity<>(Response.error(400,id,400,"Entry is not present in system"),HttpStatusCode.valueOf(400));
	
	}

	@GetMapping("/invoice/nextid")
	public Long getNextAvailableId() {
		return invServ.nextId();
	}

	@GetMapping("/invoice/list")
	public ResponseEntity<Response> getList() {
		
		List<InvoiceListDto> invoiceList=invServ.getInvoiceList();
		if(!invoiceList.isEmpty())
			return new ResponseEntity<>(Response.success(invoiceList),HttpStatusCode.valueOf(200));
		return new ResponseEntity<>(Response.error(200,null,200,"No entry is not present in system"),HttpStatusCode.valueOf(200));
	}
	
	
	@PutMapping("/invoice/{id}")
	public ResponseEntity<Response> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDto obj) {
		
		InvoiceDto invoice =invServ.updateInvoiceDto(id,obj);
		if(invoice!=null)
			return new ResponseEntity<>(Response.success(invoice),HttpStatusCode.valueOf(200));
		return new ResponseEntity<>(Response.error(400,obj,400,"Unable to find the entry to modify"),HttpStatusCode.valueOf(400));
	 
	}
	
	@DeleteMapping("/invoice/{id}")
	public Object deleteInvoice(@PathVariable Long id ) {
		
		if(invServ.deleteInvoice(id))
			return new ResponseEntity<>(Response.success(id,String.format("Entry %s removed successfully",id)),HttpStatusCode.valueOf(200));
		return new ResponseEntity<>(Response.error(400,id,400,"Unable to find the entry to remove"),HttpStatusCode.valueOf(400));
	 
	}
	
	
	
	@GetMapping("/invoice/kpi")
	public ResponseEntity<Response> getKpi()
	{
		KpiDto obj=invServ.getKpi();
		if(obj!=null)
		return new ResponseEntity<>(Response.success(obj),HttpStatusCode.valueOf(200));
		return new ResponseEntity<>(Response.error(404, obj, 404,"No Record found"),HttpStatusCode.valueOf(404));
	}
	
	
	@GetMapping("/percentage")
	public ResponseEntity<Response> getPercentage()
	{
		Percentage p=invServ.percentage();
		if (p!=null)
		return  new ResponseEntity<>(Response.success(p),HttpStatusCode.valueOf(200));
		return  new ResponseEntity<>(Response.error(400,null,404,"bad request"),HttpStatusCode.valueOf(400));
	}
	
	

	@GetMapping("/monthlyTarget")
	public ResponseEntity<Response> getMonthlytarget()
	{
		
		List<MonthlyTargets> obj=invServ.getMothlyTarget();
		
		if(obj!=null)
		return  new ResponseEntity<>(Response.success(obj),HttpStatusCode.valueOf(200));
		return  new ResponseEntity<>(Response.error(400,null,404,"No Records"),HttpStatusCode.valueOf(400));

	
	}
	
	
	
	
}