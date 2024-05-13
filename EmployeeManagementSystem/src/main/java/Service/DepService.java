package Service;

import java.util.List;

import Entity.Department;

public interface DepService {
	public Department saveDep(Department dep);
	public List<Department> getAllDep();

	public Department getDepById(int id);

	public boolean deleteDep(int id);
	
	

}
