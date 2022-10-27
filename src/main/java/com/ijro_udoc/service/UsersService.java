package com.ijro_udoc.service;

import com.ijro_udoc.model.Users;
import com.ijro_udoc.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users save(Users users) {
        return usersRepository.save(users);
    }
    public List<Users> findAll() {
        return usersRepository.findAll();
    }
    public Users findById(Long id) {
        return usersRepository.findById(id).get();
    }
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}
