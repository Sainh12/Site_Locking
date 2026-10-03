package com.example.site_locking.proposal.application.list;

import com.example.site_locking.proposal.domain.OwnerId;
import com.example.site_locking.proposal.domain.Proposal;

import java.util.List;

public interface Strategy {
    List<Proposal> getProposal(OwnerId ownerId);

    AccessScope getScope();
}
