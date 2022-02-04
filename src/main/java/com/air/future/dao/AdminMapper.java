package com.air.future.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.air.future.vo.Admin;

public interface AdminMapper {

	// 관리자 로그인
	public Admin selectAdmin(String admin_id);

	// 오늘 수익, 예약수
	public HashMap<String,String> todayInComeReservation();
	
	// 오늘 비행일정
	public HashMap<String,String> todayFlight();
	
	// 인기 예약 5개
	public ArrayList<HashMap<String,String>> popularFlight();
	
	// 대륙별 점유율
	public ArrayList<HashMap<String,String>> rateContinents();
	
	// 최근 예약 5개
	public ArrayList<HashMap<String,String>> recentReservation();
	
}
