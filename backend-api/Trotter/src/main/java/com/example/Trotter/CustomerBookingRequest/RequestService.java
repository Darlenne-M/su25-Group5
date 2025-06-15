package com.example.Trotter.CustomerBookingRequest;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RequestService {

     private final RequestRepository requestRepository;

   
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }
   

    /**
     * 
     *Method to get all bookings

     * @return List of all bookings
     */
    public Object getAllBooking() {
        return requestRepository.findAll();
    }

    /**
     * Method to get a booking by Id
     * 
     * @param bookingId  The Id of the booking to get
     * @return The booking linked to the specific Id
     */

     public RequestRepository getRequestById(Long bookingId) {
        return requestRepository.findById(bookingId).orElse(null);
     }

     /**
      * Method to get booking by customer Id
      *
      * @param customerId The Id of the customer to search for
      * @return List of bookings for the specific customer
      */
      public Object getBookingByCustomerId(Long customerId) {
        return requestRepository.getBookingByCustomerId(customerId);
      }

      /**
       * 
       * Method to get a booking by service Id
       * 
       * @param serviceId The Id of a service to search for
     * @param RequestBody 
       * @return List of booking for the specific service
       */
      public List<RequestBody> getBookingByServiceId(Long serviceId, int RequestBody) {
        return requestRepository.getBookingByServiceId(serviceId);
      }

      /**
       * Method to add a booking
       * 
       * @param booking The booking being added
       * @return List of all bookings
       */
        public Object addBooking(Request booking) {
            return requestRepository.save(booking);
        }

        /**
         * 
         * Method to update booking
         * 
         * @param booking The booking being updated
         * @return List of updated  all bookings
         */
        public Object updateBooking(Request booking) {
            return requestRepository.save(booking);
        }

        /**
         * 
         * Method to delete a booking by Id
         * 
         * @param bookingId The Id of the booking to delete
         */
        public void deleteBookingById(Long bookingId) {
            requestRepository.deleteById(bookingId);
        }


        public Request getBookingById(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getBookingById'");
        }


//


}
