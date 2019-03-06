package com.example.recyclerview.Pokemon;

import com.example.recyclerview.Pokemon.Pokemon;

import java.util.List;

public class RestPokemonResponse {

    private Integer count ;
    private String next;
    private String previous;
    private List<Pokemon> results;

    //Les getters
    public Integer getCount() {  return count; }
    public String getNext() { return next;  }
    public String getPrevious() { return previous; }
    public List<Pokemon> getResults() { return results; }


    //Les setters
    public void setCount(Integer count) { this.count = count; }
    public void setNext(String next) { this.next = next; }
    public void setPrevious(String previous) { this.previous = previous; }
    public void setResults(List<Pokemon> results) { this.results = results; }

}
