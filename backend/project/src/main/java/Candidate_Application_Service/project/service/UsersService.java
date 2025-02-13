package Candidate_Application_Service.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Candidate_Application_Service.project.models.Users;
import Candidate_Application_Service.project.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users login(String username, String password) {
        Optional<Users> optionalUser = usersRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();

            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

}
