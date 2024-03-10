package com.inno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpRepo extends JpaRepository<Emp, String>,JpaSpecificationExecutor<Emp>{
	@Query(value = "select designation as desig , count(*) as count from emp group by designation",nativeQuery = true)
	public List<GroupingInfo> getGroupInfo();
	
	@Query(value = "select e.name as name,e.designation as designation,d.deptname as deptname from emp e , department d where e.dept = d.id",nativeQuery = true)
	public List<JoinData> getFromJoinTable();
	
	@Query(value = "select deptname ,sum(salary) as totalsalary,count(*) as totalemp from emp e, department d where e.dept =  d.id group by deptname",nativeQuery = true)
	public List<Report> getReport();
	
	@Query("SELECT new com.inno.Data(e.id,e.name) FROM Emp e")
	public List<Data> getData();
	
}
