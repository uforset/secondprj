package com.deepblue.dab.bill.model.dao;

import java.sql.Timestamp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deepblue.dab.bill.model.vo.Bill;



@Repository("billDao")
public class BillDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public int insertBill(Bill bill) {
		return session.insert("billMapper.insertBill", bill);
	}

	public Bill selectBill(Timestamp bill_timestamp) {
		return session.selectOne("calendarMapper.selectBillTime", bill_timestamp);
	}
}
