package com.byung8.mydiet.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.byung8.mydiet.domain.FitnessMember;

@Mapper
public interface FitnessMemberMapper {
	int registerFsMember(FitnessMember fitnessMember) throws SQLException;
	FitnessMember findFsMemberByEmail(String email) throws SQLException;
	FitnessMember findFsMemberByName(String name) throws SQLException;
	FitnessMember findFsMemberById(int id) throws SQLException;
	List<FitnessMember> findFsMemberListByEmail(String email) throws SQLException;
	List<FitnessMember> findFsMemberListByName(String name) throws SQLException;
	List<FitnessMember> findFsMemberList() throws SQLException;
}
