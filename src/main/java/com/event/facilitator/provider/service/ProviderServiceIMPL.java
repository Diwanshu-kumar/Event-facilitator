package com.event.facilitator.provider.service;

import com.event.facilitator.provider.Dto.LoginDTO;
import com.event.facilitator.provider.Dto.LoginResponseDTO;
import com.event.facilitator.provider.Dto.ProviderDTO;
import com.event.facilitator.provider.Repo.ProviderRepo;
import com.event.facilitator.provider.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceIMPL implements ProviderService {

    @Autowired
    private ProviderRepo providerRepo;
    @Override
    public int addProvider(ProviderDTO providerDTO) {
        Provider provider = new Provider(
                providerDTO.getProviderId(),
                providerDTO.getFullName(),
                providerDTO.getEmail(),
                providerDTO.getMobileNumber(),
                providerDTO.getGender(),
                providerDTO.getPassword()
        );
        if(providerRepo.findByEmail(providerDTO.getEmail()) !=null)return -1;
        providerRepo.save(provider);
        return provider.getProviderId();
    }

    @Override
    public LoginResponseDTO login(LoginDTO loginDTO) {
        Provider provider = providerRepo.findByEmail(loginDTO.getUsername());
        if(provider!=null && provider.getPassword().equals(loginDTO.getPassword())){
            return new LoginResponseDTO(provider.getProviderId(),provider.getProviderName());
        }
        return new LoginResponseDTO();
    }
}
