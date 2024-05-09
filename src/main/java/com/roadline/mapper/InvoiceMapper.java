package com.roadline.mapper;

import com.roadline.Dto.InvoiceDto;
import com.roadline.Dto.InvoiceListDto;
import com.roadline.models.Invoice;

public class InvoiceMapper {

	public static Invoice mapToEntity(InvoiceDto obj)
	{
		return new Invoice(
		        obj.getInvoice_id(),
		        obj.getLorryNo(),
		        obj.getLorryOwnerName(),
		        obj.getLorryOwnerMobile(),
		        obj.getDriverName(),
		        obj.getDriverMobile(),
		        obj.getDln(),
		        obj.getLocationForm(),
		        obj.getLocationTo(),
		        obj.getParty(),
		        obj.getConsignor(),
		        obj.getConsignorGst(),
		        obj.getConsignee(),
		        obj.getConsigneeGst(),
		        obj.getNoBalse(),
		        obj.getQuality(),
		        obj.getPRN(),
		        obj.getPMarks(),
		        obj.getLotNo(),
		        obj.getPrivateMark(),
		        obj.getInvoNo(),
		        obj.getValueOfGoods(),
		        obj.getWeight(),
		        obj.getAdvance(),
		        obj.getRate(),
		        obj.getRs(),
		        obj.getDate());
	}
	public static InvoiceDto mapToDto(Invoice obj)
	{
		return new InvoiceDto(
		        obj.getInvoice_id(),
		        obj.getLorryNo(),
		        obj.getLorryOwnerName(),
		        obj.getLorryOwnerMobile(),
		        obj.getDriverName(),
		        obj.getDriverMobile(),
		        obj.getDln(),
		        obj.getLocationFrom(),
		        obj.getLocationTo(),
		        obj.getParty(),
		        obj.getConsignor(),
		        obj.getConsignorGst(),
		        obj.getConsignee(),
		        obj.getConsigneeGst(),
		        obj.getNoBalse(),
		        obj.getQuality(),
		        obj.getPRN(),
		        obj.getPMarks(),
		        obj.getLotNo(),
		        obj.getPrivateMark(),
		        obj.getInvoNo(),
		        obj.getValueOfGoods(),
		        obj.getWeight(),
		        obj.getAdvance(),
		        obj.getRate(),
		        obj.getRs(),
		        obj.getDate());
	}
	
	
	public static InvoiceListDto mapToListDto(Invoice obj)
	{
		return new InvoiceListDto(
		        obj.getInvoice_id(),
		        obj.getLorryNo(),
		        obj.getDriverName(),
		        obj.getConsignee(),
		        obj.getConsignor(),
		        obj.getAdvance(),
		        obj.getRs(),
		        obj.getDate());
	}
}
