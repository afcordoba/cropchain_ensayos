package com.gdm.repository.dao.intefaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdm.entities.Usuario;

@Repository
public interface IUserRepository extends JpaRepository<Usuario, Integer>  {
    public Usuario findByUsuario(String username);
}