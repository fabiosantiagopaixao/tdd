package com.fabio.tdd;

import com.fabio.tdd.model.BookingModel;
import com.fabio.tdd.repository.BookingRepository;
import com.fabio.tdd.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

/**
 * 1: Testes que falham
 * 2: Corrige para que eles passem
 * 3: Refactor para remover a redundâncias
 */

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    /**
     * Deixa disponivel o bean do BookingService
     */
    @TestConfiguration
    static class BookingServiceTestConfiguration {
        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDaysCalculator() {
        String name = "Michelli";
        int days = bookingService.daysCalculatorWithDatabase(name);
        Assertions.assertEquals(days, 10);
    }

    /**
     * Executa antes de qualquer coisa.
     * Prepara o repository por exemplo para ter os dados necessários pelo service
     */
    @Before
    public void setup() {
        LocalDate checkIn = LocalDate.parse("2020-11-10");
        LocalDate checkOut = LocalDate.parse("2020-11-20");
        BookingModel bookingModel = new BookingModel("1", "Michelli", checkIn, checkOut, 2);

        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserName()))
                .thenReturn(Optional.of(bookingModel));
    }


}
