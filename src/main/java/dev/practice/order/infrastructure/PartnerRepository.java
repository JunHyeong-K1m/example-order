package dev.practice.order.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.practice.order.domain.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

	Optional<Partner> findByPartnerToken(String partnerToken);
}
