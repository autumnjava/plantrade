package com.server.backend.controllers;

import com.server.backend.entities.Auction;
import com.server.backend.services.AuctionService;
import com.server.backend.services.UserService;
import jdk.jshell.Snippet;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auctions")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Auction>> getAllAuctions() {
        List<Auction> auctions = auctionService.getAllAuctions();
        if(auctions.size() > 0) {
            return ResponseEntity.ok(auctions);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Auction>> getAuctionById(@PathVariable long id) {
        Optional<Auction> auction = auctionService.getAuctionById(id);
        if(auction.isPresent()) {
            return ResponseEntity.ok(auction);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public Auction createAuction(@RequestBody Auction auction){ return auctionService.createAuction(auction); }
    
    @GetMapping("/user")
    public ResponseEntity<List<Auction>> getAuctionsByCurrentUser() {
        var user = userService.findCurrentUser();
        if(user != null){
            List<Auction> auctions = auctionService.getAuctionsByCurrentUser(user);
            if(auctions.size() > 0){
                return ResponseEntity.ok(auctions);
            } else {
                return ResponseEntity.noContent().build();
            }
        } else {
            return ResponseEntity.noContent().build();
        }

    }

}
