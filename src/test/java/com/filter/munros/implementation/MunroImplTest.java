package com.filter.munros.implementation;

import com.filter.munros.models.Munro;
import com.filter.munros.models.MunroQuery;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MunroImplTest {

  @Test
  void testToEnsureMunrosAreReturnedByCategory(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType("byCategory");
    queries.add(query);

    List<Munro> munrosToSort = null;
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(""));
    assert (processedData.size() == 10);
  }

  @Test
  void testToEnsureMunrosAreReturnedByHeightAscending(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType("sortByHeight");
    query.setSortBy("asc");
    queries.add(query);

    List<Munro> munrosToSort = null;
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(""));
    assert (processedData.size() == 10);
  }

  @Test
  void testToEnsureMunrosAreReturnedByHeightDescending(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType("sortByHeight");
    query.setSortBy("desc");
    queries.add(query);

    List<Munro> munrosToSort = null;
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(""));
    assert (processedData.size() == 10);
  }

  @Test
  void testToEnsureMunrosAreReturnedByAlphabeticallyAscending(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType("alphabetically");
    query.setSortBy("asc");
    queries.add(query);

    List<Munro> munrosToSort = null;
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(""));
    assert (processedData.size() == 10);
  }

  @Test
  void testToEnsureMunrosAreReturnedByAlphabeticallyDesecnding(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType("alphabetically");
    query.setSortBy("desc");
    queries.add(query);

    List<Munro> munrosToSort = null;
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(""));
    assert (processedData.size() == 10);
  }

  @Test
  void testToEnsureOnlyTheFirst10MunrosAreReturned(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType("byTop");
    query.setValue(10);
    queries.add(query);

    List<Munro> munrosToSort = null;
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(""));
    assert (processedData.size() == 10);
  }

  @Test
  void testToEnsureMunrosAreReturnedByBeingBelowAProvidedHeight(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType("filterByHeight");
    query.setSortBy("max");
    query.setValue(1000);
    queries.add(query);

    List<Munro> munrosToSort = null;
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(""));
    assert (processedData.size() == 10);
  }

  @Test
  void testToEnsureMunrosAreReturnedByBeingAboveAProvidedHeight(){
    MunroSorterImpl munroSorter = new MunroSorterImpl();
    List<MunroQuery> queries = new ArrayList<>();
    MunroQuery query = new MunroQuery();
    query.setQueryType("filterByHeight");
    query.setSortBy("min");
    query.setValue(1000);
    queries.add(query);

    List<Munro> munrosToSort = null;
    List<Munro> processedData = munroSorter.filterOrSortMunroData(queries, munrosToSort);

    assert (processedData.get(0).getName().equals(""));
    assert (processedData.size() == 10);

  }

  @Test
  void testInvalidHeightException(){

  }

  @Test
  void testInvalidQueryException(){

  }





}
