package io.saikiran.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.saikiran.api.entity.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {

}
