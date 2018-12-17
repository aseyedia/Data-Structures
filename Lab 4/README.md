# Lab 4 - Quick Merge
This project was created for the EN.605.202.81.FA18 Data Structures class taken at Johns Hopkins University.

## Overview
This program is intended to be an implementation of three different types of Quicksort (standard Quicksort, Quicksort 100, Quicksort 50, and Median-of-Three Quicksort), with Quicksort 100 and Quicksort 50 incorporating Insertion Sort to sort subsets of data below its partition threshold, and Natural Merge Sort. The input files were the ones given by the instructors and are either in reverse, random, or ascending order and come in sizes of 50, 100, 500, 1000, 5000, and 10000. The program outputs the console. Stack overflow error frequently occurred in developing this program, as the computer power used in development was not enough to handle writing to file.

Two avenues were considered for the project. Initially, I tried to store all the data values in a two-dimensional array and then sort them in each respective array element. When I got stack overflow error, I tried to read, sort and write each file one at a time. Even though that didn't prove to be more effecive at preventing stack overflow error, I committed to it anyway. See version history for details.

## Requirements
- Java version 7 or 8
- JDK 1.7 or 1.8
- IDE, either IntelliJ or Eclipse preferred

## Documentation
Refer to `index.html` in the doc folder for more information.

## Author
Arta Seyedian


