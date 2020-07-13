# Wildlife Tracker
Wildlife Tracker is an application that allows Rangers to track wildlife sightings in the area.
It records an animal sighting from the name  tho the time of sighting. It also allows
recording of Endangered species'  sighting including their age and health status. 

## Author's Name
Linda Tonui

## Technologies Used
- HTML
- CSS
- Terminal
- Git
- Vs Code
- Intelli-J
- Spark
- Gradle
- Maven
- Postgress

## Bugs And Errors
- No known Bugs

## Setup Instructions
- Clone  the Repository
- Move into directory then run `cd Wildlife-Tracker`
- Rebuild the Project Using Intelli-J
- Open terminal command line then navigate to the root folder of the application.
- Run `gradle run` command.
- open `http://localhost:4567/` in your browser.

## Setting Up Database
In PSQL,
- CREATE DATABASE wildlifetracker;
- CREATE DATABASE wildlifetracker_test WITH TEMPLATE wildlifetracker.
- CREATE TABLE animals(id serial PRIMARY KEY,name VARCHAR,location VARCHAR);
- CREATE TABLE endangered(id serial PRIMARY KEY,location VARCHAR ,name VARCHAR,health VARCHAR,age INTEGER);
- CREATE TABLE rangers(id serial PRIMARY KEY,name VARCHAR,email  VARCHAR)