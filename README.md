# ApiTest - Android REST API Integration with Retrofit

## Overview
**ApiTest** is an Android project built with **Java** that demonstrates how to integrate a REST API with a mobile application. This project covers sending API requests using different HTTP methods (GET, POST, PUT, DELETE) and handling responses effectively. The API integration is implemented using **Retrofit**, a powerful and easy-to-use HTTP client for Android.

## Features
- **REST API Integration** with Retrofit
- **Sending Requests** (GET, POST, PUT, DELETE)
- **Receiving and Parsing Responses**
- **Displaying Data in the UI**
- **Error Handling & Logging**
- **Simple and Clean Code Structure**

## Technologies Used
- **Android (Java)**
- **Retrofit 2** (for API calls)
- **Gson** (for JSON parsing)
- **RecyclerView** (for displaying data)
- **LiveData & ViewModel** (for data management)
- **Material Design UI Components**

## API Endpoints Demonstrated
### Example: User Management API

#### 1. Get All Users
**GET** `/users`
- Fetches a list of all users
- Implemented using `Retrofit` in `UserService.java`

#### 2. Get a Single User
**GET** `/users/{id}`
- Fetches details of a specific user

#### 3. Create a New User
**POST** `/users`
- Sends a request to create a new user
- Example JSON Request Body:
  ```json
  {
    "name": "John Doe",
    "email": "johndoe@example.com"
  }
  ```

#### 4. Update an Existing User
**PUT** `/users/{id}`
- Updates user details

#### 5. Delete a User
**DELETE** `/users/{id}`
- Deletes a user from the database

## Project Structure
```
ApiTest/
│-- app/
│   ├── java/com/example/apitest/
│   │   ├── api/         # Retrofit API Service
│   │   ├── model/       # Data Models (POJOs)
│   │   ├── view/        # UI Components (Activities, Fragments)
│   │   ├── viewmodel/   # Business Logic (ViewModel)
│   ├── res/layout/      # XML Layout Files
│   ├── res/values/      # Strings, Colors, Styles
```

## Installation and Setup
1. **Clone the Repository**
   ```sh
   git clone https://github.com/your-repo/apitest.git
   ```

2. **Open in Android Studio**
   - Open the project in **Android Studio**

3. **Add Dependencies** (if not already added)
   ```gradle
   implementation 'com.squareup.retrofit2:retrofit:2.9.0'
   implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
   ```

4. **Run the Application**
   - Connect an Android device or emulator
   - Press `Run` ▶️ in Android Studio

## How to Use
- Modify the `BASE_URL` in `RetrofitClient.java` to match your API.
- Use `UserService.java` to make API calls.
- Check `MainActivity.java` for the UI implementation.

## Contributing
Feel free to contribute by submitting pull requests to enhance the project.

## License
This project is licensed under the **MIT License**.
