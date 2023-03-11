package com.epstore.service;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.epstore.DTO.AdminLoginResponseDTO;
import com.epstore.DTO.AdminRegisterRequest;
import com.epstore.DTO.loginRequestDTO;
import com.epstore.custom_exceptions.*;
import com.epstore.repository.AdminRepo;
import com.epstore.entities.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService
{

	@Autowired
	private AdminRepo dao;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder passEncode;

	@Override
	public AdminLoginResponseDTO validateAdmin(loginRequestDTO loginreq)
	{
		Admin admin = dao.findByEmail(loginreq.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
		if (passEncode.matches(loginreq.getPassword(), admin.getPassword())) 
		{
			return mapper.map(admin, AdminLoginResponseDTO.class);
		}
		throw new ResourceNotFoundException("Bad Credentials !!!!!");
	}

	@Override
	public Admin updateAdminDetails(Admin existAdmin)
	{
		if (dao.existsById(existAdmin.getId()))
		{
			return dao.save(existAdmin);
		}
		throw new ResourceNotFoundException("Invalid Admin Id !!!!!");
	}

	@Override
	public String addAdmin(AdminRegisterRequest dto)
	{
		String encodedPass = passEncode.encode(dto.getPassword());
		  if (dao.existsByEmail(dto.getEmail()))
		  {
			  throw new RuntimeException("Email Already Exists");
		  }
		  Admin newAdmin = new Admin();
		  newAdmin.setEmail(dto.getEmail());
		  newAdmin.setPassword(encodedPass);
		  newAdmin.setName(dto.getName());
		  dao.save(newAdmin);
		return "Admin Created with Id : "+newAdmin.getId();
	}

	@Override
	public String removeAdmin(Long adminId)
	{
		if(dao.existsById(adminId))
		{
			dao.deleteById(adminId);
			return "Admin deleted with Id : "+adminId;
		}
		return "Deletion Failed : Invalid Emp Id !!!!!!!!!!!";
	}

	@Override
	public Admin getAdminDetailsById(Long Id)
	{
		return dao.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Invalid Admin Id"));
	}
}
