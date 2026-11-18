package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User  findById(String id) {
        User user = repository.findById(id).orElse(null);

        if (user == null) {
            throw new ObjectNotFoundException("Object not found");
        }

        return user;


    }

    public User Insert(User obj) {
        return repository.insert(obj);
    }


    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public User delete(String id) {
        User user = repository.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Object not found");
        } else {
            repository.deleteById(id);
            return user;
        }
    }
    public User update(User obj) {

        User newObj = repository.findById(obj.getId()).orElse(null);
        updateData(newObj, obj);
      return repository.save(newObj);

    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }


}
