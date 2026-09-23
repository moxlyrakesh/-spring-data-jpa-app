package com.ashokit.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.ContactsMasterEntity;
import com.ashokit.service.ContactsMasterService;

@RestController
@RequestMapping("api/contacts")
public class ContactMasterController {

	private  ContactsMasterService contactService;
	
	public ContactMasterController(ContactsMasterService contactService) {
		this.contactService=contactService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<ContactsMasterEntity> create(@RequestBody ContactsMasterEntity c){
		ContactsMasterEntity contact=contactService.create(c);
		return ResponseEntity.status(HttpStatus.CREATED).body(contact);
		
	}
	
	@GetMapping("/list")
	public Page<ContactsMasterEntity> getAllContacts(@RequestParam(required=false,defaultValue="1") int pageNo,
			                                          @RequestParam(required=false,defaultValue="5") int pageSize,
			                                          @RequestParam String sortBy, 
			                                          @RequestParam String sortDir){
		
		Sort sort=null;
		if(sortDir.equalsIgnoreCase("ASC")) {
			sort=Sort.by(sortBy).ascending();
		}else {
			sort=Sort.by(sortBy).descending();
		}
		
		Pageable page=PageRequest.of(pageNo-1, pageSize,sort);
		
		return contactService.findAll(page);
		
	}
	
	@PutMapping("/update")
	public  ResponseEntity<String> update(@RequestBody ContactsMasterEntity c) {
		String msg=contactService.registerAndUpdateContacts(c);
      return new ResponseEntity<>(msg,HttpStatus.OK);	
	}
	
	@GetMapping("/name")
	public String getMsg(){
		return "Welcome to the spring boot";
	}
}
