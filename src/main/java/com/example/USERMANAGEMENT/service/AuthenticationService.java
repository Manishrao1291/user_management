package com.example.USERMANAGEMENT.service;

import com.example.USERMANAGEMENT.model.AuthenticationToken;
import com.example.USERMANAGEMENT.model.Playlist;
import com.example.USERMANAGEMENT.model.User;
import com.example.USERMANAGEMENT.repo.AuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {


    @Autowired
    AuthenticationRepo authenticationRepo;

    @Autowired
    PlaylistService playlistService;



    public String createToken(User existingUser) {
        AuthenticationToken authToken = new AuthenticationToken(existingUser);
        authenticationRepo.save(authToken);
        return "Token generated successfully.";
    }

    public String checkUser(Playlist playlist, String token) {
        String tokenMessage = null;
        if(token ==null){
            tokenMessage = "token cannot be null";
            return  tokenMessage;
        }
        AuthenticationToken existingToken =  authenticationRepo.findFirstByTokenValue(token);
        if(existingToken==null){
            tokenMessage = "invalid Token";
            return tokenMessage;
        }
        return playlistService.createPlaylist(playlist);
    }


    public String checkUserToken(String token) {
        String tokenMessage = null;
        if(token ==null){
            tokenMessage = "token cannot be null";
            return  tokenMessage;
        }
        AuthenticationToken existingToken =  authenticationRepo.findFirstByTokenValue(token);
        if(existingToken==null){
            tokenMessage = "invalid Token";
            return tokenMessage;
        }
        authenticationRepo.delete(existingToken);
        tokenMessage = "User signOut successfully.";
        return tokenMessage;
    }
}
