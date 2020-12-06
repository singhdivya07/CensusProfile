package com.cg.training.service;

import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.AdminException;


public interface AdminService {
	public void addMember(MemberInformation memInfo) throws AdminException;
	public void updateMember(MemberInformation memInfo) throws AdminException;
	public void deleteMember(MemberInformation memInfo) throws AdminException;
	public void searchMember(MemberInformation memInfo) throws AdminException;

}
