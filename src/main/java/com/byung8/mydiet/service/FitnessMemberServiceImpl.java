package com.byung8.mydiet.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byung8.common.domain.Result;
import com.byung8.common.domain.SearchOption;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.mydiet.domain.FitnessMember;
import com.byung8.mydiet.mapper.FitnessMemberMapper;

import lombok.extern.slf4j.Slf4j;

@Service("fitnessMemberService")
@Slf4j
public class FitnessMemberServiceImpl implements FitnessMemberService {

	@Autowired
	FitnessMemberMapper fitnessMemberMapper;
	
	@Override
	public Result registerFsMember(FitnessMember fitnessMember, String txid) throws Byung8Exception {
		
		Result result = null;
		try {
			int cnt = fitnessMemberMapper.registerFsMember(fitnessMember);
			result = new Result(txid, Result.OK).putValue("result", cnt > 0 ? true : false);
		} catch(SQLException e) {
			log.error("registerFsMember", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findFsMemberByEmail(String email, String txid) throws Byung8Exception {
		Result result = null;
		try {
			FitnessMember fitnessMember = fitnessMemberMapper.findFsMemberByEmail(email);
			result = new Result(txid, Result.OK).putValue("FitnessMember", fitnessMember);
		} catch(SQLException e) {
			log.error("findFsMemberByEmail", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findFsMemberByName(String name, String txid) throws Byung8Exception {
		Result result = null;
		try {
			FitnessMember fitnessMember = fitnessMemberMapper.findFsMemberByName(name);
			result = new Result(txid, Result.OK).putValue("FitnessMember", fitnessMember);
		} catch(SQLException e) {
			log.error("findFsMemberByName", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findFsMemberById(int id, String txid) throws Byung8Exception {
		Result result = null;
		try {
			FitnessMember fitnessMember = fitnessMemberMapper.findFsMemberById(id);
			result = new Result(txid, Result.OK).putValue("FitnessMember", fitnessMember);
		} catch(SQLException e) {
			log.error("findFsMemberById", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result findFsMemberList(SearchOption searchOption, String txid) throws Byung8Exception {
		Result result = null;
		try {
			List<FitnessMember> list = null;
			if (log.isInfoEnabled()) {
				log.info("=========> searchOption " + searchOption);
			}
			if ("emal".equalsIgnoreCase(searchOption.getSearchField())) {
				list = fitnessMemberMapper.findFsMemberListByEmail(searchOption.getSearchValue());
				if (log.isDebugEnabled()) {
					log.debug("findFsMemberListByEmail : "+list.size());
				}
			} else if ("name".equalsIgnoreCase(searchOption.getSearchField())) {
				list = fitnessMemberMapper.findFsMemberListByName(searchOption.getSearchValue());
				if (log.isDebugEnabled()) {
					log.debug("findFsMemberListByName : "+list.size());
				}
			} else {
				list = fitnessMemberMapper.findFsMemberList();
				if (log.isDebugEnabled()) {
					log.debug("findFsMemberList : "+list.size());
				}
			}
			
			result = new Result(txid, Result.OK).putValue("FitnessMemberList", list);
		} catch(SQLException e) {
			log.error("findFsMemberList", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

}
