package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ashokit.entity.ContactsMasterEntity;
import com.ashokit.repository.ContactMasterRepo;

@Service
public class ContactsMasterServiceImpl implements ContactsMasterService {

	private ContactMasterRepo contactRepo;
	public ContactsMasterServiceImpl(ContactMasterRepo contactRepo) {
		this.contactRepo=contactRepo;
	}
	
	@Override
	public ContactsMasterEntity create(ContactsMasterEntity c) {
		return contactRepo.save(c);
	}

	@Override
	public Page<ContactsMasterEntity> findAll(Pageable page) {
		return contactRepo.findAll(page);
	}

	@Override
	public String registerAndUpdateContacts(ContactsMasterEntity c) {
		Optional<ContactsMasterEntity> opt=contactRepo.findById(c.getContactId());
		if(opt.isPresent()) {
			contactRepo.save(c);
			return c.getContactId()+" Doctor details are found and updated.";
		}else {
			return "Doctor is saved with id value "+contactRepo.save(c).getContactId();
		}
		
	}

}
