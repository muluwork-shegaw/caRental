package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Branch;

public interface BranchService {
    Branch saveBranch(Branch branch);
    Branch getBranchById(Long id);
    void deleteBranch(Long id);
}
