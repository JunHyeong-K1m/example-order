package dev.practice.order.infrastructure.partner;

import java.security.InvalidParameterException;
import java.util.Objects;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {

	private final PartnerRepository partnerRepository;

	@Override
	public Partner store(Partner partner) {
		if (Strings.isBlank(partner.getPartnerToken())) throw new InvalidParameterException("partner.getPartnerToken()");
		if (Strings.isBlank(partner.getPartnerName())) throw new InvalidParameterException("partner.getPartnerName()");
		if (Strings.isBlank(partner.getBusinessNo())) throw new InvalidParameterException("partner.getBusinessNo()");
		if (Strings.isBlank(partner.getEmail())) throw new InvalidParameterException("partner.getEmail()");
		if (Objects.isNull(partner.getStatus())) throw new InvalidParameterException("partner.getStatus()");

		return partnerRepository.save(partner);
	}
}
