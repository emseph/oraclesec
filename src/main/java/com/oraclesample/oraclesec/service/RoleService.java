package com.oraclesample.oraclesec.service;

import com.oraclesample.oraclesec.model.Role;
import com.oraclesample.oraclesec.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role show(int id){
        Optional<Role> optional = roleRepository.findById(id);
        Role role = null;
        if(optional.isPresent()){
            role = optional.get();
        }else {
            throw  new RuntimeException("Role not found for id :: " + id);
        }
        return role;
    }
}
