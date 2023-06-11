package dev.practice.order.infrastructure.partner;

import java.util.Objects;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import dev.practice.order.common.exception.InvalidParamException;
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
		if (Strings.isBlank(partner.getPartnerToken())) throw new InvalidParamException("partner.getPartnerToken()");
		if (Strings.isBlank(partner.getPartnerName())) throw new InvalidParamException("partner.getPartnerName()");
		if (Strings.isBlank(partner.getBusinessNo())) throw new InvalidParamException("partner.getBusinessNo()");
		if (Strings.isBlank(partner.getEmail())) throw new InvalidParamException("partner.getEmail()");
		if (Objects.isNull(partner.getStatus())) throw new InvalidParamException("partner.getStatus()");

		return partnerRepository.save(partner);
	}
}
