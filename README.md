# Android LinkedIn Clone

## Description

This is an Android application clone of LinkedIn, featuring essential functionalities including signup and sign-in. The app uses SQLite for local storage of user credentials and SharedPreferences to manage app state (e.g., first-time startup and login status). Firebase is integrated to fetch and display content on the home feed.

## Features

- **Signup and Sign-In:**
  - Users can create a new account or sign in with an existing one.
  - Credentials are securely stored using SQLite.

- **User Management:**
  - SharedPreferences is used to check whether the user is starting the application for the first time and to manage login state.

- **Home Feed:**
  - Content is fetched from Firebase and displayed on the home feed.
  - Each feed item includes a username, date, and content.

## Architecture

- **SQLite Database:**
  - Stores user emails and hashed passwords for authentication.

- **SharedPreferences:**
  - Manages app state, including whether the user has started the application for the first time and login status.

- **Firebase:**
  - Provides real-time content updates for the home feed, including user posts.

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/mehboob14/LinkedIn_Clone.git
