package com.filter.munros.implementation;

import com.filter.munros.models.MunroQuery;
import com.filter.munros.models.Munro;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MunroSorterImpl {

  private static final String BY_CATEGORY = "byCategory";
  private static final String SORT_BY_HEIGHT = "sortByHeight";
  private static final String ALPHABETICALLY = "alphabetically";
  private static final String BY_TOP = "byTop";
  private static final String FILTER_BY_HEIGHT = "filterByHeight";
  private static final String MUNRO = "MUN";
  private static final String MUNRO_TOP = "TOP";
  private static final String ASCENDING = "asc";
  private static final String DESCENDING = "desc";

  public List<Munro> filterOrSortMunroData(List<MunroQuery> queries, List<Munro> munrosToSort){

    for (MunroQuery query : queries){
      if (query.getQueryType().equals(BY_CATEGORY)){
        munrosToSort = sortDataByCategory(munrosToSort, query.getSortBy());
      }
    }

    for (MunroQuery query : queries){
      if (query.getQueryType().equals(SORT_BY_HEIGHT)){
        munrosToSort = sortbyHeight(munrosToSort, query.getSortBy());
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
    return munrosToSort;
  }

  private List<Munro> sortDataByCategory(List<Munro> munrosToSort, String sortBy) {
    if (sortBy != null && !sortBy.equals(MUNRO) && !sortBy.equals(MUNRO_TOP)){
      return null; //TODO InvalidQuery Exception
    }
    if (sortBy != null){
      return munrosToSort
          .stream()
          .filter(f -> sortBy.equals(f.getHillCategory()))
          .collect(Collectors.toList());

    } else {
      return munrosToSort
          .stream()
          .filter(f -> MUNRO.equals(f.getHillCategory()) || MUNRO_TOP.equals(f.getHillCategory()) )
          .collect(Collectors.toList());
    }
  }

  private List<Munro> sortbyHeight(List<Munro> munrosToSort, String sortBy) {
    if (sortBy == null || (!sortBy.equals(ASCENDING) && !sortBy.equals(DESCENDING))){
      return null; //TODO InvalidQuery Exception
    }
    if (sortBy.equals(ASCENDING)){
      return munrosToSort
          .stream()
          .sorted(Comparator.comparingDouble(Munro::getHeight))
          .collect(Collectors.toList());
    } else {
      return munrosToSort
          .stream()
          .sorted(Comparator.comparingDouble(Munro::getHeight).reversed())
          .collect(Collectors.toList());
    }
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
