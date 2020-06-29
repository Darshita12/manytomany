package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
