package dev.practice.order.interfaces.partner;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerInfo;

@Mapper(
	componentModel = "spring",
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PartnerDtoMapper {
	// register
	PartnerCommand of(PartnerDto.RegisterRequest registerRequest);
	PartnerDto.RegisterResponse of(PartnerInfo partnerInfo);
}
