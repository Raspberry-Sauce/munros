package com.filter.munros.mappers;

import com.filter.munros.models.Munro;
import java.util.List;
import org.junit.jupiter.api.Test;

class MunroDataMapperTest {

  private static final String MUNRO_NAME = "Ben Chonzie";
  private static final String HEIGHT = "931";
  private static final String CATEGORY = "MUN";
  private static final String REFERENCE = "NN773308";

  @Test
  void ensureMapperReturnsTheCorrectNumberOfRecordsInAListOfObjects(){
    MunroDataMapper munroDataMapper = new MunroDataMapper();
    List<Munro> munros = munroDataMapper.retrieveMunroData();
    assert (munros.size() == 610);
    assert (munros.get(0).getName().equals(MUNRO_NAME));
    assert (munros.get(0).getHeight().equals(HEIGHT));
    assert (munros.get(0).getHillCategory().equals(CATEGORY));
    assert (munros.get(0).getGridReference().equals(REFERENCE));
  }
}
