package com.fastdemo.demo.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class UserModel {
	@Id
	@SequenceGenerator(
					name = "users_sequence",
					sequenceName = "users_sequence",
					allocationSize = 1
	)
	@GeneratedValue(
					strategy = GenerationType.SEQUENCE,
					generator = "users_sequence"
	)
	private Integer id;

	@Column(nullable = false, length = 20)
	private String firstName;

	@Column(nullable = false, length = 20)
	private String lastName;

	public UserModel(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserModel() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserModel userModel = (UserModel) o;
		return Objects.equals(id, userModel.id) && Objects.equals(firstName, userModel.firstName) && Objects.equals(lastName, userModel.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName);
	}

	@Override
	public String toString() {
		return "UserModel{" +
						"id=" + id +
						", firstName='" + firstName + '\'' +
						", lastName='" + lastName + '\'' +
						'}';
	}
}
