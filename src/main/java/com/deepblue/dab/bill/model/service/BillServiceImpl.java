package com.deepblue.dab.bill.model.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepblue.dab.bill.model.dao.BillDao;
import com.deepblue.dab.bill.model.vo.Bill;

@Service("billService")
public class BillServiceImpl implements BillService{
	@Autowired
	private BillDao billDao;

	@Override
	public int insertBill(Bill bill) {
		return billDao.insertBill(bill);
	}

	@Override
	public Bill selectBill(Timestamp bill_timestamp) {
		return billDao.selectBill(bill_timestamp);
	}
	
	
}
