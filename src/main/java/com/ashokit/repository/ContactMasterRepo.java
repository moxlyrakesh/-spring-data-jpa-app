package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.ContactsMasterEntity;

@Repository
public interface ContactMasterRepo extends JpaRepository<ContactsMasterEntity, Integer> {

}
