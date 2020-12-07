package com.cg.training.service;

import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.AdminException;


public interface AdminService {
	public void addMember(MemberInformation memberInformation) throws AdminException;
	public void updateMember(MemberInformation memberInformation) throws AdminException;
	public int deleteMember(Integer memberId) throws AdminException;
	public void searchMember(MemberInformation memberInformation) throws AdminException;

}
