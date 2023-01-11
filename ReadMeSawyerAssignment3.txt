a. Which hash function are you using? and where did you get the hash function from? 


“String Hashing Using Polynomial Rolling Hash Function.” GeeksforGeeks, 27 Sept. 2021, https://www.geeksforgeeks.org/st
ring-hashing-using-polynomial-rolling-hash-function/#:~:text=String%20hashing%20is%20the%20way,strings%20having%20the%20
same%20hash).

https://www.geeksforgeeks.org/string-hashing-using-polynomial-rolling-hash-function/#:~:text=String%20hashing%20is%20the
%20way,strings%20having%20the%20same%20hash).




b. What are the advantages and disadvantages of Hashing? Give one application of 
Hashing and give details about that application.  


Hashing is great because it can be used to generate unique codes for any input. Hashing is also a very time efficient
process. The problems with hashing are that it often times uses excess space in order to reduce collisions. Collisions
are another problem with hashing and that you have to handle them when two objects have the same hash to the same index.


c. Amount of time you spent on implementing the assignment. Challenges you faced 
while implementing the assignment? How did you overcome these challenges?  


I spent around 4 to 6 hours implementing this assignment. Some challenges I faced with this assignment were handling
collisions, getting the time that the program took, and finding a good hash function.


I handled the hash function originally by trying to design my own off of ideas taken from Java’s string hashcode but
when that ultimately did not work I moved to the internet and found my hash function that I used. The time problem was
easy except for the issue where the JVM would inflate the time that one of the two so what I did to get around this was
do one iteration of the file to get around that. I originally was not handling collisions but I resorted to linear
probing with a load factor of 12.5%  so I know that I am running better than log n.