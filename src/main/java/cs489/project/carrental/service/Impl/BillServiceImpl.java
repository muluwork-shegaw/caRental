package cs489.project.carrental.service.Impl;

import cs489.project.carrental.model.domain.Bill;
import cs489.project.carrental.repository.BillRepository;
import cs489.project.carrental.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }
}
