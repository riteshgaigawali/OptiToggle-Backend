package com.optitoggle.main;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.optitoggle.main.dao.RoleDao;
import com.optitoggle.main.entities.Roles;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	@Autowired
	private RoleDao roleDao;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String[] args) throws Exception {
		try {
			Roles role = new Roles();
			role.setRoleId(201);
			role.setDescription("This is an ADMIN-User");
			role.setRoleName("ROLE_ADMIN");

			Roles role1 = new Roles();
			role1.setRoleId(202);
			role1.setDescription("This is DEVELOPER");
			role1.setRoleName("ROLE_DEVELOPER");

			List<Roles> roles = List.of(role, role1);

			List<Roles> result = this.roleDao.saveAll(roles);
			result.forEach(r -> {
				System.out.println(r.getRoleName());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
