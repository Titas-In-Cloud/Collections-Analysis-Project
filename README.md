## Assessment 2 - Collections Analysis Project
This program stores, deletes and modifies entries of different types of 
directories.
### Description
Program was created during **CSC1035** module and can be used to store
entries - surname, initials, extension numbers, to three different directories
(Array, Array List, HashMap). It can modify, delete or create new entries, 
analyze the runtime of the entry, deletion and entry lookup methods and return 
the results in txt file.

### Getting Started
Compile the **MainClass.java** file. Input to the ````Terminal````:
````
javac MainClass.java
````
To run the program input to the ````Terminal````:
````
java MainClass.java
````
### Usage
When you run the program you will be taken to user actions input menu. 
Follow messages in the ````Terminal````  to run different functions of
the program. List of available actions:
+ **directory** - sets which directory to initialize for usage.
+ **input** - starts manual input of entries to directory.
+ **deleteName** - deletes object by it's surname.
+ **deleteNumber** - deletes object by it's extension number.
+ **csvIn** - reads CSV file and puts all the entries to the directory.
+ **csvOut** - puts all the directory entries to CSV file and saves it.
+ **table** - returns a table with entries of directory in ASCII format.
+ **analysis** - runs analysis of Array, Array List and HashMap directories methods.
+ **test** - runs tests of Array, Array List and HashMap methods.
+ **exit** - ends the program.

### Testing
Run 'test' function in user input. The test method checks if insertion,
deletion, lookup and updating methods of the directories run without any bugs. 
After computer initializes each method you will see a table in ASCII format 
with resulted directory entries after method initialization.
### License
This project is licensed under the MIT License see the LICENSE.md file 
for details.