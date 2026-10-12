package com.example.site_locking.proposal.application;

import com.example.site_locking.proposal.application.list.AccessScope;
import com.example.site_locking.proposal.application.list.Factory;
import com.example.site_locking.proposal.application.output.ProposalOutput;
import com.example.site_locking.proposal.domain.OwnerId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProposalUseCase {
    private final Factory factory;

    public ListProposalUseCase(Factory factory){
        this.factory = factory;
    }

    public List<ProposalOutput> execute(AccessScope scope, OwnerId id){
        var proposals = factory.getStrategy(scope).getProposal(id);

        return proposals.stream().map(ProposalOutput::from).toList();
    }
}
