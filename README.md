# flight-service-exercise

## Prequisites

 - Java 1.8

## Building and running

 - Execute the following from command line
 
```bash
mvnw clean install spring-boot:run
```

## Assumptions and Comments

 - Only implemented GET portion of REST api, as our mock only allows read access and the behavior of other methods was not specified.
 - `/api/flights` uses the parameters `airlineCode` and `departureDate` to filter in flights based on the associated fields.  Dates are given in `MM/dd/yyyy` format.
     - See `ApplicationTests.java` for api usage examples.
 - Created 4 unit tests to verify filtering.  Asserts are based on pre-calculated expected number of results based on the mock API results.  With more time I would have made the assertions actually check the values of the returned ApiFlight objects to verify.
  - In a production environment I would create an `IFlightService` Interface which the current `FlightService` would implement as a mock object.  A theoretical production `FlightService` would also implement that interface but retrieve items from a database or production API.
  - The cities mock API did not seem to be necessary to implement the requirements, so I didn't implement anything that requests information from it.  However, I created a `City` class and would have created a `CityService` similar to the `FlightService` if it were needed. 