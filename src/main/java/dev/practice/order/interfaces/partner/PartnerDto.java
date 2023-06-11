package dev.practice.order.interfaces.partner;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import dev.practice.order.domain.partner.Partner;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PartnerDto {
	@Getter
	@Setter
	@ToString
	public static class RegisterRequest {
		@NotBlank(message = "partnerName 는 필수값입니다")
		private String partnerName;

		@NotBlank(message = "businessNo 는 필수값입니다")
		private String businessNo;

		@Email(message = "email 형식에 맞아야 합니다")
		@NotBlank(message = "email 는 필수값입니다")
		private String email;
	}

	@Getter
	@Builder
	@ToString
	public static class RegisterResponse {
		private final String partnerToken;
		private final String partnerName;
		private final String businessNo;
		private final String email;
		private final Partner.Status status;
	}
}
