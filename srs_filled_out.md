
# Connect X\
### Software Requirements Specification
   Version 1.0 approved\
   Prepared by Trentin and Mohamed\
   October 9, 2022

## Table of Contents
[Revision History](#revision-history)
1. [Introduction](#1-introduction)\
  1.1 [Purpose](#11-purpose)\
  1.2 [Document Conventions](#12-document-conventions)\
  1.3 [Intended Audience and Reading Suggestions](#13-intended-audience-and-reading-suggestions)\
  1.4 [Project Scope](#14-project-scope)\
  1.5 [References](#15-references)
2. [Overall Description](#2-overall-description)\
  2.1 [Product Perspective](#21-product-perspective)\
  2.2 [Product Features](#22-product-features)\
  2.3 [User Classes and Characteristics](#23-user-classes-and-characteristics)\
  2.4 [Operating Environment](#24-operating-environment)\
  2.5 [Design and Implementation Constraints](#25-design-and-implementation-constraints)\
  2.6 [User Documentation](#26-user-documentation)\
  2.7 [Assumptions and Dependencies](#27-assumptions-and-dependencies)
3. [System Features](#3-system-features)\
	3.1 [Game Start Menu](#31-system-feature-1)\
	3.2 [Player Color selection](#32-Player-Color-Selection)\
	3.3 [Player Count Selection](#33-Player-Count-Selection)\
	3.4 [Difficulty Selection](#34-Difficulty-Selection)\
	3.5 [Game Menu](#35-Game-Menu)\
	3.6 [Game Board](#36-Game-Board)
4. [External Interface Requirements](#4-external-interface-requirements)\
	4.1 [User Interfaces](#41-user-interfaces)\
	4.2 [Hardware Interfaces](#42-hardware-interfaces)\
	4.3 [Software Interfaces](#43-software-interfaces)\
	4.4 [Communications Interfaces](#44-communications-interfaces)
5. [Other Nonfunctional Requirements](#5-other-nonfunctional-requirements)\
	5.1 [Performance Requirements](#51-performance-requirements)\
	5.2 [Safety Requirements](#52-safety-requirements)\
	5.3 [Security Requirements](#53-security-requirements)\
	5.4 [Software Quality Attributes](#54-software-quality-attributes)
6. [Other Requirements](#6-other-requirements)

Appendix A: [Glossary](#appendix-a-glossary)\
Appendix B: [Analysis Models](#appendix-b-analysis-models)\
Appendix C: [Issues List](#appendix-c-issues-list)

## Revision History

| Name   | Date    | Reason For Changes   | Version   |
| ------ | ------  | -------------------- | --------- |
| all    | 10/9/22 | initial changes      | 1.0       |
|        |         |                      |           |


## 1. Introduction

### 1.1 Purpose

Connect X Go 0.01b a game for 2-6 people where they try to get 4 of their in a row with an added difficulty of a GO feature. The GO feature will add more difficulty and complexity as the player count rises. If a player’s piece is surrounded by 4 other player’s pieces and one is a GO piece, the center piece is converted.

### 1.2 Document Conventions

This SRS is written in times 12 font.
Every requirement statement will have its own priority.


### 1.3 Intended Audience and Reading Suggestions

This SRS is intended for developers, project managers, testers, and document writers.


### 1.4 Project Scope

The software being provided is Connect X Go. Its purpose is to provide friendly competition between friends. It does this by increasing the difficulty thus increasing the levels of competition between players. It also increases friendly competition by allowing for more people to play the same game at once. Its goal is to make it easier for more people to be able to play connect 4 together.

### 1.5 References

https://whatsgoodtodo.co.uk/official-hasbro-giant-connect-4-review/ for the picture used in a mockup
potentially more references as the project progresses


## 2. Overall Description

### 2.1 Product Perspective

Connect X is a replacement for the original Connect 4 game by Hasbro. This is because it will have a 2 player mode where the users can disable the new feature and play on the same board size as the original game. This product can also be considered a self-contained product if the user does not use the original features provided by the game Connect 4 which includes the bigger board, GO piece, and difficulty scaling.

### 2.2 Product Features

This game will have 3 major features. The first major feature is The ability for more than 2 players to play on the same board. The second major feature provided by this software will be the ability to have difficulty scaling through the use of adjustable board sizes and game features. The third feature of Connect X GO is the new GO piece. This piece will add the feature of capturing pieces from the board game Go. Instead of the captured piece being removed from the board, it is instead turned into a piece of the surrounding color. This is to prevent modifying the game too much by dropping all the pieces in the column. This piece increases you chances of winning while decreasing your opponents chances of winning

### 2.3 User Classes and Characteristics

Favored User Classes:

Adults
* increased skill
* increased technical expertise
* likely to use more functions of the product

Teenagers/young adults
* higher frequency of use
* medium to high education level
* medium technical expertise

Younger than teens
* more likely to play in bigger group

New Players
* Not likely to stick to strategies seen in old software
* the probability of playing this rather than other games is higher

### 2.4 Operating Environment

This game will run on laptops and desktops. The game will run on any operating capable of running Java 1.8 or higher.

### 2.5 Design and Implementation Constraints

This software should run within the limit of 1GB of ram allocated to the program.
The program runs on java therefore the hardware also needs to be capable of running java.
More limits will become apparent as development progresses.

### 2.6 User Documentation

A demonstration video showing how the game works and the features of the new piece.
PDF guide to show basic functionality

### 2.7 Assumptions and Dependencies

- Using JavaFX for the UI
- Linked Lists will work for tracking pieces
*we assume that linked lists will be okay to use for tracking pieces
- 2d array tic tac toe project
*we plan to reuse code from this to check for win conditions if the linked list assumption is incorrect

## 3. System Features


### 3.1 Game Start Menu

#### 3.1.1 Description and Priority

high priority interface that the user interacts with to start the game, to set player count, to determine difficulty, and to set individual player colors

#### 3.1.2 Stimulus/Response Sequences
Stimulus: The user interacts with the player count drop-down menu
Response: The game stores the changed value

Stimulus: The user interacts with the color selection menus
Response: The game updates the piece colors based on decided user input

Stimulus: the user interacts with the difficulty slider
Response: the program reflects the difficulty change on the UI and sets internal variables

Stimulus: the user toggles the go feature toggle
Response: the program sets whether or not to provide go pieces internally

Stimulus: the user presses the start game button
Response: the program sets internal variables based on the provided information from the user and transitions to the game 	menu


#### 3.1.3 Functional Requirements

REQ-1: buttons for each player’s color
REQ-2: drop-down menu for player count
REQ-3: slider for difficulty
REQ-4: start game button
REQ-5: Go feature toggle

### 3.2 Player Color Selection

#### 3.2.1 Description and Priority

Each player in the game will have their own color for their pieces to make it easier to identify which turn it is and who is likely to win

#### 3.2.2 Stimulus/Response Sequences

Stimulus: The Players will click on their respective drop-down menu
Response: The program will display a color picker with many options for colors

#### 3.2.3 Functional Requirements
REQ-1: Color picker drop-down
REQ-2: As many color pickers as players

### 3.3 Player Count Selection

#### 3.3.1 Description and Priority

The game is playable with as few as 2 players and as many as 6 and the game will allow adjust for the number of players

#### 3.3.2 Stimulus/Response Sequences

Stimulus: The player will open up a drop-down with values for the number of players
Response: The program will show an updated value and scale the board to account for the extra players

#### 3.3.3 Functional Requirements

REQ-1: drop-down with player count values


### 3.4 Difficulty Selection

#### 3.4.1 Description and Priority

The players will artificially be able to make the board smaller than it should be for the number of players present making it much more difficult to win before the board is full 

#### 3.4.2 Stimulus/Response Sequences

Stimulus: the player will adjust a slider to one of three values
Response: the game will update a label with the set value and set internal variables based on said value

#### 3.4.3 Functional Requirements
REQ-1: slider on UI to set difficulty

### 3.5 Game Menu

#### 3.5.1 Description and Priority

Once the game is started the users will be shown this menu with buttons for controlling the game and also a game board for playing pieces

#### 3.5.2 Stimulus/Response Sequences

Stimulus: the user will place a piece on the game board
Response: the game will display the piece and then check if that piece causes a win

Stimulus: the user can push the end turn button
Response: their turn is forfeit and the next player is selected

Stimulus: the player pushes the end game button
Response: the program displays a confirmation

Stimulus: the user clicks yes on the end game confirmation
Response: the program will return to the main menu

#### 3.5.3 Functional Requirements
REQ-1: game board
REQ-2: end turn button
REQ-3: end game button
REQ-4: end game confirmation

### 3.6 Game Board

#### 3.6.1 Description and Priority
The game board is where the players will place their respective pieces and visually track possible winning placements

#### 3.6.2 Stimulus/Response Sequences

Stimulus: the player will click above a column
Response: the game will place their piece at the lowest space in the column that is not occupied to simulate gravity

#### 3.6.3 Functional Requirements

REQ-1: recreated game board style
REQ-2: piece snapping
REQ-3: fake gravity

## 4. External Interface Requirements

### 4.1 User Interfaces
Main Menu
16:9 or 4:3 aspect ratio
selection slider for difficulty (low medium high)
drop down menu for player count
start game button
help button
color selection boxes
toggle (go feature)
![main menu](https://github.com/Nekomancer834/ConnectX/blob/main/Main-Menu.png?raw=true)

Game Menu
16:9
one panel on left
end game button
end turn button
help button
player list
error message box above board
![game menu idea 1](https://github.com/Nekomancer834/ConnectX/blob/main/Game%20UI%20layout%20idea1.png?raw=true)

### 4.2 Hardware Interfaces
standard java interfaces


### 4.3 Software Interfaces
Help opens in web browser of user's system


### 4.4 Communications Interfaces
N/A

## 5. Other Nonfunctional Requirements

### 5.1 Performance Requirements
win calculation time should be less than 5 seconds on any hardware


### 5.2 Safety Requirements
N/A

### 5.3 Security Requirements
N/A

### 5.4 Software Quality Attributes
The software will be portable and reliable as it makes and requires no extra files and it can run on any device with java


## 6. Other Requirements
N/A

## Appendix A: Glossary
N/A = Not Applicable

## Appendix B: Analysis Models
![Use Case Diagram](https://github.com/Nekomancer834/ConnectX/blob/main/Lab5%20Use%20Case%20Diagram.drawio%282%29.png?raw=true)\
![Activity Diagram](https://github.com/Nekomancer834/ConnectX/blob/main/Lab%206%20Activity%20Diagram.drawio%282%29.png?raw=true)\
![Sequence Diagram](https://github.com/Nekomancer834/ConnectX/blob/main/Sequence%20Diagram.drawio.png?raw=true)

## Appendix C: Issues List
TBD - Game engine

* JavaFX seems like a good choice as it can be integrated into swing UIs that we have been using in class
* Information is needed to determine if we should continue looking into JavaFX or something else such as libGDX

TBD - piece tracking
* for game piece tracking and win condition checking, 2D arrays and linked lists seem equally able to be used however one might be more efficient so we need to look into these

TBD - Game menu layout
* The UI for the game menu can be set up multiple ways that seem to be equally user friendly so we should decide on that
