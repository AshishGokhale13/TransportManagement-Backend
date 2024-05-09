package com.roadline.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long invoice_id;
	String lorryNo;
	String lorryOwnerName;
	Long lorryOwnerMobile;
	String driverName;
	String driverMobile;
	long dln;
	
	String locationFrom;
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
