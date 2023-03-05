//package com.mybatis.test.repository;
//
//import com.mybatis.test.entity.Member;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
//public interface MemberRepository {
//
//    // 아래 코드를 Repository에 추가
//
//    // mapper를 호출하는 방식
//// 회원가입
//    void save1(Member memberMapperDTO);
//
//    // mapper를 호출하지 않고 여기서 쿼리까지 수행하는 방식
//// 아래같이 코드를 작성하면 mapper에 내용을 추가하지 않아도 됨
//// 사용하고자 하는 쿼리 종류(insert, select 등)에 맞춰 어노테이션을 붙여야함
//    @Insert("insert into member_table(member_email, member_password, member_name) values(#{member_email}, #{member_password}, #{member_name})")
//    void save2(Member memberMapperDTO);
//
//}
