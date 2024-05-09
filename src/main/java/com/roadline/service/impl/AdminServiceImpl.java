package com.roadline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadline.models.Admin;
import com.roadline.repo.AdminRepo;
import com.roadline.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo adminRepo;
	@Override
	
	public Admin saveAdmin(Admin obj) {
		return adminRepo.save(obj);
	}
	@Override
	public boolean validateAdminCredentials(Admin obj) {
		Admin admin=adminRepo.findByUsernameAndPassword(obj.getUsername(), obj.getPassword());
		if(admin!=null)
			return true;
		return false;
	}

}
