package com.filter.munros.implementation;

import com.filter.munros.models.MunroQuery;
import com.filter.munros.models.Munro;
import java.util.List;
import org.springframework.stereotype.Component;



@Component
public class MunroSorterImpl {

  private static final String BY_CATEGORY = "byCategory";
  private static final String SORT_BY_HEIGHT = "sortByHeight";
  private static final String ALPHABETICALLY = "alphabetically";
  private static final String BY_TOP = "byTop";
  private static final String FILTER_BY_HEIGHT = "filterByHeight";

  public List<Munro> filterOrSortMunroData(List<MunroQuery> queries, List<Munro> munrosToSort){

    for (MunroQuery query : queries){
      if (query.getQueryType().equals(BY_CATEGORY)){
        munrosToSort = sortDataByCategory(munrosToSort, query.getSortBy()); //sortBy Munro, Munro Top or null (both)
      }
    }

    for (MunroQuery query : queries){
      if (query.getQueryType().equals(SORT_BY_HEIGHT)){
        munrosToSort = sortbyHeight(munrosToSort, query.getSortBy()); //sortBy asc or desc
      }
    }

    for (MunroQuery query : queries){
      if (query.getQueryType().equals(ALPHABETICALLY)){
        munrosToSort = sortAlphabetically(munrosToSort, query.getSortBy()); //sortBy asc or desc
      }
    }

    for (MunroQuery query : queries){
      if (query.getQueryType().equals(BY_TOP)){
        munrosToSort = filterResults(munrosToSort, query.getValue()); //Value is positive integer which filters that many results
      }
    }

    for (MunroQuery query : queries){
      if (query.getQueryType().equals(FILTER_BY_HEIGHT)){
        munrosToSort = filterByHeight(munrosToSort, query.getSortBy(), query.getValue()); //sortBy maximum or minimum, returning records below or above a height
      }
    }

    return null;
  }

  private List<Munro> sortbyHeight(List<Munro> munrosToSort, String sortBy) {
    return null;
  }

  private List<Munro> sortDataByCategory(List<Munro> munrosToSort, String sortBy) {
    return null;
  }

  private List<Munro> sortAlphabetically(List<Munro> munrosToSort, String sortBy) {
    return null;
  }

  private List<Munro> filterResults(List<Munro> munrosToSort, int value) {
    return null;
  }

  private List<Munro> filterByHeight(List<Munro> munrosToSort, String sortBy, int value) {
    return null;
  }


}
