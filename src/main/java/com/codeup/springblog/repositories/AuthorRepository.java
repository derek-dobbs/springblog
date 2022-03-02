package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
