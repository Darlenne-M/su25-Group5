package com.example.Trotter.CustomerProfile;

import java.util.List;

import com.example.Trotter.CustomerViewServices.ServiceEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
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

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer")
    // Using for JsonIgnoreProperties to avoid circular references during serialization
    @JsonIgnoreProperties("customer")
    private List<ServiceEntity> services;

    public Customer() {
    }

    public Customer(Long customerId, String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String password) {
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

    }

    public Customer(String firstName, String lastName, String address, String city, String zip, String state, String phone, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.password = password;

    }

    public Customer(Long customerId, String firstName, String lastName, String address, String city, String zip, String state, String phone, String email, String password, List<ServiceEntity> services) {
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
        this.services = services;

    }

    public Customer(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String password, List<ServiceEntity>services) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this. zip = zip;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.services = services;

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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

    public void setAdrress(String address) {
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

    public List<ServiceEntity> getServices() {
        return services;
    }

    public void setServices (List<ServiceEntity> services) {
        this.services = services;
    }

}

