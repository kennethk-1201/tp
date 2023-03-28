---
layout: page
title: User Guide
---

# 1. What is SudoHR?

SudoHR is a **desktop app specially catered for HR professionals in managing employees, departments and leaves data,
optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface
(GUI). If you can type fast, SudoHR can get your HR management tasks done faster than traditional GUI apps.

# 2. Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

# 3. Features

There are 3 main types of data in SudoHR:
* Employees
* Departments
* Leaves

SudoHR allows you to manage these components by:
1. Creating, updating, listing and deleting of the 3 data types.
2. Adding/Removing employees in departments/leaves.
3. Applying different filters on the data.

<div markdown="span" class="alert alert-danger">**WARNING:**
SudoHR can only hold up to 10,000 employees, 10,000 departments, 10,000 leaves
and 10,000 tags! Exceeding this limit will result in slower performance or unforeseen
problems.
</div>

--------------------------------------------------------------------------------------------------------------------

# 4. Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `sudohr.jar`.

1. Copy the file to the folder you want to use as the _home folder_ for your application.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar sudohr.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

# 5. Notations

[//]: # (Explain notations used in the UG)

--------------------------------------------------------------------------------------------------------------------

# 6. Quick Reference Guide

## 6.1. Layout

[//]: # (<-- Insert labelled UI here -->)

## 6.2. Key definitions

[//]: # (GENERAL FORMAT OF DATA TYPE DEFINITION:)

[//]: # (1. Explain big idea)
[//]: # (2. Explain fields)
[//]: # (3. Explain constraints)

### 6.2.1. Employee

[//]: # (To be done by Andre)
An employee represents an employee in your company.

### 6.2.2. Department

A department is a group for employees. A department can have many employees and
an employee can be in many departments.

Every employee in a department must be unique.

The following attributes are stored for each department:
1. Department Name

Departments are unique by name and case-sensitive. You cannot add more than one
department of the same name.

### 6.2.3. Leave

[//]: # (To be done by Jer En)
A leave can be taken by many employees.

### 6.2.4. Prefixes

[//]: # (Explain prefixes in the command and their corresponding placeholders)

Prefixes are delimiters to differentiate between different types of input.

<div markdown="span" class="alert alert-primary">**NOTE:**
There is currently no prefix for **KEYWORD** and **OLD_DEPARTMENT_NAME**.
</div>

| Prefix | Placeholder                |
|--------|----------------------------|
| id/    | ID                         |
| n/     | NAME <br/> DEPARTMENT_NAME |
| p/     | PHONE_NUMBER               |
| e/     | EMAIL                      |
| a/     | ADDRESS                    |
| t/     | TAG                        |
| g/     | DATE                       |
| eid/   | EMPLOYEE_ID                |

### 6.2.5. Placeholders

[//]: # (List placeholders in the command)
| Placeholder             | Corresponding Flag | Format                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
|-------------------------|--------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **ID**                  | id/                | ID is the unique identifier for an employee. Leading zeroes will automatically be removed. <br/> It has the following constraints: <li> Must be a positive integer </li> <br/> Valid Examples: <li>1</li> <li>100</li> Invalid Examples: <li>Bob</li> <li>0</li> <li>-1</li>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| **NAME**                | n/                 | NAME represents the name of an employee. <br/> It has the following constraints: <li> It must only contain hexadecimal characters </li> <li> Cannot be blank </li> <br/> Valid Examples: <li>Kenneth</li> <li>Bob Lim</li> Invalid Examples: <li>Bob*</li> <li>1Alice</li>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| **PHONE_NUMBER**        | p/                 | PHONE_NUMBER represents the phone number of an employee. <br/> It has the following constraints: <li> Must only contain numbers </li> <li> It must contain at least 3 digits </li> <br/> Valid Examples: <li>123</li> <li>97628372</li> Invalid Examples: <li>12</li> <li>Hello</li>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **EMAIL**               | e/                 | EMAIL represents the email of an employee. It must be of the format local-part@domain <br/> It has the following constraints: <li> The local-part should only contain alphanumeric characters and these special characters, excluding the parentheses, ( +_.- ). The local-part may not start or end with any special characters. </li>  <li> This is followed by a '@' and then a domain name. The domain name is made up of domain labels separated by periods. <li> The domain name must: <ol><li>End with a domain label at least 2 characters long</li><li>Have each domain label start and end with alphanumeric characters</li><li>Have each domain label consist of alphanumeric characters, separated only by hyphens, if any.</li></ol></li> Valid Examples: <li>PeterJack+1190@example.com</li> <li>a1+be.d@example1.com</li> Invalid Examples: <li>peter jack@example.com</li> <li>-peterjack@example.com</li> |
| **ADDRESS**             | a/                 | ADDRESS represents the home address of an employee. <br/> It can take in any value!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| **TAG**                 | t/                 | TAG represents a tag of an employee. <br/> It has the following constraints: <li> They can only contain alphanumeric characters. </li> <br/> Valid Examples: <li>Manager</li> Invalid Examples: <li>*Manager</li>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| **EMPLOYEE_ID**         | eid/               | Similar to ID, The EMPLOYEE_ID represents the ID of an employee. It is used when you want to select an employee. <br/> It follows the same constraints as ID.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| **DEPARTMENT_NAME**     | n/                 | DEPARTMENT_NAME is the unique identifier for a department. It is used when creating, editing and deleting a department. <br/> It has the following constraints: <li> They can only contain alphanumeric characters. </li> <br/> Valid Examples: <li>Manager</li> Invalid Examples: <li>*Manager</li>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **OLD_DEPARTMENT_NAME** | NA                 | OLD_DEPARTMENT_NAME represents the original name before editing a department. It has the same constraints as DEPARTMENT_NAME.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| **DATE**                | g/                 | DATE represents the date of the leave.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |

[//]: # (Talk about their constraints, type, format, etc)

## 6.3. Command Format

[//]: # (Explain the general command format: command, prefixes, placeholders)

## 6.4. Trying your first command

[//]: # (<-- Insert example context here -->)

--------------------------------------------------------------------------------------------------------------------

# 7. Commands

## 7.1. Employee Commands

### 7.1.1. Adding an employee: `add`

Adds an employee to SudoHR.

Format: `add id/ID n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
An employee can have any number of tags (including 0)
</div>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### 7.1.2. Listing all employees : `list`

Shows a list of all employees in SudoHR.

Format: `list`

### 7.1.3. Editing an employee : `edit`

Edits an existing employee in SudoHR.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the employee at the specified `INDEX`. The index refers to the index number shown in the displayed employees list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the employees will be removed i.e adding of tags is not cumulative.
* You can remove all the employee’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st employee to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd employee to be `Betsy Crower` and clears all existing tags.

### 7.1.4. Find employees by name: `find`

Finds employees whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Employees matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### 7.1.5. Deleting an employee : `delete`

Deletes the specified employee from SudoHR.

Format: `delete INDEX`

* Deletes the employee at the specified `INDEX`.
* The index refers to the index number shown in the displayed employee list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd employee in SudoHR.
* `find Betsy` followed by `delete 1` deletes the 1st employee in the results of the `find` command.

## 7.2. Department Commands

### 7.2.1. Adding a department: `adep`

Adds a department by name.

Format: `adep n/DEPARTMENT_NAME`

<div markdown="span" class="alert alert-warning">**NOTE:**
As of now, a department only has a department name field. In the future, we plan to add other
department-level details such as manager, department start date, parent department, etc.
</div>

Examples:
* `adep n/Software Engineering`
* `adep n/Marketing`

### 7.2.2. Editing a department: `edep`

Edits an existing department.

Format: `edep OLD_DEPARTMENT_NAME n/NEW_DEPARTMENT_NAME`

Examples:
* `edep Software Engineering n/Software Development`
* `edep Marketing n/Sales`

### 7.2.3. Find departments by name: `fdep`

Finds departments whose names contain any of the given keywords.

Format: `fdep KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `engineering` will match `Engineering`
* The order of the keywords does not matter. e.g. `Software Engineering` will match `Engineering Software`
* Only the name is searched.
* Only full words will be matched e.g. `Software` will not match `Softwares`
* Departments matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Software Engineering` will return `Software Development`, `Data Engineering`

Examples:
* `fdep Engineering` returns `Engineering` and `Software Engineering`
* `fdep software engineering` returns `Software Development`, `Data Engineering`<br>

### 7.2.4. Deleting a department: `ddep`

Deletes an existing department.

Format: `ddep n/DEPARTMENT_NAME`

Examples:
* `ddep n/Software Engineering`
* `ddep n/Sales`

### 7.2.5. Listing all departments: `ldep`

Lists all existing departments.

Format: `ldep`

### 7.2.6. Add employee to a department: `aetd`

Adds an employee to a department using his ID.

Format: `aetd eid/EMPLOYEE_ID n/DEPARTMENT_NAME`

<div markdown="span" class="alert alert-warning">**NOTE:**
You cannot add an employee to a department twice.
</div>

Examples:
* `aetd eid/1 n/Software Engineering`
* `aetd eid/100 n/Sales`

### 7.2.7. Remove employee from a department: `refd`

Removes an employee from a department using his ID.

Format: `refd eid/EMPLOYEE_ID n/DEPARTMENT_NAME`

Examples:
* `refd eid/1 n/Software Engineering`
* `refd eid/100 n/Sales`

### 7.2.8. List an employee's departments: `led`

List all departments and employee is in.

Format: `led eid/EMPLOYEE_ID`

Examples:
* `leid eid/100`

### 7.2.9. List all employees in a department: `leid`

List all employees in a department.

Format: `leid n/DEPARTMENT_NAME`

Examples:
* `leid n/Software Engineering`
* `leid n/Sales`

## 7.3. Leave Commands

### Adding a leave: `andre`

Tracks a person's leave.

Format: `add_leave n/NAME d/DATE`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add_leave n/John Doe d/2023-03-05`
* `add_leave n/Betsy Crowe d/2023-03-05~2023-03-10`

### Updating a leave: `andre`

TBC. Seemingly only relevant if we introduce half-day leaves.

Format: `TBC`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `TBC`
* `TBC`

### Deleting a leave: `andre`

Removes leave dates that are now cancelled.

Format: `del_leave n/NAME d/DATE`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `del_leave n/John Doe d/2023-03-05`
* `del_leave n/Betsy Crowe d/2023-03-06~2023-03-08`

### Listing all leaves for a person: `andre`

Lists all the leave date(s) of an employee.

Format: `ls_leave n/NAME`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `ls_leave n/John Doe `
* `ls_leave n/Betsy Crowe`

### Listing all users on leave for a given date: `andre`

Lists all personnel that are on leave for a given date(s).

Format: `ls_on_leave d/DATE`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `ls_on_leave d/2023-03-05`
* `ls_on_leave d/2023-03-05~2023-05-7`

## 7.4. General Commands

### 7.4.1. Viewing help : `help`

Shows a message explaining how to access the help page for SudoHR.

![help message](images/helpMessage.png)

Format: `help`

### 7.4.2. Clearing all entries : `clear`

Clears all entries from SudoHR.

Format: `clear`

### 7.4.3. Exiting the program : `exit`

Exits the program.

Format: `exit`

## 7.5. Data Storage

### 7.5.1. Saving the data

SudoHR data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### 7.5.2 Editing the data file

SudoHR data are saved as a JSON file `[JAR file location]/data/sudohr.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, SudoHR will discard all data and start with an empty data file at the next run.
</div>

## 7.6. Command summary

| Action                                 | Format                                                           |
|----------------------------------------|------------------------------------------------------------------|
| **Add an employee**                    | `add id/ID n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`    |
| **List all employees**                 | `list`                                                           |
| **Edit an employee**                   | `edit eid/ID [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` |
| **Find employee by name**              | `find KEYWORD [MORE_KEYWORDS]`                                   |
| **Delete an employee**                 | `delete eid/ID`                                                  |
| **Add a department**                   | `adep n/DEPARTMENT_NAME`                                         |
| **List all departments**               | `ldep`                                                           |
| **Edit a department**                  | `edep OLD_DEPARTMENT_NAME n/NEW_DEPARTMENT_NAME`                 |
| **Find department by name**            | `fdep KEYWORD [MORE_KEYWORDS]`                                   |
| **Delete a department**                | `ddep n/DEPARTMENT_NAME`                                         |
| **Add employee to department**         | `aetd eid/EMPLOYEE_ID n/DEPARTMENT_NAME`                         |
| **Remove employee from department**    | `refd eid/EMPLOYEE_ID n/DEPARTMENT_NAME`                         |
| **List an employee's department**      | `led eid/EMPLOYEE_ID`                                            |
| **List all employees in a department** | `leid n/DEPARTMENT_NAME`                                         |

[//]: # (Andre, Jer En, Kwang Joo, please add accordingly)

--------------------------------------------------------------------------------------------------------------------

## 8. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous SudoHR home folder.

[//]: # (Please add anything you think might be helpful)

## 9. Acknowledgements

[//]: # (To be added before Week 13)

## 10. Glossary

[//]: # (To be added before Week 13)
