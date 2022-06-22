Created by: Cian Martyn
Student ID: G00398276

Table of content

1) Introduction
2) Main Menu
3) Word Cloud Generator
4) Notes
4) List of optional extras
5) References


1. Introduction

This program is to be used for the purposes of creating a word cloud. It allows for both local & URL based clouds to be 
formed. Other variables include the font type, letter type and the number of words to be included in the cloud, up to 100.
I have also inbuilt a list of words for the cloud to ignore and these instructions, so they are available within the program.


2. Main Menu

On running the program, you are presented with 4 options:

1) Word Cloud Generator: The main aspect of the program where you begin to enter the details required for the program
to run.
2) Ignore words list: Displays the ignore words on the console
3) Instructions: Displays these instructions
4) Quit: Exits the program


3. Word Cloud Generator

On selecting Word Cloud Generator, you are brought to a menu option to use either a local file or to use a URL for the word 
cloud.

a) Local file Location: Tested on two Windows machines. Example of file name used is 
C:\Users\username\Desktop\filename.txt
b) URL File Location: Tested on multiple web browsers. Example of URL used is 
http://www2.lawrence.edu/fast/GREGGJ/CMSC150/031Files/Files.html

You are then presented with two different sets of font choices, detailed below.
{Serif, Sans Serif, Dialog, Dialog Input, Monospaced}
{Plain, Bold, Italic, Roman Baseline, Centre Baseline}
Alongside the next choice which gives you a choice of the number of words to display (max 100), this will determine the
how the words are presented.


4. Notes

1) Saved images go to the project folder>bin folder
2) If you wish to add to the ignorewords text file, the file is packaged with the program. Please open this using notepad
    or other .txt editors and save before running the program.
3) The naming convention for the output file is all one word. You can use underscore to link words together
4) Orginally I had planned to have both the file input & URL go to parse(InputStream in) which is in the Parser class,
however I had issues getting the URL abstract File across as the command had a file, directory error which I believe
is due to the use of ("-") which is not applicable for Windows File types. This has left some repetitive code which I
cannot seem to get rid of without breaking the program.
5) For the word cloud, I have left it as a randomly generated word cloud due to your own words about it. The points were
for the code rather than the presentation hence it can look messy.


5. References

https://www.geeksforgeeks.org/difference-between-keyset-and-entryset-method-in-java-map/
https://www.java67.com/2015/01/how-to-sort-hashmap-in-java-based-on.html
https://www.baeldung.com/java-hashmap-sort
https://stackoverflow.com/questions/11481482/how-can-i-generate-a-tag-cloud-in-java-with-opencloud
https://github.com/kennycason/kumo
https://stackoverflow.com/questions/12277461/delete-everything-after-part-of-a-string
https://stackoverflow.com/questions/5528388/java-fileinputstream-using-with-url
https://stackoverflow.com/questions/5200187/convert-inputstream-to-bufferedreader