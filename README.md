
# Software Fundamental project
## Doggie Daycare


Helen Gardner

## Introduction

The project spec was to create a CRUD application with the utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.
Including but not limited to:
 * Project management using a Jira board, use cases and tasks needed to complete the project.
 * Clear Documentation from a design phase describing the architecture you will use for your project.
 * A relational Database for storage
 * A functional application created in the OOP language, following best practices and design principles
 * The application must have a functioning front-end website and integrated API.
 * A full test suite on the back-end with an acceptable level of coverage.
 * Code integrated into a version control system

### Technology Stack and pre-requisites for deployment

The application was created using the following stack, including peripherals:
* Project management - Jira
* Database - mySQL
* Backend programming - Java (Eclipse IDE)
* Frontend programming - JavaScript, HTML and CSS
* Integration Tests - MockMVC
* Version control - Git


### Planning and Design

My project idea was to create a register of dogs for a Doggie daycare, consisting of some of the data which they would capture.

The first step was to create a Jira board with the requisite user stories, these were organised into three epics:
* Backend Architecture
* Frontend Architecture
* Styling and Documentation

PICTURES

These were then done in two sprints, sprint goal one consisting of mostly laying out the functional architecture, with sprint two consisting of the documentation and styling


Here is the basic design I envisioned.

PICTURE

## Version control

Two repositories were created, one for the backend and testing, and one for the frontend.
Both were managed using the dev-feature branch method.
My repositories were linked with Jira using smart commits so the version control could be tracked via the project management side.

https://github.com/hellsgard/backend-dog-day

https://github.com/hellsgard/frontend-dogday

Some images showing the progression of both repos:

PICTURES


### Databases 

Production Database using mySQL

PICTURES

H2 database for testing
Schema and test Data was included via the backend to create the table and insert an entry for testing

PICTURES


### Backend 
The back end of thee project was completed in Java, using a Spring boot framework.
The dependencies and class structure can be seen here:

UML PICTURE

ECLIPSE PICTURE

### Testing

Integration testing was done on the back end with MockMVC to create a mocked controller class.
7 tests were run on the main folder covering all queries with a 98.3% coverage on src/main/java

TEST COVERAGE PICTURE


## Frontend

The Front end was built using Javascript, HTML and CSS.
Bootstrap was used for the grid layout, cards and the forms.

Progression from start to end of the week:


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Author

* **Helen Gardner** - *Full project* - [hellsgard](https://github.com/hellsgard)

## Acknowledgments

* Thankyou to Jordan and Pawel for their help with issues



