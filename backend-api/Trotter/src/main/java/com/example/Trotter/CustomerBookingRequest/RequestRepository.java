package com.example.Trotter.CustomerBookingRequest;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface RequestRepository extends JpaRepository<RequestRepository, Long> {
    Object getBookingByCustomerId = null;

    @Query(value = "select * FROM request r WHERE r.customerId = ?1", nativeQuery = true)
    List<Request> getRequestByCustomerId(Long customerId);

    @Query(value = "select * FROM request r WHERE r.serviceId = ?1", nativeQuery = true)
    List<RequestBody> getBookingByServiceId(Long serviceId);

    Object getBookingByCustomerId(Long customerId);

    Object save(Request booking);
}



 