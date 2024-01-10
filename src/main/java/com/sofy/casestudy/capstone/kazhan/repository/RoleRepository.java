package com.sofy.casestudy.capstone.kazhan.repository;

import com.sofy.casestudy.capstone.kazhan.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


//Offers CRUD functions and custom query method for finding roles by their names

public interface RoleRepository extends JpaRepository<Role, Long>
{ Role findByName(String name); }