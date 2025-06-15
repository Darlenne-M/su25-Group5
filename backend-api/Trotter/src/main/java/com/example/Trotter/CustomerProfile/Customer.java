package com.example.Trotter.CustomerProfile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.Trotter.CustomerViewServices.ViewServices;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("customer") //Circular reference handling
    private Set<ViewServices> viewedServices = new HashSet<>();
   
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

    public Customer(Long customerId, String firstName, String lastName, String address, String city, String zip, String state, String phone, String email, String password,List<ViewServices> services) {
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
           if(services != null) {
            this.viewedServices = new HashSet<>(services);
            for (ViewServices service: this.viewedServices) {
                service.setCustomer(this);
            }
        }else {
            this.viewedServices = new HashSet<>();
        }
    
    }

    public Customer(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String password, List<ViewServices>services) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this. zip = zip;
        this.phone = phone;
        this.email = email;
        this.password = password;
         if(services != null) {
            this.viewedServices = new HashSet<>(services);
            for (ViewServices service: this.viewedServices) {
                service.setCustomer(this);
            }
        }else {
            this.viewedServices = new HashSet<>();
        }

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

    public Set<ViewServices> getViewedServices() {
        return viewedServices;
    }

    //public void setViewedServices (Set<ViewServices> viewedServices) {
    //    this.viewedServices = viewedServices;
   // }

     // Helper method to add a single ViewService to the collection and maintain bidirectional relationship
    public void addViewedService(ViewServices service) {
        this.viewedServices.add(service);
        service.setCustomer(this); // Important: set the customer on the ViewServices side
    }

    // Helper method to remove a single ViewService from the collection
    public void removeViewedService(ViewServices service) {
        this.viewedServices.remove(service);
        service.setCustomer(null); // Important: remove the customer from the ViewServices side
    }

}

