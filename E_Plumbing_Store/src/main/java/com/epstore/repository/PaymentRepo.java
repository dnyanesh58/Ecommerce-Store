package com.epstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epstore.entities.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>
{

}
