# Munros API
A sorting system for a dataset of Munros

#Input

The Munro Filter/Sorter API takes in a JSON formatted query (found below), depending on what parameters of the query are present, a dataset stored in a csv file will be converted to 
a full list of Munro objects which are then filtered or sorted and returned to the user as a list of Munros containing the Name, Height, Category and Grid Ref.

#Query

curl --location --request POST 'http://localhost:8080/munro/sortBy' \
--header 'Content-Type: application/json' \
--data-raw '[
  {"queryType":"byCategory", "sortBy": "MUN"},
  {"queryType":"sortByHeight", "sortBy": "asc"},
  {"queryType":"alphabetically", "sortBy": "desc"},
  {"queryType":"byTop", "value": "22"},
  {"queryType":"filterByHeight", "sortBy": "max", "value": "28"}
]'

The Query can be edited to provide different functionality

BY CATEGORY: 
  The sort by field can either be left empty or take in "MUN" or "TOP"

SORT BY HEIGHT:
  The sort by field requires either "asc" or "desc"

ALPHABETICALLY:
  The sort by field requires either "asc" or "desc"

BY TOP:
  The value field requires an integer value, which will return that many records from the dataset

FILTER BY HEIGHT:
  The sort by field requires either "max" or "min", and the value field requires an integer. 