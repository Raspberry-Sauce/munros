package com.filter.munros.implementation;

import com.filter.munros.models.Munro;
import com.filter.munros.models.MunroQuery;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MunroImplTest {

  private static final String GRID_REFERENCE = "NM123456789";
  private static final String MUN = "MUN";
  private static final String TOP = "TOP";
  private static final String ASCENDING = "asc";
  private static final String FOURTH_MUNRO = "FOUR";
  private static final String THIRD_MUNRO = "THREE";
  private static final String SECOND_MUNRO = "TWO";
  private static final String FIRST_MUNRO = "ONE";
  private static final String SORT_BY_HEIGHT = "sortByHeight";
  private static final String SORT_BY_CATEGORY = "byCategory";
  private static final String DESCENDING = "desc";
  private static final String ALPHABETICALLY = "alphabetically";
  private static final String BY_TOP = "byTop";
  private static final String FILTER_BY_HEIGHT = "filterByHeight";
  private static final String MAXIMUM = "max";
  private static final String MINIMUM = "min";

  @Test
  void testToEnsureMunrosAreReturnedByCategory(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType(SORT_BY_CATEGORY);
    query.setSortBy(TOP);
    queries.add(query);

    List<Munro> munrosToSort = getMunros();
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(THIRD_MUNRO));
    assert (processedData.get(0).getHillCategory().equals(TOP));
    assert (processedData.size() == 1);

  }

  @Test
  void testToEnsureMunrosAreReturnedByHeightAscending(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType(SORT_BY_HEIGHT);
    query.setSortBy(ASCENDING);
    queries.add(query);

    List<Munro> munrosToSort = getMunros();
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(SECOND_MUNRO));
    assert (processedData.get(3).getName().equals(FOURTH_MUNRO));
    assert (processedData.size() == 4);

  }

  @Test
  void testToEnsureMunrosAreReturnedByHeightDescending(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType(SORT_BY_HEIGHT);
    query.setSortBy(DESCENDING);
    queries.add(query);

    List<Munro> munrosToSort = getMunros();
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(FOURTH_MUNRO));
    assert (processedData.get(3).getName().equals(SECOND_MUNRO));
    assert (processedData.size() == 4);
  }

  @Test
  void testToEnsureMunrosAreReturnedByAlphabeticallyAscending(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType(ALPHABETICALLY);
    query.setSortBy("asc");
    queries.add(query);

    List<Munro> munrosToSort = getMunros();
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(FOURTH_MUNRO));
    assert (processedData.get(3).getName().equals(SECOND_MUNRO));
    assert (processedData.size() == 4);
  }

  @Test
  void testToEnsureMunrosAreReturnedByAlphabeticallyDesecnding(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType(ALPHABETICALLY);
    query.setSortBy(DESCENDING);
    queries.add(query);

    List<Munro> munrosToSort = getMunros();
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(FOURTH_MUNRO));
    assert (processedData.get(3).getName().equals(SECOND_MUNRO));
    assert (processedData.size() == 4);

  }

  @Test
  void testToEnsureOnlyTheFirst2MunrosAreReturned(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType(BY_TOP);
    query.setValue(2);
    queries.add(query);

    List<Munro> munrosToSort = getMunros();
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(FIRST_MUNRO));
    assert (processedData.get(1).getName().equals(SECOND_MUNRO));
    assert (processedData.size() == 2);

  }

  @Test
  void testToEnsureMunrosAreReturnedByBeingBelowAProvidedHeight(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType(FILTER_BY_HEIGHT);
    query.setSortBy(MAXIMUM);
    query.setValue(1000);
    queries.add(query);

    List<Munro> munrosToSort = getMunros();
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(FIRST_MUNRO));
    assert (processedData.get(1).getName().equals(THIRD_MUNRO));
    assert (processedData.size() == 2);
  }

  @Test
  void testToEnsureMunrosAreReturnedByBeingAboveAProvidedHeight(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType(FILTER_BY_HEIGHT);
    query.setSortBy(MINIMUM);
    query.setValue(1000);
    queries.add(query);

    List<Munro> munrosToSort = getMunros();
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(FIRST_MUNRO));
    assert (processedData.get(1).getName().equals(THIRD_MUNRO));
    assert (processedData.get(2).getName().equals(THIRD_MUNRO));
    assert (processedData.size() == 2);

  }

  @Test
  void testInvalidHeightException(){

  }

  @Test
  void testInvalidQueryException(){

  }

  private List<Munro> getMunros() {
    List<Munro> munrosToSort = new ArrayList<>();
    Munro firstMunro = new Munro();
    firstMunro.setName(FIRST_MUNRO);
    firstMunro.setHillCategory(MUN);
    firstMunro.setHeight("1000");
    firstMunro.setGridReference(GRID_REFERENCE);

    Munro secondMunro = new Munro();
    secondMunro.setName(SECOND_MUNRO);
    secondMunro.setHillCategory(MUN);
    secondMunro.setHeight("1300");
    secondMunro.setGridReference(GRID_REFERENCE);

    Munro thirdMunro = new Munro();
    thirdMunro.setName(THIRD_MUNRO);
    thirdMunro.setHillCategory(TOP);
    thirdMunro.setHeight("900");
    thirdMunro.setGridReference(GRID_REFERENCE);

    Munro fourthMunro = new Munro();
    fourthMunro.setName(FOURTH_MUNRO);
    fourthMunro.setHeight("1500");
    fourthMunro.setGridReference(GRID_REFERENCE);

    munrosToSort.add(firstMunro);
    munrosToSort.add(secondMunro);
    munrosToSort.add(thirdMunro);
    munrosToSort.add(fourthMunro);
    return munrosToSort;
  }





}
