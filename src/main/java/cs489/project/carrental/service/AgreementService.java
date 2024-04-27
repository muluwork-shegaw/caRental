package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Agreement;

public interface AgreementService {
    Agreement saveAgreement(Agreement agreement);
    Agreement getAgreementById(Long id);
    void deleteAgreement(Long id);
}
