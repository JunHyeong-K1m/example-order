package dev.practice.order.infrastructure.partner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.practice.order.domain.partner.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

	Optional<Partner> findByPartnerToken(String partnerToken);
}
