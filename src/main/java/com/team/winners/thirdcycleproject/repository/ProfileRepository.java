package com.team.winners.thirdcycleproject.repository;

import com.team.winners.thirdcycleproject.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long>{

}
