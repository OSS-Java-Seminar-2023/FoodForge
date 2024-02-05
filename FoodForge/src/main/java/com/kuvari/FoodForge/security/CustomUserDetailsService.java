package com.kuvari.FoodForge.security;

import com.kuvari.FoodForge.models.UserEntity;
import com.kuvari.FoodForge.models.enums.Role;
import com.kuvari.FoodForge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userEntity = Optional.ofNullable(userRepository.findByUsername(username));

        if (userEntity.isPresent()) {
            UserEntity user = userEntity.get();
            System.out.println("success!");
            return new User(user.getUsername(),
                    user.getPasswd(),
                    mapRoleToGrantedAuthority(user.getRole()));
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

    }

    private Collection<GrantedAuthority> mapRoleToGrantedAuthority(Role role) {
        var myRole = new ArrayList<Role>();
        myRole.add(role);
        return myRole.stream().map(elem -> new SimpleGrantedAuthority(elem.name())).collect(Collectors.toList());
    }
}
