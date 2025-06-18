package com.example.Trotter.ProviderBookings;

import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    
    //@Autowired
    private final BookingService bookingService;//*edit-ser 

    //@Autowired
    public BookingController(BookingService bookingService) {
      this.bookingService = bookingService;
    }

    /**
   * Endpoint to get all bookings
   *
   * @return List of all bookings
   */
    @GetMapping("/bookings")
    public Object getAllBookings(){
        return bookingService.getAllBookings();
    }

    /**
   * Endpoint to get a booking by ID
   *
   * @param id The ID of the booking to retrieve
   * @return The booking with the specified ID
   */
    @GetMapping("/bookings/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long BookingId){
        return bookingService.getBookingById(BookingId);
    }

    /**
   * Endpoint to get all bookings for a specific provider
   *
   * @param providerId The ID of the provider to search for
   * @return List of bookings for the specified provider
   */
    @GetMapping("/bookings/customer/{customerId}")
    public Object getBookingsByCustomerId(@PathVariable Long customerId){
        return bookingService.getBookingsByCustomerId(customerId);
    }

      /**
   * Endpoint to get all bookings for a specific service
   *
   * @param serviceId The ID of the service to search for
   * @return List of bookings for the specified service
   */
    @GetMapping("/bookings/service/{serviceId}")
    public Object getBookingsByServiceId(@PathVariable Long serviceId){
        return bookingService.getBookingsByServiceId(serviceId);
    }

     /**
   * Endpoint to add a new booking
   *
   * @param booking The booking to add
   * @return List of all bookings
   */
  @PostMapping("/bookings")
  public Object addBooking(@RequestBody Booking booking){
    return bookingService.addBooking(booking);
  }

  /**
   * Endpoint to delete a booking by ID
   *
   * @param id The ID of the booking to delete
   */
  @DeleteMapping("/bookings/{id}")
  public void deleteBooking(@PathVariable Long id, @RequestBody Booking booking){
    bookingService.deleteBookingById(id);
  }

   /**
   * Endpoint to update a booking
   *
   * @param id           The ID of the booking to update
   * @param registration The updated booking information
   * @return The updated booking
   */
    @PutMapping("/bookings/{id}")
    public Object updateBooking(@PathVariable Long id, @RequestBody Booking booking){
        booking.setBookingId(id);// Ensure the ID is set for the update
        return bookingService.updateBooking(booking, id);
    }



}
