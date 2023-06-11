package dev.practice.order.infrastructure.notification;

import org.springframework.stereotype.Component;

import dev.practice.order.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificationExecutor implements NotificationService {

	@Override
	public void sendEmail(String email, String title, String content) {
		log.info("send email");
	}

	@Override
	public void sendKakao(String phoneNo, String title, String content) {
		log.info("send kakao");
	}

	@Override
	public void sendSms(String phoneNo, String title, String content) {
		log.info("send sms");
	}
}
