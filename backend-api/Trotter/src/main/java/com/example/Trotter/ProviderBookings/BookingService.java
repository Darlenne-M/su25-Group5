package com.example.Trotter.ProviderBookings;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired; -ser
import org.springframework.stereotype.Service;

import com.example.Trotter.CustomerProfile.Customer;
import com.example.Trotter.CustomerProfile.CustomerRepository;
import com.example.Trotter.ProviderServices.ServiceEntity;
import com.example.Trotter.ProviderServices.ServiceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookingService {
    //@Autowired 
    private final BookingRepository bookingRepository;//*edit-ser
    private final CustomerRepository customerRepository;    //Inject CustomerRepository -*ser
    private final ServiceRepository serviceRepository;      //Inject ServiceRepository -*ser


   // @Autowired
    public BookingService(BookingRepository bookingRepository, 
                            CustomerRepository customerRepository, //-*ser
                            ServiceRepository serviceRepository) {  //*ser 
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    /**
   * Method to get all bookings
   *
   * @return List of all bookings
   */
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

     /**
   * Method to get a booking by ID
   *
   * @param bookingId The ID of the booking to retrieve
   * @return The booking with the specified ID
   */
    public Optional<Booking> getBookingById(Long bookingId){
        return bookingRepository.findById(bookingId);
    }

    /**
   * Method to get bookings by customer ID
   *
   * @param customerId The ID of the customer to search for
   * @return List of bookings for the specified customer
   */
    public Object getBookingsByCustomerId(Long customerId){
        return bookingRepository.getBookingsByCustomerId(customerId);
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
    public Booking addBooking(Booking booking){
        // Before saving, associate the Customer and Service objects based on their IDs

        if (booking.getCustomerId() != null) {
            Customer customer = customerRepository.findById(booking.getCustomerId())    //*ser 
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + booking.getCustomerId()));
            booking.setCustomer(customer);
        } else {
            // Handle case where customerId is missing (e.g., throw error, or handle null customer)

            throw new IllegalArgumentException("Customer ID is required for a new booking.");
        }

        if (booking.getServiceId() != null) {
            ServiceEntity service = serviceRepository.findById(booking.getServiceId())
                .orElseThrow(() -> new EntityNotFoundException("Service not found with ID: " + booking.getServiceId()));
            booking.setService(service);
        } else {
            throw new IllegalArgumentException("Service ID is required for a new booking.");
        }

        return bookingRepository.save(booking);
    }
   
  /**
   * Method to update a booking
   *
   * @param booking The booking to update
   * @return List of all bookings
   */
    public Booking updateBooking(Booking bookingDetails, Long bookingId) {    //*ser 
        return bookingRepository.findById(bookingId).map(existingBooking -> {
            existingBooking.setBookingDate(bookingDetails.getBookingDate()); 

            //Handle customer association update
            if (bookingDetails.getCustomerId() != null) {
                Customer customer = customerRepository.findById(bookingDetails.getCustomerId())
                    .orElseThrow (() ->new EntityNotFoundException("Customer not found with Id: " +bookingDetails.getCustomerId()));
                existingBooking.setCustomer(customer);
            } else if(bookingDetails.getCustomerId() != null) {

            }
            //Handles service association update
            if(bookingDetails.getServiceId() != null) {
                ServiceEntity service =serviceRepository.findById(bookingDetails.getServiceId())
                    .orElseThrow(() -> new EntityNotFoundException("Service not found with Id: " + bookingDetails.getServiceId()));
                existingBooking.setService(service);
            }else if (bookingDetails.getService() != null) {
                //If client sends full service object
            }

            return bookingRepository.save(existingBooking);
        }).orElseThrow(() -> new EntityNotFoundException("Booking not found with Id: " + bookingId));
        
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
