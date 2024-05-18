package com.roadline.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KpiDto {
	List<Consignee> consignee;
	List<Consignor> consignor;
	List<Driver> driver;
	List<Vehicle> vehicles;
	
	Long ConsigneeCount;
	Long ConsignorCount;
	Long DriverCount;
	Long VehicleCount;
}


