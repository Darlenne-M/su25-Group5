package com.example.Trotter.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Trotter.ProviderProfile.ProviderRepository;
import com.example.Trotter.ProviderProfile.Provider;

@Service
public class CustomProviderDetailsService implements UserDetailsService{
    @Autowired
    private ProviderRepository repo;

    public CustomProviderDetailsService() {
   }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Provider provider = repo.getProviderByEmail(username).orElseThrow(()
            -> new UsernameNotFoundException(username + "not found"));
            ArrayList<SimpleGrantedAuthority> authList = new ArrayList<>();
            authList.add(new SimpleGrantedAuthority(provider.getRole()));
            return new org.springframework.security.core.userdetails.User(
                provider.getEmail(), provider.getPassword(), authList);

    }

    public Long getProviderIdByEmail(String email) {
    return repo.getProviderByEmail(email)
        .map(Provider::getProviderId)
        .orElseThrow(() -> new UsernameNotFoundException(email + " not found"));
}


    
}
