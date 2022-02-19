package com.fabio.tdd.service;

import com.fabio.tdd.model.BookingModel;
import com.fabio.tdd.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public int daysCalculatorWithDatabase(String name) {
        Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);

        return Period.between(
                bookingModelOptional.isPresent().get().getCheckIn(),
                bookingModelOptional.isPresent().get().getCheckOut()
        ).getDays();
    }
}
