# League Champions

## About the project

This is a web application for people that are interested in League of Legends.It has details about in-game characterts, matches and users.
The frontend and the backend is separated into different repositories.The frontend repository is here: https://github.com/zsomborr/league-frontend-react

## Motivation

As we like the game *League of Legends*, we wanted to make a project related to it. We wanted to make something that can be usefull for the players, so our data comes from official API-s that refreshes continuously.

## Technologies

* __Java__ as base backend programming language.
* __PostgreSQL__ for storing and handling data.
* __Java Persistence API__ for communicating with the database.
* __Spring Boot__ as a backend framework.
* __Javascript__ as base frontend programming language.
* __React__ as a frontend framework.

## Features

* You can read the latest news from *Hacker News*.
* You can see the characters and its stats on a detail page.
* You can see the currently free characters.
* You can filter characters by their tags.
* You can check a user's match history.
* You can log in and then mark a character as your favourite or add comments to news.

## Installation --> frontend

1. Open a terminal in your IDEA and type *npm ci*. This will install all the packages you need for the application to run.

2. Start the application with *npm start*.

## Installation --> backend

1. Create environmental variable with name *APIKEY*. The value should be an official X-Riot-Token that you can get from this site: https://developer.riotgames.com
	
2. Set environmental variables from database creditentials:
    *DB_NAME
    *USERNAME
    *PASSWORD

3. Start backend application and enjoy! :)

## How to use

You can reach the frontend server on localhost:3000. It will communicate with the backend which is on localhost:8080.

## Licence

MIT © Zsombor Kincses and Bence Bódis
