package com.roadline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roadline.models.Admin;

public interface AdminRepo extends JpaRepository<Admin, String> {
	
	Admin findByUsernameAndPassword(String username,String password);

}
