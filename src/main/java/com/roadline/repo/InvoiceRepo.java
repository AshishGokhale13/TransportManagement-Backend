package com.roadline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.roadline.models.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
	
	@Query("SELECT MAX(ID) from Invoice")
	Long getNextId();
}
