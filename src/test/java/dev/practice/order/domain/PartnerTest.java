package dev.practice.order.domain;

import static org.assertj.core.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PartnerTest {

	@Test
	@DisplayName("파트너 생성 시 필수값 만족하면 정상 생성")
	void initTest() {

		String partnerName = "파트너 이름";
		String businessNo = "123123";
		String email = "partner@partner.com";

		Partner initPartner = Partner.builder()
			.partnerName(partnerName)
			.businessNo(businessNo)
			.email(email)
			.build();

		assertThat(initPartner.getPartnerToken()).startsWith("ptn_");
		assertThat(initPartner.getPartnerName()).isEqualTo(partnerName);
		assertThat(initPartner.getBusinessNo()).isEqualTo(businessNo);
		assertThat(initPartner.getEmail()).isEqualTo(email);
		assertThat(initPartner.getStatus()).isEqualTo(Partner.Status.ENABLE);
	}

	@Test
	@DisplayName("파트너 생성 시 필수값 누락할 경우 익셉션 발생")
	void initTest_missing_requiredValue() {

		String partnerName = "파트너 이름";
		String businessNo = "123123";
		String email = "partner@partner.com";

		assertThatCode(() -> {
			Partner initPartner = Partner.builder()
				.businessNo(businessNo)
				.email(email)
				.build();
		}).isInstanceOf(InvalidParameterException.class);
	}

	@Test
	@DisplayName("파트너 상태 활성화")
	void enable() {
		Partner partner = disablePartner();
		partner.enable();
		assertThat(partner.getStatus()).isEqualTo(Partner.Status.ENABLE);
	}

	@Test
	@DisplayName("파트너 상태 비활성화")
	void disable() {
		Partner partner = enablePartner();
		partner.disable();
		assertThat(partner.getStatus()).isEqualTo(Partner.Status.DISABLE);
	}

	private Partner enablePartner() {
		String partnerName = "파트너 이름";
		String businessNo = "123123";
		String email = "partner@partner.com";

		return Partner.builder()
			.partnerName(partnerName)
			.businessNo(businessNo)
			.email(email)
			.build();
	}

	private Partner disablePartner() {
		Partner partner = enablePartner();
		partner.disable();
		return partner;
	}

}