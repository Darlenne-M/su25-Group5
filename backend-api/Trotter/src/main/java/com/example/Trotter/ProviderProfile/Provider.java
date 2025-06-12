package com.example.Trotter.ProviderProfile;
import com.example.Trotter.ProviderServices.ServiceEntity;
import java.util.List;

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
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

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

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("provider")
    private List<ServiceEntity> services;
    
    private String profilePicturePath;

    public Provider(){

    }

    public Provider(Long providerId, String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String password,  String profilePicturePath ){
        this.providerId = providerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.profilePicturePath = profilePicturePath;
    }

     public Provider(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String password, String profilePicturePath){
         this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.password = password;
         this.profilePicturePath = profilePicturePath;
    }

      public Provider(Long providerId, String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String password, List<ServiceEntity> services, String profilePicturePath ){
        this.providerId = providerId;
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
         this.profilePicturePath = profilePicturePath;
    }

     public Provider(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String password, List<ServiceEntity> services, String profilePicturePath ){
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
         this.profilePicturePath = profilePicturePath;
    }

    public Long getProviderId(){
        return providerId;
    }

     public void setProviderId(Long providerId){
        this.providerId = providerId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
   
    public String getCity(){
        return city;
    }   

    public void setCity(String city){
        this.city = city;
    }
      
    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }
       
    public String getZip(){
        return zip;
    }

    public void setZip(String zip){
        this.zip = zip;
    }
  
    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
       
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
      
    public List<ServiceEntity> getServices(){
        return services;
    }

    public void setServices(List<ServiceEntity> services){
        this.services = services;

    }
    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

       
}
