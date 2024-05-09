package com.roadline.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceDto {

	Long invoice_id;
	String lorryNo;
	@Override
	public String toString() {
		return "InvoiceDto [invoice_id=" + invoice_id + ", lorryNo=" + lorryNo + ", lorryOwnerName=" + lorryOwnerName
				+ ", lorryOwnerMobile=" + lorryOwnerMobile + ", driverName=" + driverName + ", driverMobile=" + driverMobile
				+ ", dln=" + dln + ", locationForm=" + locationForm + ", locationTo=" + locationTo + ", party=" + party
				+ ", consignor=" + consignor + ", consignorGst=" + consignorGst + ", consignee=" + consignee
				+ ", consigneeGst=" + consigneeGst + ", noBalse=" + noBalse + ", quality=" + quality + ", PRN=" + PRN
				+ ", pMarks=" + pMarks + ", LotNo=" + LotNo + ", privateMark=" + privateMark + ", invoNo=" + invoNo
				+ ", valueOfGoods=" + valueOfGoods + ", weight=" + weight + ", advance=" + advance + ", rate=" + rate
				+ ", rs=" + rs + ", date=" + date + "]";
	}
	String lorryOwnerName;
	Long lorryOwnerMobile;
	String driverName;
	String driverMobile;
	long dln;
	String locationForm;
	String locationTo;
	String party;
	String consignor;
	String consignorGst;
	String consignee;
	String consigneeGst;
	long noBalse;
	String quality;
	String PRN;
	String pMarks;
	String LotNo;
	String privateMark;
	String invoNo;
	String valueOfGoods;
	double weight;	
	double advance;
	double rate;
	double rs;
	Date date;
	
	
}
