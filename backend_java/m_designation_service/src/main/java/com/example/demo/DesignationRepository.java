package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends CrudRepository<Designation, Long>{
	List<Designation> findByDeptId(Long deptId);
}
