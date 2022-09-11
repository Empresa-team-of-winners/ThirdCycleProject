package com.team.winners.thirdcycleproject.service;

import com.team.winners.thirdcycleproject.models.Enterprise;
import com.team.winners.thirdcycleproject.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }

    public <S extends Enterprise> S save(S entity) {
        return enterpriseRepository.save(entity);
    }

    public void update(Enterprise enterpriseRequest, Long id){
            Optional<Enterprise> enterpriseOp = this.enterpriseRepository.findById(id);
            Enterprise enterprise = enterpriseOp.get();

            enterprise.setName(enterpriseRequest.getName());
            enterprise.setAddress(enterpriseRequest.getAddress());
            enterprise.setPhone(enterpriseRequest.getPhone());
            enterprise.setDocument(enterpriseRequest.getDocument());

    }

    public Optional<Enterprise> findById(Long id) {
        return enterpriseRepository.findById(id);
    }

    public Boolean deleteById(Long id) {
        if (enterpriseRepository.existsById(id)) {
            enterpriseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
