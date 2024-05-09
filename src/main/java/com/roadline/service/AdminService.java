package com.roadline.service;

import com.roadline.models.Admin;

public interface AdminService {

	Admin saveAdmin(Admin obj);
	boolean validateAdminCredentials(Admin obj);
}
