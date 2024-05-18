package com.roadline.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.roadline.Dto.Consignee;
import com.roadline.Dto.Consignor;
import com.roadline.Dto.Driver;
import com.roadline.Dto.MonthlyTargets;
import com.roadline.Dto.Vehicle;
import com.roadline.models.Invoice;


public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
	
	@Query("SELECT MAX(ID) from Invoice")
	Long getNextId();
	
	
	 @Query("SELECT DISTINCT new com.roadline.Dto.Consignor(i.consignor, i.consignorGst) FROM Invoice i")
	    Page<Consignor> findDistinctConsignors(Pageable pagable);
	    
	    @Query("SELECT DISTINCT new com.roadline.Dto.Consignee(i.consignee, i.consigneeGst) FROM Invoice i")
	    Page<Consignee> findDistinctConsignees(Pageable pagable);
	    
	    @Query("SELECT DISTINCT new com.roadline.Dto.Driver(i.driverName, i.driverMobile) FROM Invoice i")
	    Page<Driver> findDistinctDrivers(Pageable pagable);
	    
	    @Query("SELECT DISTINCT new com.roadline.Dto.Vehicle(i.lorryNo, i.driverName, i.driverMobile, i.lorryOwnerName, i.lorryOwnerMobile) FROM Invoice i")
	    Page<Vehicle> findDistinctVehicles(Pageable pagable);
	    
	    @Query("SELECT SUM(i.advance), SUM(i.rate) FROM Invoice i")
	    Object[] getTotalAdvanceAndRate();
	    
	    
	    @Query(value = "SELECT NEW com.roadline.Dto.MonthlyTargets(MONTH(i.date) AS month, COUNT(*) AS count) " +
                "FROM Invoice i " +
                "WHERE i.date BETWEEN ?1 AND ?2 " +
                "GROUP BY MONTH(i.date)")
	    List<MonthlyTargets> findByDateBetween(Date starDate,Date enDate);


}
