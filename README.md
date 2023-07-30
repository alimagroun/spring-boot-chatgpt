Using OpenAI ChatGPT APIs in Spring Boot

Description

This project demonstrates how to integrate OpenAI's ChatGPT API with a Spring Boot application to create an interactive chatbot. The chatbot leverages OpenAI's GPT-3.5 Turbo model for natural language processing, allowing it to engage in interactive conversations, answer questions, and generate contextually relevant responses.

Requirements

Java 17+

Configuration

Before running the application, you need to set your OpenAI API key as an environment variable named OPENAI_API_KEY.

Testing the App with Curl

You can test the chatbot by sending a prompt via a GET request using curl:

curl "http://localhost:8080/chat?prompt=Hello"

Replace http://localhost:8080 with the actual URL where the application is running, and modify the prompt parameter to interact with the chatbot.

Contact

For any inquiries or feedback, please contact at ali.magroun1@gmail.com.
