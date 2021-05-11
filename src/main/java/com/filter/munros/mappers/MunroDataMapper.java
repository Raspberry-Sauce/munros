package com.filter.munros.mappers;

import com.filter.munros.models.Munro;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MunroDataMapper {

  private static final String EMPTY_STRING = "";
  private static final String LOCAL_PATH_NAME = "/Users/din06/IdeaProjects/munros/src/main/resources/munrotab_v6.2.csv";

  public List<Munro> retrieveMunroData() {

    List<Munro> listOfMunros = new ArrayList<>();
      try (CSVReader csvReader = new CSVReader(new FileReader(LOCAL_PATH_NAME));) {
        String[] munroRecord = null;
        csvReader.readNext();
        while ((munroRecord = csvReader.readNext()) != null) {
          if (munroRecord[0] != null && !munroRecord[0].equals(EMPTY_STRING)){
            Munro munro = new Munro();
            munro.setName(munroRecord[5]);
            munro.setHeight(Float.valueOf(munroRecord[9]));
            munro.setHillCategory(munroRecord[27]);
            munro.setGridReference(munroRecord[13]);
            listOfMunros.add(munro);
          }
        }
    } catch (IOException | CsvValidationException e) {
        e.printStackTrace();
      }
    return listOfMunros;
  }
}
