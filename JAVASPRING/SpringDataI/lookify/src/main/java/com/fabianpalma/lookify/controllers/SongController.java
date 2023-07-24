package com.fabianpalma.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabianpalma.lookify.models.Song;
import com.fabianpalma.lookify.repositories.SongRepository;
import com.fabianpalma.lookify.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongRepository songRepository;
	@Autowired
	SongService songService;
	
	@GetMapping("/")
    public String index() {
        return "index.jsp";
    }
	
	@GetMapping("/songs/new")
    public String newsong() {
        return "newSong.jsp";
    }
	
	@GetMapping("/songs/{id}")
    public String newsong(
    @PathVariable("id") Long id,
    Model model
    ) {
		Song song = songService.getSongById(id);
		model.addAttribute("song", song);
        return "songData.jsp";
    }
	
	@GetMapping("/dashboard")
    public String dashboard(
    Model model
    ) {
		List<Song> songs = songService.getAllSongs();
		model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
	
	@PostMapping("/songs/searchbytitle")
    public String searchbytitle(
    @RequestParam("artist") String artist
    ) {
        return "redirect:/search/"+artist;
    }
	
	@GetMapping("/search/topTen")
    public String seachtopten(
	Model model
    ) {
		List<Song> topten = songService.findTop10Songs();
		model.addAttribute("topten", topten);
        return "topten.jsp";
    }
	
	@GetMapping("/search/{name}")
    public String searchbytitle(
	@PathVariable("name") String name,
	Model model
    ) {
		String queryName = name+"%";
		List<Song> artistObject = songService.getArtistByName(queryName);
		model.addAttribute("artistObject", artistObject);
		model.addAttribute("name", name);
        return "dashboard2.jsp";
    }
	
	@PostMapping("/songs/create")
    public String createsong(
    @RequestParam("title") String title,
    @RequestParam("artist") String artist,
    @RequestParam("rating") int rating
    ) {
		Song song = new Song();
		song.setArtist(artist);
		song.setRating(rating);
		song.setTitle(title);
		songRepository.save(song);
        return "redirect:/songs/new";
    }
	
	@PostMapping("/songs/delete")
    public String createsong(
    @RequestParam("id") Long id
    ) {
		songRepository.deleteById(id);
        return "redirect:/dashboard";
    }
}