package com.roadline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roadline.models.Admin;
import com.roadline.responses.Response;
import com.roadline.service.AdminService;

@RequestMapping("/admin")
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/credentials/save")
	public ResponseEntity<Response> saveAdmin(@RequestBody Admin obj)
	{
		 Admin admin=adminService.saveAdmin(obj);
		 if(admin !=null)
			 return new ResponseEntity<>(Response.success(admin),HttpStatusCode.valueOf(200));
		 return new ResponseEntity<>(Response.error(401,admin,401,"Unable to add Admin Credential"),HttpStatusCode.valueOf(401));	 
	}
	
	@PostMapping("/credentials")
	public ResponseEntity<Response> validateAdmin(@RequestBody Admin obj)
	{
		if(adminService.validateAdminCredentials(obj))
			 return new ResponseEntity<>(Response.success("Valiad User"),HttpStatusCode.valueOf(200));
		 return new ResponseEntity<>(Response.error(401,obj,401,"Unable to find Admin Credential"),HttpStatusCode.valueOf(401));	 
	}
}
