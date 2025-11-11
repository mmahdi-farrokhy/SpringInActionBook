package org.mmf.chapter7.data;

import org.mmf.chapter7.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
