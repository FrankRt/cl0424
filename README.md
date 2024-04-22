For XXXXX company exercise.

Think of this repository as in implementation of the provided Programming Demonstration as say it would be per a user story.

There is much left regarding implementation of course, but that's the idea in an agile scrum story. I chose to use Spring Boot, but not Spring Boot Web as APIs weren't specified in the document. However, if future stories require such, that shouldn't be a major change.

I chose to use Spring Boot services and an H2 database supported by Spring Data JPA. The services of course use the JPA repositories, but services only invoke _other_ services. I believe this gives this implementation the greatest decoupling. Services simply invoke other service methods, and don't care there's an RDB behind the scenes. Likewise if a different DB (even non-RDB) is chosen for implementation, this would have no effect on the service invocations.

I implemented 3 DB tables: TOOL, TOOL_TYPE, HOLIDAY. TOOL and TOOLTYPE are (with this implementation) are "static" in that the data can be pre-loaded at runtime. HOLIDAY is "lazy loaded" per year of request. When a start date is given, the HolidayService looks to see if the 2 holidays for the year are already in the table, and if not adds 2 rows to the table for the given year. Note that we won't repeat holidays for a given year in HOLIDAY.

I refrained from implementing much more functionality, because just as in user stories, we don't like to see code "bloat" or "scope creep". That's what user stories are for: to break code down into deliverable and buildable systems. So we wont' see persistence for Rental Agreements, nor do we check to see if a tool is in use before another rental request for the tool comes in, nor do we provide for multiple tools of the same tool code. These are all things that can be implemented in future stories if so desired.

I implemented this code in a quasi-TDD manner. So most everything is JUnit tested. In the real world, code reviews or code coverage tools would tell us where there are deficiencies. I also didn't need to use mocks for the database as the H2 in-memory database is populated and can be queried right in the JUnit tests. Nevertheless there may be some JUnit tests which are lacking.

Per the document tests, I did those in the command line runner of the main spring boot application, but also added a "JUnit test" to display the 6 scenarios' output. So the tests can be executed one of two ways:
1. Simply running the Spring Boot main.
2. Executing the EndToEndTests in src/test/java.
