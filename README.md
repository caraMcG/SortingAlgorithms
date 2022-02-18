# SortingAlgorithms

Implementation of 6 sorting algorithms: bubble, insertion, selection, merge, quick and shell sort.
Figures from polygon.txt are compared with the following rules specified by the user: 
  - Two figures compared by their base area or
  - Two figures compared by their height or
  - Two figures compared by their volume

This program reads one of the below text files from the res folder and adds them to an array. 
The first value in the file containes the number of figures in that file. 

  - polyfor1.txt
  - polyfor3.txt
  - polyfor5.txt

To use this application, open the command line and use 'f'<file name>, compare type 't' and sort type 's' as parameters.

Compare Types 
  - v volume
  - h height
  - a base area

Sort Type 
  - b bubble
  - s selection
  - i insertion
  - m merge
  - q quick
  - z shellsort

Example Command Line argument
  
java -jar SortMe.jar -fpolyfor1.txt -Tv -Si
