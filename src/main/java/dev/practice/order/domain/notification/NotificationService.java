package dev.practice.order.domain.notification;

public interface NotificationService {

	void sendEmail(String email, String title, String content);
	void sendKakao(String phoneNo, String title, String content);
	void sendSms(String phoneNo, String title, String content);
}
