# UsrDBLogInSanitizeValidateHash
DB creat user and log in. Uses sanitation and validation through regEx. Hashed passowrd through BCrypt

Project 2 Secure Software Development 

Project 2: SQL Safety and Cryptography

In Java write a program that does the following:

1. It allows two input choices:

    Sign up with user name and password
        The database needs to be checked if there already is a user with this name. In this case reject.
        The password must be at least 10 characters long, and only consist of lowercase and uppercase letters, digits and the symbols &,%,$,#. At least one character of each of these four categories must be in the password.
        The password needs to be hashed with BCrypt. Use the code sample provided in the JCA project and discussed in class.
        Do not hash or encrypt the user name!
    Log in with a known user name and password
        The database checks for the occurrence of the user name and validates the stored hash
        The program validates the credentials and prints a "welcome" or "rejected" message.

 

Submission guidelines

    Just drop the Eclipse project into the dropbox.
        Source code
        SQL script to create the DB
            The script must define a database named Credentials and must be accessed by the user "abc" with password "abc". I will set up my database accordingly.
            The script should not populate the DB. That doesn't make sense unless you manually compute hashes.
            I will run the creation script as is against my DBMS. If it fails, I'll stop grading. Note that it needs to work correctly even if a DB with this name is already present.
            Look at the snippet below!
            I will attempt to a) create a user with a non-conforming password (my discretion) b) create one user with a conforming password c) create one user already in the DB and try to d) log in as the user just created and e) as another user not in the DB.
        SQL script to show the current state of the DB
            It should be of the form SELECT * FROM Credentials. I need that to see if the data is stored properly.

 

CREATE DATABASE IF NOT EXISTS Credentials;
USE Credentials;
DROP TABLE IF EXISTS Credentials;

CREATE TABLE Credentials ( ...

 
Rubric
P3 (1)
P3 (1)
Criteria 	Ratings 	Pts
This criterion is linked to a Learning Outcome Submission correct incl SQL files
	
	
10.0 pts
This criterion is linked to a Learning Outcome Creation script runs w/o errors
	
	
10.0 pts
This criterion is linked to a Learning Outcome SELECT script runs w/o errors
	
	
10.0 pts
This criterion is linked to a Learning Outcome Rejects non-conforming password during sign-up
	
	
10.0 pts
This criterion is linked to a Learning Outcome Rejects duplicate user during sign-up
	
	
10.0 pts
This criterion is linked to a Learning Outcome Accepts and stores new user with conforming password
	
	
20.0 pts
This criterion is linked to a Learning Outcome Finds and welcomes stored user
	
	
15.0 pts
This criterion is linked to a Learning Outcome Rejects unauthorized user
	
	
15.0 pts
Total Points: 100.0
Submission
Submitted!
Mar 27 at 6:28pm
Submission Details
Download UserDatabase-Project2.tar.xz
Comments:
No Comments

