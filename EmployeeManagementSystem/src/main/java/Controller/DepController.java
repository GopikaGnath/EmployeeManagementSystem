package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Entity.Department;
import Service.DepService;
import jakarta.servlet.http.HttpSession;

@Controller
public class DepController {
	@Autowired
	private DepService depService;

	@GetMapping("/loadDepList")
	public String index(Model m) {
		List<Department> list = depService.getAllDep();
		m.addAttribute("depList", list);
		return "index1";
	}
	@GetMapping("/loadDepSave")
	public String loadDepSave() {
		return "dep_save";
	
	}
	@GetMapping("/EditDep/{id}")
	public String EditEmp(@PathVariable int id, Model m) {
		// System.out.println(id);
		Department dep = depService.getDepById(id);
		m.addAttribute("dep", dep);
		return "edit_dep";
	}
	@PostMapping("/saveDep")
	public String saveEmp(@ModelAttribute Department dep, HttpSession session) {
		// System.out.println(dep);

		Department newDep = depService.saveDep(dep);

		if (newDep != null) {
			// System.out.println("save success");
			session.setAttribute("msg", "Register sucessfully");
		} else {
			// System.out.println("something wrong on server");
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/loadDepSave";
	}
	@PostMapping("/updateDepDtls")
	public String updateDep(@ModelAttribute Department dep, HttpSession session) {
		// System.out.println(dep);

		Department updateDep = depService.saveDep(dep);

		if (updateDep != null) {
			// System.out.println("save success");
			session.setAttribute("msg", "Update sucessfully");
		} else {
			// System.out.println("something wrong on server");
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/loadDepList";
	}
	@GetMapping("/deleteDep/{id}")
	public String loadEmpSave(@PathVariable int id, HttpSession session) {
		boolean f = depService.deleteDep(id);
		if (f) {
			session.setAttribute("msg", "Delete sucessfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		}
		return "redirect:/loadDepList";
	}
}
