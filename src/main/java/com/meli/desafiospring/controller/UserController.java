package com.meli.desafiospring.controller;

import com.meli.desafiospring.dto.FollowerCountDTO;
import com.meli.desafiospring.dto.UserFollowersDTO;
import com.meli.desafiospring.dto.UserFollowingsDTO;
import com.meli.desafiospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService service;

    @PostMapping("{userId}/follow/{userIdToFollow}")
    @ResponseStatus(HttpStatus.OK)
    public void followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        service.follow(userId, userIdToFollow);
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    @ResponseStatus(HttpStatus.OK)
    public void unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        service.unfollow(userId, userIdToUnfollow);
    }

    @GetMapping("{userId}/followers/count")
    @ResponseStatus(HttpStatus.OK)
    public FollowerCountDTO getUsers(@PathVariable Integer userId) {
        return service.followCount(userId);
    }


    @GetMapping("{userId}/followed/list")
    @ResponseStatus(HttpStatus.OK)
    public UserFollowingsDTO getFollowed(@PathVariable Integer userId, @RequestParam(defaultValue = "") String order) {
        return service.getFollowing(userId, order);
    }

    @GetMapping("{userId}/followers/list")
    @ResponseStatus(HttpStatus.OK)
    public UserFollowersDTO getFollowers(@PathVariable Integer userId, @RequestParam(defaultValue = "") String order) {
        return service.getFollowers(userId, order);
    }


}
