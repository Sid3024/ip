# Sid Chatbot user guide
Sid is a chatbot that helps users keep track of their daily tasks. It includes features such as adding and deleting tasks, listing and automatically saving their tasks, marking their tasks and done/not done, and keyword based searching for their tasks.

# Getting started
## Steps to launch program
1. Download the jar file from this github page under releases
2. Copy the jar file to a folder of your choice
3. Open a terminal and go to that folder
4. Run `java -jar ip.jar`
5. Type in commands to perform actions

# Features
## Overview
This chatbot enables features including adding and deleting tasks from the list, marking and unmarking tasks as done, listing all tasks or searching for a subset of tasks (keyword based). As this is a CLI program, all features are accessed via commands. 

## Auto Saving
This chatbot automatically saves the list of tasks in a text file at `data/sid.txt`. The list is automatically loaded upon program startup, and re-saved every time any action that modifies the list is made.

## Commands
### Guidelines
Ensure you follow the commands exactly, such as spelling command words and flags correctly, do not use capital letters for the command words and flags, and use the correct flags and in the correct order for appropriate commands.
Ensure you give an appropriate input for command words and flags that require one; do not give an empty input.
All forms of null space (‘ ‘, ‘\n’, ‘\t’ etc) will be removed in processing.
If you give a command of the wrong format, an error message will be displayed, showing both your input and an explanation of why its format is incorrect.

## Adding tasks to the list
This chatbot enables the user to input 3 types of tasks: to dos, deadlines and events.
### todo DESCRIPTION
Adds a todo task with its description.
Example: `todo Math homework`
Output: 
```
______________________________
added: [T][ ] Math homework
You have 1 tasks in your list currently
______________________________
```
*Possible errors*
Empty description

### deadline DESCRIPTION /by DUEAT
Adds a deadline task with description and the metadata due at (when it’s due).
Example: `deadline math assignment /by monday`
Output:
```
______________________________
added: [D][ ] math assignment (by: monday)
You have 2 tasks in your list currently
______________________________
```
*Possible errors*
1. Empty description
2. Missing flag /by
3. Missing DueAt

### event DESCRIPTION  /from STARTTIME /to ENDTIME
Adds an event task with description and relevant metadata start time and end time.
Example: `event cs test /from mon 10am /to 11am`
Output:
```
______________________________
added: [E][ ] cs test (from: mon 10am to: 11am)
You have 3 tasks in your list currently
______________________________
```
*Possible errors*
1. Empty description
2. Missing flags /from and /to
3. Flags in the wrong order
4. Empty metadata fields for /from and /to

## Marking tasks on the list
The chatbot enables users to mark (and subsequently unmark) tasks on the list as done.
### mark INDEX
Marks the INDEX-th item in the list as done.
Example: `mark 1`
Output:
```
______________________________
Nice! I've marked this task as done:
[T][X] Math homework
______________________________
```
*Possible errors*
1. Trying to mark using task name
2. INDEX is out of range (less than 1, or larger than the size of the list)
3. INDEX is not an integer
4. Missing INDEX

### unmark INDEX
Marks the INDEX-th item in the list as NOT done.
Example: `unmark 1`
Output:
```
______________________________
Ok, I've marked this task as not done yet:
[T][ ] Math homework
______________________________
```
*Possible errors*
1. Trying to unmark using task name
2. INDEX is out of range (less than 1, or larger than the size of the list)
3. INDEX is not an integer
4. Missing INDEX

## Deleting tasks from the list
The chatbot enables users to delete items from the list by index. If you are unsure of the index of a task, you may use the list command to check (see later).
### delete INDEX
Deletes the INDEX-th item from the list.
Example: `delete 1`
Output:
```
______________________________
deleted: [T][ ] Math homework
You have 2 tasks in your list currently
______________________________
```
*Possible errors*
1. Trying to delete using task name
2. INDEX is out of range (less than 1, or larger than the size of the list)
3. INDEX is not an integer
4. Missing INDEX

## Viewing items in the list
This feature enables the user to view the tasks in the list, either all at once or search for a specific subset using keyword-search.
### list
Lists all tasks in the list, in order of insertion.
Example: 
`list`
 Output:
```
______________________________
1.[D][ ] math assignment (by: monday)
2.[E][ ] cs test (from: mon 10am to: 11am)
______________________________
```
### find KEYWORD
Lists all tasks in the list whose description contains the keyword.
Example:
`find math`
Output:
```
______________________________
1. [D][ ] math assignment (by: monday)
______________________________
```
*Possible errors*
1. Empty KEYWORD field

## Exiting the program
### bye
Exits the program.
Example:
`bye`
Output:
```
______________________________
 Bye. Hope to see you again soon!
______________________________
```

## Command Summary Table
| Action | Format |
|------|------|
| Add to do task | `todo DESCRIPTION` |
| Add deadline task | `deadline DESCRIPTION /by DUEAT`|
| Add event task | `event DESCRIPTION  /from STARTTIME /to ENDTIME` |
| Mark task | `mark INDEX` |
| Unmark task | `unmark INDEX` |
| Delete task | `delete INDEX` |
| list tasks | `list` |
| Search for tasks | `find KEYWORD` |

# Example Run Through
```
______________________________
Hello! I'm Sid
What can I do for you?
______________________________
event math seminar /from monday 1pm /to 3pm
______________________________
added: [E][ ] math seminar (from: monday 1pm to: 3pm)
You have 3 tasks in your list currently
______________________________
list
______________________________
1.[D][ ] math assignment (by: monday)
2.[E][ ] cs test (from: mon 10am to: 11am)
3.[E][ ] math seminar (from: monday 1pm to: 3pm)
______________________________
mark 2
______________________________
Nice! I've marked this task as done:
[E][X] cs test (from: mon 10am to: 11am)
______________________________
mark 1
______________________________
Nice! I've marked this task as done:
[D][X] math assignment (by: monday)
______________________________
list
______________________________
1.[D][X] math assignment (by: monday)
2.[E][X] cs test (from: mon 10am to: 11am)
3.[E][ ] math seminar (from: monday 1pm to: 3pm)
______________________________
unmark 1
______________________________
Ok, I've marked this task as not done yet:
[D][ ] math assignment (by: monday)
______________________________
list
______________________________
1.[D][ ] math assignment (by: monday)
2.[E][X] cs test (from: mon 10am to: 11am)
3.[E][ ] math seminar (from: monday 1pm to: 3pm)
______________________________
find math
______________________________
1. [D][ ] math assignment (by: monday)
2. [E][ ] math seminar (from: monday 1pm to: 3pm)
______________________________
bye
______________________________
 Bye. Hope to see you again soon!
______________________________
```