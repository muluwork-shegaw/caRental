package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Bill;

public interface BillService {
    Bill saveBill(Bill bill);
    Bill getBillById(Long id);
    void deleteBill(Long id);
}
