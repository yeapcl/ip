# User Guide

Duke is a task management application that helps user to manage tasks such as todos, deadlines and events, through a simple command-line interface.
It can be executed on any platform that supports Java 11.

- [Features](#features)
- [Instructions](#instructions)
    - [Adding a todo task: `todo`](#adding-a-todo-task-todo)
    - [Adding a deadline task: `deadline`](#adding-a-deadline-task-deadline)
    - [Adding an event task: `event`](#adding-an-event-task-event)
    - [Listing all tasks: `list`](#listing-all-tasks-list)
    - [Finding a task: `find`](#finding-a-task-find)
    - [Completing a task: `done`](#completing-a-task-done)
    - [Deleting a task: `delete`](#deleting-a-task-delete)
    - [Existing the program: `bye`](#existing-the-program-bye)
- [Command summary](#command-summary)

## Features 

### Add tasks
Duke supports 3 different types of task to be managed, namely `todo`, `deadline` and `event`.

### Manage tasks
Duke allows the tasks to be managed, such as marking it as completed, or deleting the task from the list.

### Search tasks
Duke allows user to easily search for a task that contains the keyword.

### Save tasks
Duke automatically saves all your tasks in a text file.

### Load tasks
Duke automatically loads the saved tasks from the previous session.

## Instructions

### Adding a todo task: `todo`

Adds a todo task to Duke.

Format: `todo DESCRIPTION`

- `DESCRIPTION` should not be an empty field

Example:

`todo read book`

### Adding a deadline task: `deadline`

Adds a deadline task to Duke.

Format: `deadline DESCRIPTION_1 /by DESCRIPTION_2`

- the keyword `/by` must be specified followed by `DESCRIPTION_2`
- both `DESCRIPTION_1` and `DESCRIPTION_2` should not be an empty field

Example:

`deadline return book /by June 6th`

### Adding an event task: `event`

Adds an event task to Duke.

Format: `event DESCRIPTION_1 /at DESCRIPTION_2`

- the keyword `/at` must be specified followed by `DESCRIPTION_2`
- both `DESCRIPTION_1` and `DESCRIPTION_2` should not be an empty field

Example:

`event project meeting /at Aug 2-4pm at NUS`

### Listing all tasks: `list`

Shows a list of tasks saved by Duke

Format: `list`

### Finding a task: `find`

Duke finds and lists all task(s) that matches the `KEYWORD`

Format: `find KEYWORD`

- Keyword(s) is case-sensitive.
- `KEYWORD` should not be an empty field

Example:

`find book`

### Completing a task: `done`

Duke marks a task as done as specified by user.

Format: `done INDEX`

- The `INDEX` must be within the range of the enumerated list. Type `list` to get an overview of the tasks.

Example:

`done 1`

### Deleting a task: `delete`

Duke deletes a task as specified by user.

Format: `delete INDEX`

- The `INDEX` must be within the range of the enumerated list. Type `list` to get an overview of the tasks.

Example:

`delete 1`

### Existing the program: `bye`

Quit the Duke program. Duke saves all the tasks in a text file in the default location.

Format: `bye`

## Command summary

Action | Format | Examples
------ | -------| --------
todo | `todo DESCRIPTION` | `todo read book`
deadline | `deadline DESCRIPTION_1 /by DESCRIPTION_2` | `deadline return book /by June 6th`
event | `event DESCRIPTION_1 /at DESCRIPTION_2` | `event project meeting /at Aug 6th 2-4pm at NUS`
list | `list` | `list`
find | `find KEYWORD` | `find book`
done | `done INDEX` | `done 1`
delete | `delete INDEX` | `delete 1`
bye | `bye` | `bye`
