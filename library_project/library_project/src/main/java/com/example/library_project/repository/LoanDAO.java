package com.example.library_project.repository;

import com.example.library_project.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDAO extends JpaRepository<Loan, Long> {
}
