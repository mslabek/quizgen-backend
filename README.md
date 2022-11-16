# QuizGen - Backend

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](http://makeapullrequest.com)

Backend application for generating customizable quizzes.

Repository of the frontend application is available [here](https://github.com/mslabek/quizgen-website).


## 📖 Table of Contents

- [General Information](https://github.com/mslabek/quizgen-backend#-general-information)
- [Features](https://github.com/mslabek/quizgen-backend#-features)
- [Tech stack](https://github.com/mslabek/quizgen-backend#-tech-stack)
- [Project status](https://github.com/mslabek/quizgen-backend#-project-status)
- [License](https://github.com/mslabek/quizgen-backend#%EF%B8%8F-license)

## 📝 General Information

Most available quiz application are dealing with hard-coded quizzes or generate quizzes for a specific topic. This application's goal is to be able to generate quizzes dynamically and not be limited to a certain subject. This provides many challenges such as operating on a very abstract data model (to be topic-agnostic) and having to deal with linguistics (to generate question phrases that are grammatically correct).

The main idea is that topics (for example country) contain concrete items (for example Poland). These items possess certain types of qualities (for example countries have capitals) and concrete items have concrete qualities of these types (for example the capital of Poland is Warsaw). Based on this notion, a question contains a known property of some item and asks for another property of the same item. For example when we ask "What is the capital of Poland?" - we ask for property of type Capital for an item, which property of type Name is Poland.

This data model may seem quite weird, but it allows for generating unique quizzes, for example asking "What is the coat of arms of a country which capital is Warsaw?" or "What is the dynasty of a Polish ruler who ruled in years 1238–1241?".

## ✨ Features

- Generating and solving highly customizable quizzes
- Retrieving the data on which the quizzes are based on from a Postgres database
- Generating question phrases based on grammatical properties and templates
- Stateful API for solving quizzes
- Points system for users answers 
- Basic form validation
- Cookie authentication


## 🛠 Tech Stack

Most important technologies used:

- Spring Boot
- Build tool: Gradle
- Documentation tool: Swagger
- Database: Postgres
- Lombok
- Validation: Hibernate Validator
- Docker

## 🌱 Project Status

Project is in development.

## ⚖️ License

This project is open source and available under the [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0).
