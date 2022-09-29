package com.team.winners.thirdcycleproject.service;

import com.team.winners.thirdcycleproject.models.Employee;
import com.team.winners.thirdcycleproject.models.Enterprise;
import com.team.winners.thirdcycleproject.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public void update(Enterprise enterpriseRequest, Integer id){
            Optional<Enterprise> enterpriseOp = this.enterpriseRepository.findById(id);
            Enterprise enterprise = enterpriseOp.get();

            enterprise.setName(enterpriseRequest.getName());
            enterprise.setAddress(enterpriseRequest.getAddress());
            enterprise.setPhone(enterpriseRequest.getPhone());
            enterprise.setDocument(enterpriseRequest.getDocument());

    }

    public Optional<Enterprise> findById(Integer id) {
        return enterpriseRepository.findById(id);
    }

    public Boolean deleteById(Integer id) {
        if (enterpriseRepository.existsById(id)) {
            enterpriseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Enterprise> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.enterpriseRepository.findAll(pageable);
    }
}
