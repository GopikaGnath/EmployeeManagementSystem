package Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		
		
		private int id;

		private String departmentname;
		
		private String departmenthead;
		

		@OneToMany(mappedBy = "department")
		private List<Employee>employee;
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDepartmentname() {
			return departmentname;
		}

		public void setDepartmentname(String departmentname) {
			this.departmentname = departmentname;
		}

		public String getDepartmenthead() {
			return departmenthead;
		}

		public void setDepartmenthead(String departmenthead) {
			this.departmenthead = departmenthead;
		}

		public Department(int id, String departmentname, String departmenthead) {
			super();
			this.id = id;
			this.departmentname = departmentname;
			this.departmenthead = departmenthead;
		}

		public Department() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		

}
