package com.epstore.service;

import com.epstore.DTO.AdminLoginResponseDTO;
import com.epstore.DTO.AdminRegisterRequest;
import com.epstore.DTO.loginRequestDTO;
import com.epstore.entities.Admin;

public interface AdminService
{
	AdminLoginResponseDTO validateAdmin(loginRequestDTO loginreq);

	Admin updateAdminDetails(Admin existAdmin);

	String addAdmin(AdminRegisterRequest dto);

	String removeAdmin(Long adminId);

	Admin getAdminDetailsById(Long Id);

}
