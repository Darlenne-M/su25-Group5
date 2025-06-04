package com.example.Trotter.ProviderBookings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    @Query(value = "select * from bookings b where b.provider_id = ?1", nativeQuery = true)
    List<Booking> getBookingsByProviderId(Long providerId);

    @Query(value = "select * from bookings b where b.service_id = ?1", nativeQuery = true)
    List<Booking> getBookingsByServiceId(Long serviceId);

    
}
