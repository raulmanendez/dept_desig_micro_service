package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Designation;

@Repository
public interface DesignationRepository extends CrudRepository<Designation, Long>{
	List<Designation> findByDeptId(Long deptId);
}
