package com.lopit.culturallifeoftranscarpathia.persistence.repository.contract;

import com.lopit.culturallifeoftranscarpathia.domain.exception.EntityNotFoundException;
import com.lopit.culturallifeoftranscarpathia.persistence.entity.User;
import com.lopit.culturallifeoftranscarpathia.persistence.entity.UserRole;
import java.util.List;

public interface UserRepository {
  List<User> findAll();
  void addUser(User user);
  User findByUsername(String username) throws EntityNotFoundException;
  boolean isUsernameExists(String username);
  void updateUserRole(String username, UserRole newRole) throws EntityNotFoundException;
  void deleteUser(String username) throws EntityNotFoundException;
}