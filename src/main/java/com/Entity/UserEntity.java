package com.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId",unique=true,nullable=false)
	private Integer id;
	
	@Column(name="name",nullable = false)
	private String name;
	@Column(name="email",unique=true)
	private String email;
	@Column(name="password",nullable = false)
	private String password;
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE })
	@JoinTable(name = "user_book", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "bookId") })
    private Set<BookEntity> books = new HashSet<BookEntity>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<BookEntity> getBooks() {
		return books;
	}
	public void setBooks(Set<BookEntity> books) {
		this.books = books;
	}

}
