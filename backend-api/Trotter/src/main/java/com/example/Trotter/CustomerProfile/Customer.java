package com.example.Trotter.CustomerProfile;

import java.util.ArrayList;
import java.util.List;
import com.example.Trotter.ProviderBookings.Booking;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  //Fixes no serializer found for class error
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;

    private String address;
    private String city;
    private String state;
    private String zip;

    private String profilePicture;
    private String role;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Booking> booking = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  //Fixes no serializer found for class error
   
    public Customer() {

    }


    public Customer(Long customerId, String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String password,String profilePicture, String role, List<Booking> bookings) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email =email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.role = role;
        this.booking = (bookings != null) ? bookings: new ArrayList<>();
    }

    public Customer(String firstName, String lastName, String address, String city, String zip, String state, String phone, String email, String password, String profilePicture, String role, List<Booking> bookings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.role = role;
        this.booking = (bookings != null) ? bookings: new ArrayList<>();
    }

    public Customer(Long customerId, String firstName, String lastName, String address, String city, String zip, String state, String phone, String email, String password, List<Booking> booking, String profilePicture, String role, List<Booking> bookings) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.booking = booking;
        this.profilePicture = profilePicture;
        this.role = role;
        this.booking = (bookings != null) ? bookings: new ArrayList<>();
    
    }

    public Customer(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String password, List<Booking> booking, String profilePicture, String role, List<Booking> bookings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this. zip = zip;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.booking = booking;
        this.profilePicture = profilePicture;
        this.role = role;
        this.booking = (bookings != null) ? bookings: new ArrayList<>();
    }

    public Long getId() {
        return customerId;
    }

    public void setId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone  = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordString() {
        
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Booking> getBookings() {
        return booking;
    }
   
    public void setBooking(List<Booking> bookings) {
        this.booking.clear();
        if(booking != null) {        //For collection setters, especially in JPA entities,
                                     // it's generally better to clear and add, rather than reassigning the reference
                                     // if you want JPA to track changes correctly for managed entities.
        this.booking.addAll(bookings);
        }

    }

    public void setRole(String role) {
        this.role = role;
    }    

    public String getRole() {
        return role;
    }

    public String getprofilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    
   // public void removeViewedService(ViewServices service) {
   //     this.viewedServices.remove(service);
       // service.setCustomer(null); // Important: remove the customer from the ViewServices side
   // }

}

