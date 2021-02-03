package com.byung8.mydiet.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.byung8.common.domain.IResult;
import com.byung8.common.domain.Result;
import com.byung8.common.domain.SearchOption;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.mydiet.domain.ExerciseParam;
import com.byung8.mydiet.domain.FitnessMember;
import com.byung8.mydiet.service.ExerciseService;
import com.byung8.mydiet.service.FitnessMemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * RestServiceController class
 * 
 * @author 06919
 *
 */
@RestController
@Slf4j
@RequestMapping(value = "/fitness")
public class FitnessController {

	@Autowired
	ExerciseService exerciseService;
	
	@Autowired
	FitnessMemberService fitnessMemberService;
	
	private String txId() {
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public ResponseEntity<String> registerExerciseParam(@RequestBody final FitnessMember fitnessMember) {

		String txid = txId();
		try {
			Result result = fitnessMemberService.registerFsMember(fitnessMember, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to register FitnessMember", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/member/{email}/email", method = RequestMethod.GET)
	public ResponseEntity<String> findMemberByEmail(@PathVariable("email") final String email) {

		String txid = txId();
		try {
			Result result = fitnessMemberService.findFsMemberByEmail(email, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to findFsMemberByEmail", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/member/{name}/name", method = RequestMethod.GET)
	public ResponseEntity<String> findMemberByName(@PathVariable("name") final String name) {

		String txid = txId();
		try {
			Result result = fitnessMemberService.findFsMemberByName(name, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to findFsMemberByName", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/member/{id}/id", method = RequestMethod.GET)
	public ResponseEntity<String> findMemberById(@PathVariable("id") final int id) {

		String txid = txId();
		try {
			Result result = fitnessMemberService.findFsMemberById(id, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to findFsMemberById", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/member/list", method = RequestMethod.POST)
	public ResponseEntity<String> findMemberList(@RequestBody final SearchOption searchOption) {

		String txid = txId();
		try {
			Result result = fitnessMemberService.findFsMemberList(searchOption, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to findFsMemberList", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/exercise/calorie/{paramId}/{weight}/{minute}", method = RequestMethod.GET)
	public ResponseEntity<String> calculateCalorie(@PathVariable("paramId") final int paramId
			, @PathVariable("weight") final float weight
			, @PathVariable("minute") final int minute) {

		String txid = txId();
		try {
			Result result = exerciseService.calculateCalorie(paramId, weight, minute, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to fetch calculateCalorie", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/exercise/param", method = RequestMethod.POST)
	public ResponseEntity<String> registerExerciseParam(@RequestBody final ExerciseParam exerciseParam) {

		String txid = txId();
		try {
			Result result = exerciseService.registerExercseParam(exerciseParam, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to register exerciseParam", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/exercise/param/{paramId}", method = RequestMethod.GET)
	public ResponseEntity<String> getExcParam(@PathVariable("paramId") final int paramId) {

		String txid = txId();
		try {
			Result result = exerciseService.getExcParamById(paramId, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to fetch getExcParamById", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/exercise/paramlist/{paramName}", method = RequestMethod.GET)
	public ResponseEntity<String> getExcParamList(@PathVariable("paramName") final String paramName) {

		String txid = txId();
		try {
			Result result = exerciseService.getExcParams(paramName, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to fetch ExcParamList", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

}
