package com.example.Trotter.CustomerBookingRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResquestController {

    @Autowired
    private RequestService bookingService;

    /**
     * Endpoint to get all bookings
     * 
     * @return List of all bookings
     */
    @GetMapping("bookings")
    public Object getAllBookings() {
        return bookingService.getAllBooking();
    }

    /**
     * Endpoint to get a booking by ID======================
     * 
     * @param id The ID of the booking to retrieve
     * @return The booking with the specified ID
     */
    @GetMapping("/booking/{id}")
    public Request getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    /**
     * Endpoing to get all bookings for a specifiec customer
     * 
     * @param customerId The ID of the customer to search for 
     * @return List of bookings for the specified customer
     */
    @GetMapping("/bookings/customer/{customerId}")
    public Object getBookingsByCustomerId(@PathVariable Long customerId) {
        return bookingService.getBookingById(customerId);
    }

    /**
     * Endpoint to get all bookins for a specific service
     * 
     * @param serviceId The ID of the service to serach for 
     * @return List of bookings for the specified service
     */
    @GetMapping("/booking/service/{serviceId}")
    public Object getBookingByServiceId(@PathVariable Long serviceId) {
        return bookingService.getBookingByServiceId(serviceId, 0);
    }

    /**
     * Endpoint to add a new booking=======================
     * 
     * @param booking The booking to add
     * @return List of all bookings
     */
    @PostMapping("/bookings")
    public Object addBooking(@RequestBody Request bookingRequest) {
        return bookingService.addBooking(bookingRequest);
    }

    /**
     * Endpoint to delete a booking by ID
     * 
     * @param id The ID of the booking to delete
     */
    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBookingById(id);
    }

    /**
     * Endpoint to update booking============================
     * 
     * @param id The ID of the booking to update
     * @return The updated booking
     */
    @PutMapping("/bookings/{id}")
    public Object updateBooking(@PathVariable Long id, @RequestBody Request booking) {
        booking.setBookingId(id);
        return bookingService.updateBooking(booking);
    }

}


