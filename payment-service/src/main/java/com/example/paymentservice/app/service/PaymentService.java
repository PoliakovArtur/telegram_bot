package com.example.paymentservice.app.service;

import com.example.paymentservice.app.enums.PaymentStatus;
import com.example.paymentservice.web.dto.PaymentDto;
import com.example.paymentservice.app.service.mapper.PaymentMapper;
import com.example.paymentservice.persistence.model.Payment;
import com.example.paymentservice.persistence.repository.PaymentRepository;
import com.example.paymentservice.web.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private static final Random rand = new Random();

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment findById(Long id) throws SQLException {
        return paymentRepository.findById(id).orElseThrow(SQLException::new);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public void deleteById(Long uuid) {
        paymentRepository.deleteById(uuid);
    }

    public Payment save(PaymentDto paymentDto) {
        Payment payment = PaymentMapper.INSTANCE.toEntity(paymentDto);
        payment.setPaymentDate(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    public ResponseDto checkPayment(Long orderId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(orderId);

        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();

            return new ResponseDto(
                    PaymentStatus.PAID,
                    payment.getOrderId(),
                    payment.getPaymentDate().toString(),
                    payment.getPaymentAmount()
            );
        } else
            return new ResponseDto(PaymentStatus.NOT_PAID, orderId);
    }

    public ResponseDto doPayment(PaymentDto paymentDto) {
        PaymentStatus status = processPayment();
        Payment payment = save(paymentDto);

        return new ResponseDto(
                    status,
                    payment.getOrderId(),
                    LocalDateTime.now().toString(),
                    payment.getPaymentAmount()
            );
    }

    private PaymentStatus processPayment() {
        PaymentStatus[] statuses = PaymentStatus.values();

        return statuses[rand.nextInt(statuses.length)];
    }

    public boolean checkDate(PaymentDto paymentDto) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        var dateString = "01/" + paymentDto.getDateCard();
        var date = format.parse(dateString);

        return (date.after(new Date()));
    }
}
