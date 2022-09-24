package com.team.winners.thirdcycleproject.repository;

import com.team.winners.thirdcycleproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
