package com.sparta.petplace.post.ResponseDto;

import com.sparta.petplace.post.entity.Post;
import com.sparta.petplace.review.dto.ReviewResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostReviewResponseDto {
    private Long id;

    private String email;
    private String title;
    private String ceo;
    private String contents;
    private String category;
    private String cost;
    private String lat;
    private String lng;
    private String address;
    private String telNum;
    private String startTime;
    private String endTime;
    private String closedDay;
    private String reSizeImage;
    private Double distance;
    private String feature1;
    private String aboolean1;
    private String aboolean2;


    private Integer star;
    private int reviewCount;

    private List<String> image;
    private Page<ReviewResponseDto> review;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private boolean isLike;

    @Builder
    public PostReviewResponseDto(Post post, List<String> image, boolean isLike, Page<ReviewResponseDto> review, int reviewCount , Integer star , Double distance){
        this.id = post.getId();
        this.reSizeImage = post.getResizeImage();
        this.modifiedAt = post.getModifiedAt();
        this.createdAt = post.getCreatedAt();
        this.aboolean1 = post.getAboolean1();
        this.aboolean2 = post.getAboolean2();
        this.startTime = post.getStartTime();
        this.closedDay = post.getClosedDay();
        this.category = post.getCategory();
        this.contents = post.getContents();
        this.endTime = post.getEndTime();
        this.feature1 = post.getFeature1();
        this.address = post.getAddress();
        this.telNum = post.getTelNum();
        this.email = post.getEmail();
        this.title = post.getTitle();
        this.cost = post.getCost();
        this.ceo = post.getCeo();
        this.lat = post.getLat();
        this.lng = post.getLng();
        this.reviewCount = reviewCount;
        this.distance= distance;
        this.review = review;
        this.isLike = isLike;
        this.image = image;
        this.star = star;
    }

    public static PostReviewResponseDto of(Post post){
        return PostReviewResponseDto.builder()
                .post(post)
                .build();
    }
    public static PostReviewResponseDto from(Post post,List<String> image){
        return PostReviewResponseDto.builder()
                .post(post)
                .image(image)
                .build();
    }
    public static PostReviewResponseDto of(Post post, List<String> image, Page<ReviewResponseDto> responseDtoList, boolean isLike , int reviewCount, Integer star){
        return PostReviewResponseDto.builder()
                .post(post)
                .image(image)
                .review(responseDtoList)
                .reviewCount(reviewCount)
                .star(star)
                .isLike(isLike)
                .build();
    }
}