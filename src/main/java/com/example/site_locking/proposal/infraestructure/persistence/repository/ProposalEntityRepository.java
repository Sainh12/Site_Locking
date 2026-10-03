package com.example.site_locking.proposal.infraestructure.persistence.repository;

import com.example.site_locking.proposal.domain.ProposalRepository;
import com.example.site_locking.proposal.infraestructure.persistence.entity.ProposalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ProposalEntityRepository extends CrudRepository<ProposalEntity, UUID> {
    List<ProposalEntity> findAllByOwnerId(UUID ownerId);
}
