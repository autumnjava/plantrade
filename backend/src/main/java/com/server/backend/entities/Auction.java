package com.server.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="auctions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
    private double startPrice;

    @Enumerated(EnumType.STRING)
    @Column(name="status", columnDefinition = "TEXT", length=50, nullable=false, unique=false)
    private Status status;
    private Date endDate;

    @ManyToOne
    @JsonIncludeProperties({"id", "username"})
    private User host;

    @ManyToOne
    @JsonIncludeProperties({"id", "username"})
    private User winner;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "auction_x_category",
            joinColumns = @JoinColumn(name = "auction_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"auction"})
    private List<Bid> bids;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.REMOVE)
    private List<Image> images;

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public void removeImage(Image image) {
        images.remove(image);
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public void removeBid(Bid bid) {
        bids.remove(bid);
    }

}
