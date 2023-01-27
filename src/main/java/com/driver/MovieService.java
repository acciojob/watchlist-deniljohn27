package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    //1
    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    //2
    public String addDirector(Director director){

        return movieRepository.addDirector(director);
    }
    //3
    public String addMovieDirectorPair(String movie,String director){

        return movieRepository.addMovieDirectorPair(movie,director);

    }
    //4
    public Movie getMovieByName(String movie){
        return movieRepository.getMovieByName(movie);
    }
    //5
    public Director getDirectorByName(String director){
        return movieRepository.getDirectorByName(director);
    }
    //6
    public List<String> getMoviesByDirectorName(String director){

        return movieRepository.getMoviesByDirectorName(director);
    }
    //7
    public List<String> findAllMovies(){

        return movieRepository.findAllMovies();
    }
    //8
    public String  deleteDirectorByName(String director){

        return movieRepository.deleteDirectorByName(director);
    }
    //9
    public String deleteAllDirectors(){

        return movieRepository.deleteAllDirectors();
    }


}
