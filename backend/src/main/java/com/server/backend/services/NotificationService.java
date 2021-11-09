package com.server.backend.services;

import com.server.backend.entities.Auction;
import com.server.backend.entities.Notification;
import com.server.backend.entities.User;
import com.server.backend.repositories.NotificationRepository;
import com.server.backend.springsocket.SocketModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

  @Autowired
  private NotificationRepository notificationRepository;

  @Autowired
  private SocketModule socketModule;

  public void createNotificationForHost(Auction auction, int price) {

    Notification notification = Notification.builder()
            .auction(auction)
            .user(auction.getHost())
            .message("har fått ett nytt bud: " + price)
            .isRead(false)
            .build();

    notificationRepository.save(notification);
    socketModule.emit("notification", notification);
  }

  public void createNotificationForUser(User user, Auction auction) {
      Notification notification = Notification.builder()
              .auction(auction)
              .user(user)
              .message("Någon har lagt ett högre bud på: ")
              .isRead(false)
              .build();

      notificationRepository.save(notification);
      socketModule.emit("notification", notification);
  }
}
