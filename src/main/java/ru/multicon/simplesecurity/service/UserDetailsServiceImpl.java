package ru.multicon.simplesecurity.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.multicon.simplesecurity.domain.Role;
import ru.multicon.simplesecurity.domain.User;
import ru.multicon.simplesecurity.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User appUser = userRepository.findByName(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        for (Role role : appUser.getRoles()) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                grantList.add(authority);
            }


        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(appUser.getName(),
                appUser.getPassword(), grantList);

        return userDetails;
    }

}
