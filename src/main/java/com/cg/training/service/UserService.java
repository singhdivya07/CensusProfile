package com.cg.training.service;


import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.UserException;


public interface UserService {
	public void addMember(MemberInformation memberInformation) throws UserException;
	public MemberInformation updateMember(MemberInformation memberInformation) throws UserException;
	public MemberInformation getMemberById(Integer memberId) throws UserException;
}
