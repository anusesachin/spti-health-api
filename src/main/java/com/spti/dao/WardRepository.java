//package com.spti.dao;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//import com.spti.entity.Branch;
//import com.spti.entity.Ward;
//
//public interface WardRepository extends CrudRepository<Ward, Long> {
//
//	List<Ward> findByBranch( Branch branch );
//
//	@Query( "SELECT w FROM Ward w WHERE w.currentOccupancy < w.maxCapacity AND w.branch = :branch" )
//	List<Ward> findWardsWithCurrentOccupancyLessThanMaxCapacityAndBranch( @Param( "branch" ) Branch branch );
//
//}
