package dev.practice.order.domain;

import java.security.InvalidParameterException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.util.Strings;

import dev.practice.order.AbstractEntity;
import dev.practice.order.common.TokenGenerator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "partners")
public class Partner extends AbstractEntity {

	private static final String PARTNER_PREFIX = "ptn_";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String partnerToken;

	private String partnerName;

	private String businessNo;

	private String email;

	private Status status;

	@Getter
	@RequiredArgsConstructor
	public enum Status {
		ENABLE("활성화"), DISABLE("비활성화");

		private final String description;
	}

	@Builder
	private Partner(String partnerName, String businessNo, String email) {
		if (Strings.isBlank(partnerName)) throw new InvalidParameterException("blank partnerName");
		if (Strings.isBlank(businessNo)) throw new InvalidParameterException("blank businessNo");
		if (Strings.isBlank(email)) throw new InvalidParameterException("blank email");

		this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PARTNER_PREFIX);
		this.partnerName = partnerName;
		this.businessNo = businessNo;
		this.email = email;
		this.status = Status.ENABLE;
	}

	public void enable() {
		this.status = Status.ENABLE;
	}

	public void disable() {
		this.status = Status.DISABLE;
	}
}
