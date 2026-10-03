package com.example.site_locking.proposal.application.input;

import com.example.site_locking.proposal.domain.Owner;
import com.example.site_locking.proposal.domain.Proposal;

import java.util.Optional;

public record CreateProposalInput(String title,
                                  Optional<String> description) {
    public Proposal toDomain(Owner owner){return new Proposal(title,description,owner);
    }
}
