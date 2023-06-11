package dev.practice.order.infrastructure;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Component;

import dev.practice.order.domain.Partner;
import dev.practice.order.domain.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReadImpl implements PartnerReader {

	private final PartnerRepository partnerRepository;

	@Override
	public Partner getPartner(String partnerToken) {
		return partnerRepository.findByPartnerToken(partnerToken)
			.orElseThrow(EntityNotFoundException::new);
	}
}
