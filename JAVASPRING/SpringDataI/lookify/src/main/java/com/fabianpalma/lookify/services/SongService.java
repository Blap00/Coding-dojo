package com.fabianpalma.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.lookify.models.Song;
import com.fabianpalma.lookify.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	SongRepository songRepository;
	
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    
    public List<Song> getArtistByName(String name) {
    	return songRepository.findArtistByName(name);
    }
    
    public List<Song> findTop10Songs() {
    	return songRepository.findTop10Songs();
    }
}