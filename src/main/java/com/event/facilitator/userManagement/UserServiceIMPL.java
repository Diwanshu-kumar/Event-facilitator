package com.event.facilitator.userManagement;

import com.event.facilitator.provider.Dto.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService{
    private final UserRepository userRepository;
    public UserServiceIMPL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public int addUser(User user) {
        if(userRepository.findByEmail(user.getEmail())!=null)return -1;
        userRepository.save(user);
        return user.getUserId();
    }

    @Override
    public String login(LoginDTO loginDTO) {
        User user =userRepository.findByEmail(loginDTO.getUsername());
        if(user!=null && user.getPassword().equals(loginDTO.getPassword())){
            return user.getUserId()+" : "+user.getFullName();
        }
        return null;
    }
}
