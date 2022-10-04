package com.deepblue.dab.bill.model.service;

import java.sql.Timestamp;

import com.deepblue.dab.bill.model.vo.Bill;

public interface BillService {

	int insertBill(Bill bill);
	
	Bill selectBill(Timestamp bill_timestamp);
}
