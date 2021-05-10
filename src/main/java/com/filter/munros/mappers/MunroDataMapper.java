package com.filter.munros.mappers;

import com.filter.munros.models.Munro;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MunroDataMapper {

  public List<Munro> retrieveMunroData() {

    List<Munro> listOfMunros = new ArrayList<>();
      try (CSVReader csvReader = new CSVReader(new FileReader("/Users/din06/IdeaProjects/munros/src/main/resources/munrotab_v6.2.csv"));) {
        String[] values = null;
        while ((values = csvReader.readNext()) != null) {
          Munro munro = new Munro();
          munro.setName(values[5]);
          munro.setHeight(values[9]);
          munro.setHillCategory(values[27]);
          munro.setGridReference(values[13]);
          listOfMunros.add(munro);
        }
    } catch (IOException | CsvValidationException e) {
        e.printStackTrace();
      }
    listOfMunros.remove(0);
    return listOfMunros;
  }
}
