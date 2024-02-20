package com.example.USERMANAGEMENT.service;

import com.example.USERMANAGEMENT.model.Playlist;
import com.example.USERMANAGEMENT.model.Song;
import com.example.USERMANAGEMENT.model.User;
import com.example.USERMANAGEMENT.repo.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepo playlistRepo;

    public String createPlaylist(Playlist playlist) {
        playlistRepo.save(playlist);
        return "playlist added successfully";
    }

    public List<Playlist> getPlaylist(User user) {
        Integer userId = user.getUserId();
        List<Playlist> playlists = playlistRepo.findFirstByUser(user);
        return playlists;
    }



}
