package com.example.Trotter.ProviderBookings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;


    /**
   * Method to get all bookings
   *
   * @return List of all bookings
   */
    public Object getAllBookings(){
        return bookingRepository.findAll();
    }

     /**
   * Method to get a booking by ID
   *
   * @param bookingId The ID of the booking to retrieve
   * @return The booking with the specified ID
   */
    public Booking getBookingById(Long bookingId){
        return bookingRepository.findById(bookingId).orElse(null);
    }

    /**
   * Method to get bookings by customer ID
   *
   * @param customerId The ID of the customer to search for
   * @return List of bookings for the specified customer
   */
    public Object getBookingsByProviderId(Long providerId){
        return bookingRepository.getBookingsByProviderId(providerId);
    }

     /**
   * Method to get bookings by service ID
   *
   * @param serviceId The ID of the service to search for
   * @return List of bookings for the specified service
   */
    public List<Booking> getBookingsByServiceId(Long serviceId){
        return bookingRepository.getBookingsByServiceId(serviceId);
    }

    /**
   * Method to add a new booking
   *
   * @param booking The booking to add
   * @return List of all bookings
   */
    public Object addBooking(Booking booking){
        return bookingRepository.save(booking);
    }

        
  /**
   * Method to update a booking
   *
   * @param booking The booking to update
   * @return List of all bookings
   */
    public Object updateBooking(Booking booking){
        return bookingRepository.save(booking);
    }

/**
   * Method to delete a booking by ID
   *
   * @param bookingId The ID of the booking to delete
   */
  public void deleteBookingById(Long bookingId){
    bookingRepository.deleteById(bookingId);
  }


}
