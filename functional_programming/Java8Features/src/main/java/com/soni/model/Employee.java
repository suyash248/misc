package com.soni.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Employee implements Comparable<Employee> {
	private String name;
	private int age;
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		} 
		if(!(obj instanceof Employee)) {
			return false;
		} else {
			Employee e1 = (Employee) obj;
			if(e1.getName().equalsIgnoreCase(this.getName()) && e1.getAge()==this.getAge()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
	    int hash = 1;
	    hash = hash * 17 + this.name.hashCode();
	    hash = hash * 31 + this.age;
	    return hash;
	}

	@Override
	public int compareTo(Employee o) {
		if(this.name.equals(o.name)) {
			return Integer.valueOf(this.age).compareTo(o.age);
		}
		return this.name.compareTo(o.name);
	}
}
