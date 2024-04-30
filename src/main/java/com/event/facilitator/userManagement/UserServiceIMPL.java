package com.event.facilitator.userManagement;

import com.event.facilitator.provider.Dto.LoginDTO;
import com.event.facilitator.provider.Dto.LoginResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService{
    private final UserRepository userRepository;
    public UserServiceIMPL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public ResponseEntity<String > addUser(User user) {
        if(userRepository.findByEmail(user.getEmail())!=null)return ResponseEntity.ok("Duplicate Email");
        userRepository.save(user);
        return ResponseEntity.ok("User added successfully");
    }

    @Override
    public LoginResponseDTO login(LoginDTO loginDTO) {
        User user =userRepository.findByEmail(loginDTO.getUsername());
        if(user!=null && user.getPassword().equals(loginDTO.getPassword())){
            return new LoginResponseDTO(user.getUserId(),user.getFullName());
        }
        return new LoginResponseDTO();
    }
}
