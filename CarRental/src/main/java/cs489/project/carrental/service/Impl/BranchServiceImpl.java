package cs489.project.carrental.service.Impl;

import cs489.project.carrental.model.domain.Branch;
import cs489.project.carrental.repository.BranchRepository;
import cs489.project.carrental.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch getBranchById(Long id) {
        return branchRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}
