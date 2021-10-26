package com.server.backend.services;

import com.server.backend.entities.Auction;
import com.server.backend.entities.Bid;
import com.server.backend.entities.User;
import com.server.backend.repositories.AuctionRepository;
import com.server.backend.repositories.BidRepository;
import com.server.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class BidService {

  @Autowired
  private BidRepository bidRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuctionRepository auctionRepository;

  public Bid createBid(Map values) {
    User currentUser =  userRepository.findById((long) (int) values.get("userId")).get();
    Auction currentAuction = auctionRepository.findById((long) (int) values.get("auctionId")).get();

    try{
      Bid bid = Bid.builder()
              .user(currentUser)
              .auction(currentAuction)
              .price((int) values.get("price"))
              .createdDate((long) values.get("createdDate"))
              .build();

      return bidRepository.save(bid);
    } catch(Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
