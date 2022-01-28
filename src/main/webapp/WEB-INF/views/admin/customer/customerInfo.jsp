<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,height=device-height,initial-scale=1,maximum-scale=1,user-scalable=no,viewport-fit=cover">
    <link rel="stylesheet" href="resources/css/admin.css">
    <title>미래항공 관리자페이지</title>
</head>
<body>
    <!-- customer detail  S -->  
    <div class="customer_detail">
        <div class="inner">
            <!-- customer header  S -->  
            <header class="customer_header">
                <nav class="lnb">
                    <ul>
                        <li class="active"><a href="customerInfo.html">회원정보</a></li>
                        <li><a href="customerReservation.html">예약내역</a></li>
                        <li><a href="customerMileage.html">마일리지</a></li>
                    </ul>
                </nav>
                <div class="profile">
                    <div class="profile_img">
                        <img src="../../../images/profile.jpg" alt="proifle">
                    </div>
                    <p class="profile__info">홍길동<span>일반등급</span></p>
                </div>
            </header>
            <!-- customer header E --> 
        </div>
        <!-- customer contents S -->  
        <div class="customer_contents">
            <div class="inner">
                <!-- customer content S -->  
                <section class="customer_content">
                    <h2>기본정보</h2>
                    <!-- table S --> 
                    <table class="table">
                        <tr>
                            <th>이름</th>
                            <td>홍길동</td>
                            <th>아이디</th>
                            <td>hong123</td>
                        </tr>
                        <tr>
                            <th>생년월일</th>
                            <td>2000-01-01</td>
                            <th>성별</th>
                            <td>남자</td>
                        </tr>
                        <tr>
                            <th>회원등급</th>
                            <td>일반등급</td>
                            <th>가입날짜</th>
                            <td>2022-01-01</td>
                        </tr>
                        <tr>
                            <th>전화번호</th>
                            <td>010-1234-0123</td>
                            <th>이메일</th>
                            <td>hong123@gmail.com</td>
                        </tr>
                        <tr>
                            <th>주소</th>
                            <td colspan="3">부산 진구 새싹로 123번지 12</td>
                        </tr>
                    </table>
                    <!-- table E --> 
                </section>
                <!-- customer content E -->  
                <!-- customer content S -->  
                <section class="customer_content">
                    <h2>사용정보</h2>
                    <table class="table">
                        <tr>
                            <th>마일리지</th>
                            <td>50,000</td>
                            <th>총결제금액</th>
                            <td>1,000,000</td>
                        </tr>
                    </table>
                </section>
                <!-- customer content E-->  
            </div>
        </div>
        <!-- customer contents  E -->  
    </div>
    <!-- customer detail  E -->  
</body>
</html>