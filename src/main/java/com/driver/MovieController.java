package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
//1
    @PostMapping("POST/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String movieGot=movieService.addMovie(movie);
        return new ResponseEntity<>(movieGot, HttpStatus.CREATED);
    }
//2
    @PostMapping("POST/movies/add-director")
    public ResponseEntity addDirectory(@RequestBody Director director){
        String directorGot=movieService.addDirector(director);
        return new ResponseEntity<>(directorGot, HttpStatus.CREATED);
    }
//3
    @PutMapping("PUT/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){
        String movieDirectorGot=movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>(movieDirectorGot, HttpStatus.CREATED);

    }
//4X
    @GetMapping("GET/movies/get-movie-by-name/{name}")
    public ResponseEntity  getMovieByName(@PathVariable("name") String name){
        Movie movieGot=movieService.getMovieByName(name);
        return new ResponseEntity<>(movieGot, HttpStatus.FOUND);
    }
//5X
    @GetMapping("GET/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        Director directorGot=movieService.getDirectorByName(name);
        return new ResponseEntity<>(directorGot, HttpStatus.FOUND);
    }
//6
    @GetMapping("GET/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> movieList=movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movieList, HttpStatus.FOUND);
    }
//7
    @GetMapping("GET/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> movieList=movieService.findAllMovies();
        return new ResponseEntity<>(movieList, HttpStatus.FOUND);
    }
//8x
    @DeleteMapping("DELETE/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        String response=movieService.deleteDirectorByName(name);
        if(response.equals("Deleted Successfully")){
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
//9
    @DeleteMapping("DELETE/movies/delete-all-directors")
    public ResponseEntity  deleteAllDirectors(){
        String response=movieService.deleteAllDirectors();
        if(response.equals("Deleted Completely")){
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }





}
