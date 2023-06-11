package dev.practice.order.domain;

public interface PartnerService {
	PartnerInfo registerPartner(PartnerCommand command);
	PartnerInfo getPartner(String partnerToken);
	// PartnerInfo updatePartner(PartnerCommand command);
	// PartnerInfo deletePartner(PartnerCommand command);
	PartnerInfo enablePartner(String partnerToken);
	PartnerInfo disablePartner(String partnerToken);
}
