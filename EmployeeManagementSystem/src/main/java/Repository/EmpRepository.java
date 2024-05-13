package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
