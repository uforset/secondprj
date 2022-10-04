package com.deepblue.dab.calendar.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deepblue.dab.bill.model.service.BillService;
import com.deepblue.dab.bill.model.vo.Bill;
import com.deepblue.dab.calendar.model.service.CalendarService;
import com.deepblue.dab.calendar.model.vo.DateData;

@Controller
public class CalendarController {
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);

	@Autowired // 자동 의존성주임(DI) (자동 객체 생성됨)
	private BillService billService;
	
	// @Autowired
	// private CalendarService calendarService;
	
	@RequestMapping(value="calendarListView.do", method = RequestMethod.GET)
	public String calendar(Model model, HttpServletRequest request, DateData dateData){
		
		Calendar cal = Calendar.getInstance();
		DateData calendarData;
		//검색 날짜
		if(dateData.getDate().equals("")&&dateData.getMonth().equals("")){
			dateData = new DateData(String.valueOf(cal.get(Calendar.YEAR)),String.valueOf(cal.get(Calendar.MONTH)),String.valueOf(cal.get(Calendar.DATE)),null);
		}
		//검색 날짜 end

		Map<String, Integer> today_info =  dateData.today_info(dateData);
		List<DateData> dateList = new ArrayList<DateData>();
		
		//실질적인 달력 데이터 리스트에 데이터 삽입 시작.
		//일단 시작 인덱스까지 아무것도 없는 데이터 삽입
		for(int i=1; i<today_info.get("start"); i++){
			calendarData= new DateData(null, null, null, null);
			dateList.add(calendarData);
		}
		
		//날짜 삽입
		for (int i = today_info.get("startDay"); i <= today_info.get("endDay"); i++) {
			if(i==today_info.get("today")){
				calendarData= new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()), String.valueOf(i), "today");
			}else{
				calendarData= new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()), String.valueOf(i), "normal_date");
			}
			dateList.add(calendarData);
		}

		//달력 빈곳 빈 데이터로 삽입
		int index = 7 - dateList.size() % 7;
		
		if(dateList.size() % 7 !=0){
			
			for (int i = 0; i < index; i++) {
				calendarData= new DateData(null, null, null, null);
				dateList.add(calendarData);
			}
		}
		System.out.println(dateList);
		
		//배열에 담음
		model.addAttribute("dateList", dateList);		//날짜 데이터 배열
		model.addAttribute("today_info", today_info);
		return "calendar/calendarListView";
	}
	
	/*
	 * @RequestMapping(value="calendarDetailView.do", method = RequestMethod.GET)
	 * public String calendarDetailMethod(
	 * 
	 * @RequestParam("bill_timestamp") Timestamp bill_timestamp, Model model,
	 * HttpSession session) {
	 * 
	 * Bill bill = billService.selectBill(bill_timestamp);
	 * 
	 * if(bill != null) { model.addAttribute("bill", bill);
	 * 
	 * return "calendar/calendarDetailView";
	 * 
	 * } else { model.addAttribute("message", bill_timestamp + " 일정 지출 내역 상세보기 실패");
	 * return "common/error"; } }
	 */
   
   @RequestMapping("cdetail.do")
	public String moveWritePage() {
		return "calendar/calendarDetailView";
	}
	 
}
