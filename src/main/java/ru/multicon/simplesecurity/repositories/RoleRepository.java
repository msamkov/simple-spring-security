package ru.multicon.simplesecurity.repositories;


import org.springframework.data.repository.CrudRepository;
import ru.multicon.simplesecurity.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}


