    The purpose of this program is to take a large csv file and parse the data into two different categories
 based on blank spaces located on the lines. The data from the csv file is also created into an sqlite.

    To get the application to worker, programmers must insert the name of the csv file they wish to
 parse (located on lines 25 & 75). Once thatis completed, all the programmer has to do is simply run
 the program.
 
    If I'm being honest, I learned a lot with this coding assignment. Before this, I did not have any
 experience using sqlite, especially through java. I did have experience with csv files in Java, but not
 as much as this assignment had needed from me. The day I had received this assignment I had sat down and 
 just did all the research I could to make sure I understood the program, as well as what was being asked
 of me. Once I felt I had a good start, I began creating every method I believed I would need. This helps
 mesee what all I will need. I wrote separator, which is tasked with with taking that file and separating it 
 line by line to make it easier to detect which ones are considered "bad"(missing information). I began to
 work on counter after this, which was assigned with reading the lines and being able to calculate three
 scores: total, ones with all the information, and the ones missing data. At the very end the method
 prints out each scores.
 
    For the design of the program, I did my best to adhere to the OOD guidelines. Instead of creating one
 big method I broke up my project into several smaller ones to help anyone who may look at my code 
 understand the code. Names of variables were also kept simple to let the reader know exactly what they are
 used for. 
 
    This program was created assuming that MS3 would be looking for an efficient way to sort through big
 data. This code was designed to withstand large amounts of data, and be able to read it line by line and 
 get rid of the unwanted data, which is based on the user's interest. 