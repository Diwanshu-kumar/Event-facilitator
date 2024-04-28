package com.event.facilitator.provider.service;

import com.event.facilitator.provider.Dto.LoginDTO;
import com.event.facilitator.provider.Dto.ProviderDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProviderService {

    int addProvider(ProviderDTO providerDTO);
    String login(LoginDTO providerDTO);
}
