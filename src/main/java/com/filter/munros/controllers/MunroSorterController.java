package com.filter.munros.controllers;

import com.filter.munros.implementation.MunroSorterImpl;
import com.filter.munros.mappers.MunroDataMapper;
import com.filter.munros.models.MunroQuery;
import com.filter.munros.models.Munro;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/munro")
public class MunroSorterController {

  private MunroSorterImpl munroSorter = new MunroSorterImpl();
  private MunroDataMapper munroDataMapper = new MunroDataMapper();


  @PostMapping("/sortBy")
  @ResponseBody
  public List<Munro>
  filterData(@RequestBody List<MunroQuery> query){
    List<Munro> mappedMunroData = munroDataMapper.retrieveMunroData();
    return munroSorter.filterOrSortMunroData(query, mappedMunroData);
  }


}
