package com.example.site_locking.proposal.application.output;

import com.example.site_locking.proposal.domain.Proposal;

import java.util.Optional;

public record ProposalOutput(String id,
                             String title,
                             Optional<String> description,
                             String ownerId,
                             String OwnerName) {
    public static ProposalOutput from (Proposal proposal){
        return new ProposalOutput(
                proposal.getId().id().toString(),
                proposal.getTitle(),
                proposal.getDescription(),
                proposal.getOwner().id().toString(),
                proposal.getOwner().name()
        );
    }

}
