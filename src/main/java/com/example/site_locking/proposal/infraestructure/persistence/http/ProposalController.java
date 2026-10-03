package com.example.site_locking.proposal.infraestructure.persistence.http;

import com.example.site_locking.auth.domain.UserRole;
import com.example.site_locking.auth.infraestructure.persistence.entity.User;
import com.example.site_locking.proposal.application.CreateProposalUseCase;
import com.example.site_locking.proposal.application.ListProposalUseCase;
import com.example.site_locking.proposal.application.list.AccessScope;
import com.example.site_locking.proposal.domain.Owner;
import com.example.site_locking.proposal.domain.OwnerId;
import com.example.site_locking.proposal.infraestructure.persistence.http.request.CreateProposalRequest;
import com.example.site_locking.proposal.infraestructure.persistence.http.response.ProposalResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proposals")
public class ProposalController {
    private final CreateProposalUseCase createProposalUseCase;
    private final ListProposalUseCase listProposalUseCase;

    public ProposalController(CreateProposalUseCase createProposalUseCase,
                              ListProposalUseCase listProposalUseCase){
        this.createProposalUseCase = createProposalUseCase;
        this.listProposalUseCase = listProposalUseCase;
    }
    @PostMapping
    @PreAuthorize("hasRole('INFLUENCER')")
    public ProposalResponse createProposal(@RequestBody CreateProposalRequest request,
                                           @AuthenticationPrincipal User user){
        var owner = new Owner(new OwnerId(user.getId()), user.getUsername());

        var output = this.createProposalUseCase.execute(request.toInput(),owner);

        return ProposalResponse.from(output);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('INFLUENCER','BRAND')")
    public List<ProposalResponse> findAllProposal(@AuthenticationPrincipal User user){
        var accessRole = getAccessScope(user.getRole());
        var ownerId = new OwnerId(user.getId());

        return listProposalUseCase.execute(accessRole,ownerId)
                .stream()
                .map(ProposalResponse::from)
                .toList();
    }

    private static AccessScope getAccessScope(UserRole role){
        return switch (role){
            case ROLE_INFLUENCER -> AccessScope.OWN;
            case ROLE_BRAND -> AccessScope.ALL;
        };
    }
}
