package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import Entity.Department;
import Repository.DepRepository;
import jakarta.servlet.http.HttpSession;

public class DepServiceImpl   implements DepService {
	@Autowired
	private DepRepository depRepo;


	@Override
	public Department saveDep(Department dep) {
		// TODO Auto-generated method stub
		Department newDep = depRepo.save(dep);
		return newDep;
	}

	@Override
	public List<Department> getAllDep() {
		// TODO Auto-generated method stub
		return depRepo.findAll();
	}

	@Override
	public Department getDepById(int id) {
		// TODO Auto-generated method stub
		return depRepo.findById(id).get();
	}

	@Override
	public boolean deleteDep(int id) {
		// TODO Auto-generated method stub
		Department dep = depRepo.findById(id).get();
		if (dep != null) {
			depRepo.delete(dep);
			return true;
		}
		return false;
	}
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");

	}

	}


