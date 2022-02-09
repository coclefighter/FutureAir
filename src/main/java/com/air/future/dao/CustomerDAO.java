package com.air.future.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.air.future.vo.Customer;
import com.air.future.vo.Grade;

@Repository
public class CustomerDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// 페이징 처리 : 회원정보(customerList.jsp)를 위한 부분
	public int customerGetTotal(Customer customer) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		int result = mapper.customerGetTotal(customer);
		return result;
	}
	
	// 회원정보 전체 불러오기
	public ArrayList<Customer> customerListAll() {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		ArrayList<Customer> customerListAll = mapper.customerListAll();
		return customerListAll;
	}
	
	// 페이징 처리 : 회원정보(customerList.jsp) 검색 결과 값 불러오기
	public ArrayList<Customer> customerFind(Customer customer, int startRecord, int countPerPage) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		ArrayList<Customer> customerFind = mapper.customerFind(customer, rb);
		return customerFind;
	}
	
	// 회원정보 삭제하기
	public int customerDelete(ArrayList<Customer> customerList) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.mileageDelete(customerList);
		mapper.reservationDelete(customerList);
		int result = mapper.customerDelete(customerList);
		return result;
	}
	
	// 회원 세부정보에 필요한 회원정보 불러오기
	public Customer customerInfoFind(String customer_id) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		Customer customer = mapper.customerInfoFind(customer_id);
		return customer;
	}
	
	// 회원 세부정보에 필요한 회원 마일리지 불러오기
	public String customerMileageFind(String mileage_id) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		String mileage = mapper.customerMileageFind(mileage_id);
		return mileage;
	}
	
	// 회원 세부정보에 필요한 회원 총결제금액 불러오기
	public String customerFullPay(String customer_id) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		String customerFullPay = mapper.customerFullPay(customer_id);
		return customerFullPay;
	}
	
	// 페이징 처리 : 회원등급(customerGrade.jsp)을 위한 부분
	public int gradeGetTotal(Customer customer) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		int result = mapper.gradeGetTotal(customer);
		return result;
	}

	
	// 회원등급 및 회원등급에 따른 전체 회원수 불러오기
	public ArrayList<Grade> customerGradeAll() {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		ArrayList<Grade> customerGradeAll = mapper.customerGradeAll();
		return customerGradeAll;
	}
	
	// 페이징 처리 : 회원등급별 회원관리 부분 검색 결과 값 불러오기
	public ArrayList<Customer> gradeFind(Customer customer, int startRecord, int countPerPage) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		ArrayList<Customer> gradeFind = mapper.gradeFind(customer, rb);
		return gradeFind;
	}
	
	// 모달창을 통한 회원 등급을 추가하기 이전에 등급 명칭 중복 검사
	public int gradeDuplication(String grade) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		int result = mapper.gradeDuplication(grade);
		return result;
	}
	
	// 모달창을 통한 회원 등급 추가하기
	public int gradeAdd(Grade grade) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		int result = mapper.gradeAdd(grade);
		return result;
	}
	
	// 회원 총 마일리지 불러오기
	public String mileageAll(String id) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		String result = mapper.mileageAll(id);
		return result;
	}
	// 회원 사용한 마일리지 불러오기
	public String mileageUsed(String id) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		String result = mapper.mileageUsed(id);
		return result;
	}
	// 회원 사용가능한 마일리지 불러오기
	public String mileageUsable(String id) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		String result = mapper.mileageUsable(id);
		return result;
	}
	// 회원 미가용 마일리지 불러오기
	public String mileageFUsable(String id) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class); 
		String result = mapper.mileageFUsable(id);
		return result;
	}
	// 회원 마일리지 내역 불러오기
	public List<HashMap<String, String>> mileageBalance(String id) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		List<HashMap<String, String>> result = mapper.mileageBalance(id);
		return result;
	}



}