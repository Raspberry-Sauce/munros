package com.filter.munros.implementation;

import com.filter.munros.exceptions.InvalidHeightException;
import com.filter.munros.exceptions.InvalidQueryException;
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
  private static final String MAXIMUM = "max";
  private static final String MINIMUM = "min";
  private static final String INVALID_HEIGHT_EXCEPTION = "Invalid Height, No records returned";
  private static final String INVALID_QUERY_EXCEPTION = "Invalid Parameter in Query";

  public List<Munro> filterOrSortMunroData(List<MunroQuery> queries, List<Munro> munrosToSort)
      throws Exception {

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
        munrosToSort = sortAlphabetically(munrosToSort, query.getSortBy());
      }
    }

    for (MunroQuery query : queries){
      if (query.getQueryType().equals(BY_TOP)){
        munrosToSort = filterResults(munrosToSort, query.getValue());
      }
    }

    for (MunroQuery query : queries){
      if (query.getQueryType().equals(FILTER_BY_HEIGHT)){
        munrosToSort = filterByHeight(munrosToSort, query.getSortBy(), query.getValue());
        if (munrosToSort.size() == 0) {
          throw new InvalidHeightException(INVALID_HEIGHT_EXCEPTION);
        }
      }
    }
    return munrosToSort;
  }

  private List<Munro> sortDataByCategory(List<Munro> munrosToSort, String sortBy) throws Exception {
    if (sortBy != null && !sortBy.equals(MUNRO) && !sortBy.equals(MUNRO_TOP)){
      throw new InvalidQueryException(INVALID_QUERY_EXCEPTION);
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

  private List<Munro> sortbyHeight(List<Munro> munrosToSort, String sortBy) throws Exception {
    if (sortBy == null || (!sortBy.equals(ASCENDING) && !sortBy.equals(DESCENDING))){
      throw new InvalidQueryException(INVALID_QUERY_EXCEPTION);
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


  private List<Munro> sortAlphabetically(List<Munro> munrosToSort, String sortBy) throws Exception {
    if (sortBy == null || (!sortBy.equals(ASCENDING) && !sortBy.equals(DESCENDING))){
      throw new InvalidQueryException(INVALID_QUERY_EXCEPTION);
    }
    if (sortBy.equals(ASCENDING)){
      return munrosToSort
          .stream()
          .sorted(Comparator.comparing(Munro::getName))
          .collect(Collectors.toList());
    } else {
      return munrosToSort
          .stream()
          .sorted(Comparator.comparing(Munro::getName).reversed())
          .collect(Collectors.toList());
    }
  }

  private List<Munro> filterResults(List<Munro> munrosToSort, int value) throws Exception {
    if (value == 0) {
      throw new InvalidQueryException(INVALID_QUERY_EXCEPTION);
    }
    return munrosToSort
        .stream()
        .limit(value)
        .collect(Collectors.toList());
  }

  private List<Munro> filterByHeight(List<Munro> munrosToSort, String sortBy, int value) throws Exception {
    if (sortBy == null || (!sortBy.equals(MAXIMUM) && !sortBy.equals(MINIMUM))){
      throw new InvalidQueryException(INVALID_QUERY_EXCEPTION);
    }
    if (sortBy.equals(MAXIMUM)){
        return munrosToSort
            .stream()
            .filter(f -> value >= f.getHeight())
            .collect(Collectors.toList());
    } else {
        return munrosToSort
            .stream()
            .filter(f -> value <= f.getHeight())
            .collect(Collectors.toList());
      }
    }
  }
