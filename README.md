# assignment

This is a below assignment I received from a company. No tight deadline was given.

## Task 1 - Analysis, Design, and Architecture

Our customer wants to have a simple application developed. Perform an object-oriented analysis of the given application at the level of UML class and use-case diagrams. Design the architecture of the solution.
The customer's representative has provided us with the following requirements:
1. We want to have a shared contact database within the company.
2. Each contact has attributes such as first name, last name, address, multiple phone contacts, company name, and a longer text as a note.
3. The address consists of street with house number, city, postal code, and in the case of international contacts, also the state.
4. For phone contacts, we want to have a note indicating, for example, the best time to reach them, whether it is for work or home, and similar details.
5. It would be good to be able to have a photo for each contact.
6. In the contact list, we want to be able to search by name, last name, city, and company.

Evaluation of the task.
The UML analytical model and the proposed architecture will be evaluated separately. The model must cover all customer requirements. The class diagram can be implemented at the logical or physical model level for the chosen architecture. When designing the architecture, it is necessary to justify the individual decisions.

https://github.com/Daniel-Capla/assignment/tree/c04dded3685be686e8d9c343bf1f802d89d36514/bootiq-assignments/uml-analysis

## 2. úloha - Fizz Buzz
Algoritmus
Players generally sit in a circle. The first player says the number “1”, and each player says next number in turn. However, any number divisible by X (for example, three) is replaced by the word fizz, and any divisible by Y (for example, five) by the word buzz. Numbers divisible by both become fizz buzz. A player who hesitates, or makes a mistake is eliminated from the game.
Write a program that prints out the final series of numbers where those divisible by X, Y and both are replaced by “F” for fizz, “B” for buzz and “FB” for fizz buzz.
Input example:
X = 2, Y = 7, N = 15
Result from example:
1 F 3 F 5 F B F 9 F 11 F 13 FB 15

https://github.com/Daniel-Capla/assignment/blob/c04dded3685be686e8d9c343bf1f802d89d36514/bootiq-assignments/src/main/java/main.java

## 3. úloha - Producer - Consumer
Create program in Java language that will process commands from FIFO queue using Producer – Consumer pattern.
Supported commands are the following:
•	Add  - adds a user into a database
•	PrintAll – prints all users into standard output
•	DeleteAll – deletes all users from database
User is defined as database table SUSERS with columns (USER_ID, USER_GUID, USER_NAME)
Demonstrate program on the following sequence (using main method or test):
•	Add (1, "a1", "Robert")
•	Add (2, "a2", "Martin")
•	PrintAll
•	DeleteAll
•	PrintAll

Show your ability to unit test code on at least one class.
Goal of this exercise is to show Java language and JDK know-how, OOP principles, clean code understanding, concurrent programming knowledge, unit testing experience.
Please do not use Spring framework in this exercise. Embedded database is sufficient.

https://github.com/Daniel-Capla/assignment/blob/c04dded3685be686e8d9c343bf1f802d89d36514/bootiq-assignments/user-service/src/main/java/org/example/Main.java
