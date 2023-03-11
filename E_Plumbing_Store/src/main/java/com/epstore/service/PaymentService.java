package com.epstore.service;

import com.epstore.entities.Payment;

public interface PaymentService
{
	Payment savePayment(Payment newPayment);

	Payment findPaymentById(Long paymentId);
}
