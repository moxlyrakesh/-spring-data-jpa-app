package com.ashokit.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ashokit.entity.ContactsMasterEntity;

public interface ContactsMasterService {

	public ContactsMasterEntity create(ContactsMasterEntity c);
	public Page<ContactsMasterEntity> findAll(Pageable page);
	public String registerAndUpdateContacts(ContactsMasterEntity c);
}
