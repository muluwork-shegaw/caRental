package cs489.project.carrental.service.Impl;

import cs489.project.carrental.model.domain.Agreement;
import cs489.project.carrental.repository.AgreementRepository;
import cs489.project.carrental.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementServiceImpl implements AgreementService {

    @Autowired
    private AgreementRepository agreementRepository;

    @Override
    public Agreement saveAgreement(Agreement agreement) {
        return agreementRepository.save(agreement);
    }

    @Override
    public Agreement getAgreementById(Long id) {
        return agreementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAgreement(Long id) {
        agreementRepository.deleteById(id);
    }
}
