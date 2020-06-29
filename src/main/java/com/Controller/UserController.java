package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.BookEntity;
import com.Entity.UserEntity;
import com.Repository.BookRepository;
import com.Repository.UserRepository;

@RestController
@RequestMapping("/manytomany")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookRepository bookRepository;
	@RequestMapping("/add")
	public List<UserEntity> add(@RequestBody List<UserEntity> userEntity)
	{

		return userRepository.saveAll(userEntity);
	}
	@RequestMapping("/addByBook")
	public List<BookEntity> addByBook(@RequestBody List<BookEntity> bookEntity)
	{
		return bookRepository.saveAll(bookEntity);
	}
	@GetMapping("/getAll")
	public List<UserEntity> getAll()
	{
		return userRepository.findAll();
	}
	@PatchMapping("/getById/{id}")
	public UserEntity getById(@PathVariable Integer id)
	{
		return userRepository.findById(id).orElse(null);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable Integer id)
	{
		userRepository.deleteById(id);
		return new ResponseEntity("deleted",HttpStatus.ACCEPTED);
	}
	@PostMapping("/update")
	public UserEntity update(@RequestBody UserEntity userEntity)
	{
		
		return userRepository.save(userEntity);
	}
	@PostMapping("/updateBook")
	public BookEntity updateBook(@RequestBody BookEntity bookEntity)
	{
		
		return bookRepository.save(bookEntity);
	}
	}
