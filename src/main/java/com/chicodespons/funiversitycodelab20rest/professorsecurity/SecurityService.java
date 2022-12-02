package com.chicodespons.funiversitycodelab20rest.professorsecurity;

import com.chicodespons.funiversitycodelab20rest.domain.ProfessorRepository;
import com.chicodespons.funiversitycodelab20rest.exceptions.UnauthorizedException;
import com.chicodespons.funiversitycodelab20rest.professorsecurity.exception.UnknownUserException;
import com.chicodespons.funiversitycodelab20rest.professorsecurity.exception.WrongPasswordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class SecurityService {

    private final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    private final ProfessorRepository professorRepository;
    private final UserRepository userRepository;

    public SecurityService(ProfessorRepository professorRepository, UserRepository userRepository) {
        this.professorRepository = professorRepository;
        this.userRepository = userRepository;
    }

    public void validateAuthorization(String authorization, Feature feature) {
            UsernamePassword usernamePassword = getUsernamePassword(authorization);
            User user = userRepository.getUser(usernamePassword.getUsername());
            if(user == null) {
                logger.error("Unknown user" + usernamePassword.getUsername());
                throw new UnknownUserException();
            }

            if(!user.getPassword().equals(usernamePassword.getPassword())) {
                logger.error("Password does not match for user " + usernamePassword.getUsername());
                throw new WrongPasswordException();
            }

            if(!user.getRole().containsFeature(feature)) {
                logger.error("User " + usernamePassword.getUsername() + " does not have access to " + feature);
                throw new UnauthorizedException();
            }

    }

    private UsernamePassword getUsernamePassword(String authorization) {

        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":")+1 );
        return new UsernamePassword(username, password);
    }
}
