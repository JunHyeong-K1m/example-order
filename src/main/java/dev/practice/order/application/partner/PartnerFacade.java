package dev.practice.order.application.partner;

import org.springframework.stereotype.Service;

import dev.practice.order.domain.notification.NotificationService;
import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerInfo;
import dev.practice.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {

	private final PartnerService partnerService;
	private final NotificationService notificationService;

	public PartnerInfo registerPartner(PartnerCommand command) {
		// 1. 파트너를 등록한다.
		// 2. 등록을 성공하면 등록된 이메일로 가입 완료 안내 메일을 발송한다.
		PartnerInfo partnerInfo = partnerService.registerPartner(command);
		notificationService.sendEmail(partnerInfo.getEmail(), "title", "content");
		return partnerInfo;
	}
}
