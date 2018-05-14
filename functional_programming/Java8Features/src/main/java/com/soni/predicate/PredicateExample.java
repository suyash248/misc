package com.soni.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * We can use them anywhere where you need to evaluate a condition on group/collection of similar objects such that evaluation can result 
 * either in true or false e.g.
<p>1) Find all children who were born after a particular date.</p>
<p>2) Pizzas ordered at specific time.</p>
<p>3) Employees greater than certain age and so on.</p>

 * @author suyash
 */
public class PredicateExample {
	public static void main(String[] args){
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");
         
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
                
        System.out.println(Employee.filterEmployees(employees, Employee.isAdultMale()));
         
        System.out.println(Employee.filterEmployees(employees, Employee.isAdultFemale()));
         
        System.out.println(Employee.filterEmployees(employees, Employee.isAgeMoreThan(35)));
         
        //Employees other than above collection of "isAgeMoreThan(35)" can be get using negate()
        System.out.println(Employee.filterEmployees(employees, Employee.isAgeMoreThan(35).negate()));
    }
}

@Getter @Setter @ToString @AllArgsConstructor
class Employee {
	   private Integer id;
	   private Integer age;
	   private String gender;
	   private String firstName;
	   private String lastName;
	   
	   /************************************** Predicates for Employees **************************************/
	   public static Predicate<Employee> isAdultMale() {
		   Predicate<Employee> predicate=  (emp) -> {
			   return ( emp.getGender().equalsIgnoreCase("M") ) && ( emp.getAge()>=18 );
		   };
		   return predicate;
	   }
	   
	   public static Predicate<Employee> isAdultFemale() {
		   Predicate<Employee> predicate=  (emp) -> {
			   return ( emp.getGender().equalsIgnoreCase("F") ) && ( emp.getAge()>=18 );
		   };
		   return predicate;
	   }
	   
	   public static Predicate<Employee> isAgeMoreThan(int age) {
		   Predicate<Employee> predicate=  (emp) -> {
			   return ( emp.getAge()>age );
		   };
		   return predicate;
	   }
	   
	   /***************************************** Generic method to filter Employees *******************************************/
	   public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		   List<Employee> filteredEmployees;
		   filteredEmployees = employees.stream().filter(predicate).collect(Collectors.toList());
		   return filteredEmployees;
	   }
}

