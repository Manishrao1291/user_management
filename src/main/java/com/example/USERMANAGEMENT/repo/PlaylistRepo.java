package com.example.USERMANAGEMENT.repo;

import com.example.USERMANAGEMENT.model.Playlist;
import com.example.USERMANAGEMENT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepo extends JpaRepository<Playlist,Integer> {

    List<Playlist> findFirstByUser(User user);

}
