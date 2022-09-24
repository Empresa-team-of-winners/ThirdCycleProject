package com.team.winners.thirdcycleproject.service;
import com.team.winners.thirdcycleproject.models.Profile;
import com.team.winners.thirdcycleproject.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> findAll(){return profileRepository.findAll();}

    public <S extends Profile> S save(S entity) {
        return profileRepository.save(entity);
    }
    public void update(Profile enterpriseRequest, Integer id){
        Optional<Profile> profileOptional = this.profileRepository.findById(id);
        Profile profile = profileOptional.get();

        profile.setImage(enterpriseRequest.getImage());
        profile.setPhone(enterpriseRequest.getPhone());
    }

    public Optional<Profile> findById(Integer id) {
        return profileRepository.findById(id);
    }
    public Boolean deleteById(Integer id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
