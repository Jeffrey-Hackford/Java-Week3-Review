# _Hair salon_

#### _Hair salon application, 5-06-2016_

#### By _**Jeffrey Hackford**_

## Description

_This app will allow users to input Stylist names and assign them clients_

## Setup/Installation Requirements

* - Clone from github
* - clone database from sql file in project folder
*    - run the terminal command "CREATE DATABASE hair_salon;"
*    - then run the command "psql hair_salon < hair_salon.sql"
*   Or manually set up the database by running the following commands:
*    - CREATE DATABASE hair_salon;
*    - CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylist_id int);
*    - CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);
* - run postgres in terminal
* - execute 'gradle run' in command line
* - in a web browser navigate to localhost:4567

## Known Bugs

_no known bugs at this time_

## Support and contact details

Jeffrey.hackford@gmail.com

## Technologies Used

_Java_
_Spark_
_Velocity_
_Gradle_
_Postgres_
_Sql2o_

### License

*Mit License*

Copyright (c) 2016 **_Jeffrey Hackford_**
