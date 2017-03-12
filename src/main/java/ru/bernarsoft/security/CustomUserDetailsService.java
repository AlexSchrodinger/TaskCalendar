package ru.bernarsoft.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.bernarsoft.common.exceptions.PeopleDAOException;
import ru.bernarsoft.controllers.LoginController;
import ru.bernarsoft.models.DAO.PeopleDAO;
import ru.bernarsoft.models.pojo.People;
import ru.bernarsoft.services.PeopleServiceImpl;
import ru.bernarsoft.services.interfaces.PeopleService;

import java.util.ArrayList;
import java.util.List;

//@Service
//@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);

    private final PeopleService peopleService;

//    @Autowired
    public CustomUserDetailsService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


//    PeopleServiceImpl peopleService = new PeopleServiceImpl(new PeopleDAO());



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            People people = peopleService.getPeopleByLogin(username);
            if(null == people) {
                LOGGER.error("User not found " + username);
                throw new UsernameNotFoundException("User not found " + username);
            } else {
//                String role = "ROLE_" + people.getRole().toUpperCase();

                List<String> userRoles = new ArrayList<>();
                userRoles.add("ROLE_" + people.getRole().toUpperCase());
                return new CustomUserDetails(people,userRoles);

            }

        } catch (PeopleDAOException e) {
           LOGGER.error(e);
        }

        return null;
    }


}