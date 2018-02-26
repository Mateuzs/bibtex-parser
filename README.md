# BibTexParser
Parser in Java, converts BibTex file to object structure, allows to filter and present data.

## Getting Started

The simplest way to try this app is download the jar file and run it from you command line.

Basic option this app can take: 


-a `<`name`>` : takes an author name You want to filter by  
-f <address> : takes the bibtex file address  
-c <category> : takes a category You want to filter by  
-h : shows help  
-o <option_number> : takes an option of presentation parsed file:  
  1 - shows the whole parsed file  
  2 - filters the file by author name  
  3 - filters the file by category  


You need to give the program at least file address, sign to draw the result and option of presentation parsed file, for example:

```
java -jar BiBTexManager.jar -f BiBTexManager/src/main/bibFileExample.txt -s \* -o 1
```
Above example parses the file and shows every record (option 1) in the table (drawn with sign "*") 


Filtering by author name: 

```
java -jar BiBTexManager.jar -f BiBTexManager/src/main/bibFileExample.txt -a "Paul Pot" -s \* -o 2
```

Filtering by more than one author name:

```
 java -jar BiBTexManager.jar -f BiBTexManager/src/main/bibFileExample.txt -a "Paul Pot" -a "Leslie A. Aamport" -s \* -o 2
```

Filtering by category:

```
java -jar BiBTexManager.jar -f BiBTexManager/src/main/bibFileExample.txt -c article -s \* -o 3
```

Filter by more than one category:
```
java -jar BiBTexManager.jar -f BiBTexManager/src/main/bibFileExample.txt -c article -c booklet -s \* -o 3
```


You can use above examples with "bibFileExample.txt" inside this repository.
