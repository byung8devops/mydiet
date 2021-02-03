package com.byung8.mydiet.service;

import com.byung8.common.domain.Result;
import com.byung8.common.domain.SearchOption;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.mydiet.domain.FitnessMember;

public interface FitnessMemberService {
	Result registerFsMember(FitnessMember fitnessMember, String txid) throws Byung8Exception;
	Result findFsMemberByEmail(String email, String txid) throws Byung8Exception;
	Result findFsMemberByName(String name, String txid) throws Byung8Exception;
	Result findFsMemberById(int id, String txid) throws Byung8Exception;
	Result findFsMemberList(SearchOption searchOption, String txid) throws Byung8Exception;
	Result modifyFsMember(FitnessMember fitnessMember, String txid) throws Byung8Exception;
	Result modifyFsMemberNotUsed(FitnessMember fitnessMember, String txid) throws Byung8Exception;
	Result modifyFsMemberAvailable(FitnessMember fitnessMember, String txid) throws Byung8Exception;
}
