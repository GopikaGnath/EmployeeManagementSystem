package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Department;

public interface DepRepository extends JpaRepository<Department, Integer>{

}
