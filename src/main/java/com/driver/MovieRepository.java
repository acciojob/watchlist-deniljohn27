package com.driver;

import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> addMovie;
    HashMap<String,Director> addDirector;
    HashMap<String,Pair> movieDirector;

    public MovieRepository() {
        this.addMovie = new HashMap<>();;
        this.addDirector =new HashMap<>();;
        this.movieDirector =new HashMap<>();;
    }

    //1
    public String addMovie(Movie movie){
        addMovie.put(movie.getName().toUpperCase(),movie);
        return "Movie Added Successfully";
    }
//2
    public String addDirector(Director director){
        addDirector.put(director.getName().toUpperCase(),director);
        return "Director Added Successfully";
    }
//3
    public String addMovieDirectorPair(String movie,String director){
        String movieU=movie.toUpperCase();
        String directorU=director.toUpperCase();
        if(addMovie.containsKey(movieU)&&addDirector.containsKey(directorU)){
            movieDirector.put(movieU,new Pair(addMovie.get(movieU),addDirector.get(directorU)));
            return "Paired Successfully";
        }
        return"No valid data found";

    }
//4
    public Movie getMovieByName(String movie){
        return addMovie.get(movie.toUpperCase());
    }
//5
    public Director getDirectorByName(String director){
        return addDirector.get(director.toUpperCase());
    }
//6
    public List<String> getMoviesByDirectorName(String director){
        List<String> movieList=new ArrayList<>();
        for(String movie :movieDirector.keySet()){
            String directorName=movieDirector.get(movie).director.getName();
            if(directorName.toUpperCase().equals(director.toUpperCase())){
                movieList.add(movie);
            }
        }
        return movieList;
    }
//7
    public List<String> findAllMovies(){
        List<String> movieList=new ArrayList<>();
        for(String movie:addMovie.keySet()){
            movieList.add(movie);
        }
        return movieList;
    }
//8
    public String  deleteDirectorByName(String director){

        if(addDirector.containsKey(director.toUpperCase())){
        for(String movie:movieDirector.keySet()){
            String directorName=movieDirector.get(movie).director.getName();
            if(directorName.toUpperCase().equals(director.toUpperCase())){
                movieDirector.remove(movie);
                addMovie.remove(movie);
                addDirector.remove(director.toUpperCase());
            }
        }
        return "Deleted Successfully";}
        return "Not Found";
    }
//9
    public String deleteAllDirectors(){
        if(!addDirector.isEmpty()){
        for(String movie:movieDirector.keySet()){
            String directorName=movieDirector.get(movie).director.getName();
            addMovie.remove(movie);
            addDirector.remove(directorName.toUpperCase());
            movieDirector.remove(movie);
        }
        return"Deleted Completely";
        }
        return "Empty";
    }
}

class Pair{
    Movie movie;
    Director director;
    Pair(Movie movie,Director director){
        this.movie=movie;
        this.director=director;
    }
}
