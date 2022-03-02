package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
