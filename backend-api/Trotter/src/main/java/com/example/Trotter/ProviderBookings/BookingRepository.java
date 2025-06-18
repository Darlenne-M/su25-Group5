package com.example.Trotter.ProviderBookings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import com.example.Trotter.ProviderBookings.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    @Query(value = "select * from bookings b where b.customer_id = ?1", nativeQuery = true)
    List<Booking> getBookingsByCustomerId(Long customerId);

    @Query(value = "select * from bookings b where b.service_id = ?1", nativeQuery = true)
    List<Booking> getBookingsByServiceId(Long serviceId);
}
