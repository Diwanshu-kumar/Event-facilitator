package com.event.facilitator.provider.Repo;

import com.event.facilitator.provider.Dto.ProviderDTO;
import com.event.facilitator.provider.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ProviderRepo extends JpaRepository<Provider, Long> {
    public Provider findByEmail(String email);
}
