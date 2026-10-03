package com.example.site_locking.proposal.application.list;

import com.example.site_locking.proposal.domain.OwnerId;
import com.example.site_locking.proposal.domain.Proposal;
import com.example.site_locking.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllStrategy implements Strategy {

    private final ProposalRepository proposalRepository;

    public AllStrategy(ProposalRepository proposalRepository){ this.proposalRepository=proposalRepository; }

    @Override
    public List<Proposal> getProposal(OwnerId ownerId){ return proposalRepository.findAll(); }

    @Override
    public AccessScope getScope(){ return AccessScope.ALL; }

}
