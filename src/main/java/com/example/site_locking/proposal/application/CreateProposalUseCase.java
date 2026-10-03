package com.example.site_locking.proposal.application;

import com.example.site_locking.proposal.application.input.CreateProposalInput;
import com.example.site_locking.proposal.application.output.ProposalOutput;
import com.example.site_locking.proposal.domain.Owner;
import com.example.site_locking.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProposalUseCase {
    private final ProposalRepository proposalRepository;

    public CreateProposalUseCase(ProposalRepository proposalRepository){
        this.proposalRepository = proposalRepository;
    }

    public ProposalOutput execute(CreateProposalInput input, Owner owner){
        var proposal = input.toDomain(owner);
        var saved = proposalRepository.save(proposal);

        return ProposalOutput.from(saved);
    }
}
