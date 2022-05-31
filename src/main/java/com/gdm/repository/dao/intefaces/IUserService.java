package com.gdm.repository.dao.intefaces;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.gdm.dto.ChangePasswordForm;
import com.gdm.entities.User;
import com.gdm.exception.UsernameOrIdNotFound;

@Repository
public interface IUserService  {
    public Optional<User> findByUsuario(String username);
    public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	
	public User changePassword(ChangePasswordForm form) throws Exception;
}