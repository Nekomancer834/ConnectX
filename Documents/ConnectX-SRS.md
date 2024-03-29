﻿Connect X
### Software Requirements Specification
   Version 1.0 approved\
   Prepared by Trentin, Mohamed, and DeJon\
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
Appendix C: [Poject Sceduling](#appendix-c-project-sceduling)\
Appendix D: [Issues List](#appendix-d-issues-list)\
Appendix E: [Github Link](#appendix-e-github-link)

## Revision History

| Name   | Date    | Reason For Changes                            | Version   |
| ------ | ------  | --------------------------------------------- | --------- |
| all    | 10/9/22 | initial changes                               | 1.0       |
| all    | 11/5/22 | update for phase 2                            | 1.1       |
| all    | 2/14/23 | update for phase 4 and new fatures and changes| 1.2       |
| Trent  | 3/18/23 | update Appendix D to reflect current software | 1.6       |
| Trent  | 5/01/23 | minor grammar updates and finishing touches   | 1.8       |


## 1. Introduction

### 1.1 Purpose

Connect X is a game for 2-6 people where they try to get 4 of their pieces in a row with the added difficulty of features from other games. At the beginning, the GO feature will add more difficulty and complexity as the player count rises. If a player’s piece is surrounded by 4 other player’s pieces and one is a GO piece, the center piece is converted to the surrounding color. The product will also support later expansions featuring new pieces to spice up the gameplay further.
### 1.2 Document Conventions

This SRS is written in times 12 font.
Every requirement statement will have its own priority.


### 1.3 Intended Audience and Reading Suggestions

This SRS is intended for developers, project managers, testers, and document writers.

### 1.4 Project Scope

The software being provided is Connect X. Its purpose is to provide friendly competition between friends. It does this by increasing the difficulty thus increasing the levels of competition between players. It also increases friendly competition by allowing for more people to play the same game at once. Its goal is to make it easier for more people to be able to play connect 4 together.

### 1.5 References

https://whatsgoodtodo.co.uk/official-hasbro-giant-connect-4-review/ for the picture used in a mockup and also reference board scale
https://github.com/Nekomancer834/ConnectX for source, releases, and documents.
https://github.com/kotcrab/vis-ui/ for skins and libGDX addons


## 2. Overall Description

### 2.1 Product Perspective

Connect X is a replacement for the original Connect 4 game by Hasbro. This is because it will have a 2 player mode where the users can disable the new feature and play on the same board size as the original game. This product can also be considered a self-contained product if the user does not use the original features provided by the game Connect 4 which includes the bigger board, GO piece, and board scaling.

### 2.2 Product Features

This game will have 3 major features. The first major feature is the ability for more than 2 players to play on the same board. The second major feature provided by this software will be the ability to have difficulty scaling through the use of adjustable board sizes and game features. The third feature of Connect X is the new GO piece and ability to add new pieces in the future. These pieces will add the feature of capturing pieces similar to the board game Go. Instead of the captured piece being removed from the board, it is instead turned into a piece of the surrounding color. This is to prevent modifying the game too much by dropping all the pieces in the column down a space and it means people will need to team up to prevent the impending victory caused by two 3-in-a-row conditions. This piece increases your chances of winning while simultaneously adding pressure for the other players. The Go piece will be added to the game through a slider containing 3 different distribution modes: none, GO, random, and all. This will add an additional level of complexity to the game while also allowing for games closer to the original Connect 4 if desired.

### 2.3 User Classes and Characteristics

Favored User Classes:

Adults
* increased skill
* increased technical expertise
* increased likelyhood to use more functions of the product

Teenagers/young adults
* higher frequency of use
* medium to high education level
* medium technical expertise
* likely to take interest in new features

Younger than teens
* more likely to play in bigger group

New Players
* Not likely to stick to strategies seen in old software / physical games
* the probability of playing this rather than other games is higher

### 2.4 Operating Environment

The game will run on any x86 operating system capable of running Java 1.8 or higher.

### 2.5 Design and Implementation Constraints

This software should run within the targeted limit of 1GB of ram allocated to the program.
The program runs on java therefore the hardware also needs to be capable of running java.
The device needs to be capable of rendering openGL windows.
More limits will become apparent as development progresses.

### 2.6 User Documentation

Help Screen to show basic functionality of the game as well as how to utilize new pieces added

### 2.7 Assumptions and Dependencies

- Using LibGDX for the UI
- VisUI (https://github.com/kotcrab/vis-ui/) is used for the color pickers on the setting screen
- 2d array will work for tracking pieces
- 2d array tic tac toe project (for reference)
## 3. System Features


### 3.1 Game Start Menu

#### 3.1.1 Description and Priority

high priority interface that the user interacts with to start the game, set player count, determine board scale, set individual player colors, and enable or disable new game piece features.

#### 3.1.2 Stimulus/Response Sequences
Stimulus: The user interacts with the play button\
Response: The user is shown a new screen with more settings

Stimulus: The user interacts with the player count slider\
Response: The game stores the changed value

Stimulus: The user interacts with the color selection icons\
Response: The game updates the piece colors based on decided user input

Stimulus: the user interacts with the board scale slider\
Response: the program reflects the change on the UI and sets internal variables

Stimulus: the user interacts with the feature slider\
Response: the program sets whether or not to provide only normal pieces, all new pieces, or some random pieces

Stimulus: the user presses the start game button\
Response: the program sets internal variables based on the provided information from the user and transitions to the game menu

Stimulus: the user presses the help button\
Response: the program displays a screen allowing the player to browse through various hints as to the function\
          and uses of new pieces and features.

#### 3.1.3 Functional Requirements

REQ-1: buttons for each player’s color\
REQ-2: slider for player count\
REQ-3: slider for board scale\
REQ-4: start game button\
REQ-5: slider for new features

### 3.2 Player Color Selection

#### 3.2.1 Description and Priority

Each player in the game will have their own color for their pieces to make it easier to identify which turn it is and who is likely to win

#### 3.2.2 Stimulus/Response Sequences

Stimulus: The Players will click on their respective color changer\
Response: The program will display a color of their choosing for their pieces

#### 3.2.3 Functional Requirements
REQ-1: 6 intuitive color picking method

### 3.3 Player Count Selection

#### 3.3.1 Description and Priority

The game is playable with as few as 2 players and as many as 6, and the game will allow adjust for the number of players

#### 3.3.2 Stimulus/Response Sequences

Stimulus: The player will adjust a slider with values for the number of players\
Response: The program will show an updated value and scale the board to account for the extra players

#### 3.3.3 Functional Requirements

REQ-1: slider with player count values


### 3.4 Difficulty Selection

#### 3.4.1 Description and Priority

The players will artificially be able to make the board smaller than it should be, for the number of players present, making it much more difficult to win before the board is full. The difficulty will be calculated by taking into account the number of players in the game and also the value of the difficulty slider to return a board size that may be larger or smaller than the board size suggested to host 6 players. 

#### 3.4.2 Stimulus/Response Sequences

Stimulus: the player will adjust a slider to one of five values\
Response: the game will update to relfect the set value and set internal variables based on said value

#### 3.4.3 Functional Requirements
REQ-1: slider on UI to set difficulty

### 3.5 Game Menu

#### 3.5.1 Description and Priority

Once the game is started the users will be shown this menu with buttons for controlling the game and also a game board for playing pieces

#### 3.5.2 Stimulus/Response Sequences

Stimulus: the user will place a piece on the game board\
Response: the game will display the piece and then check if that piece causes a win

Stimulus: the user can push the end turn button\
Response: their turn is forfeit and the next player is selected

Stimulus: the player pushes the end game button\
Response: the program displays a confirmation

Stimulus: the user clicks yes on the end game confirmation\
Response: the program will return to the main menu

#### 3.5.3 Functional Requirements
REQ-1: game board\
REQ-3: end game button

### 3.6 Game Board

#### 3.6.1 Description and Priority
The game board is where the players will place their respective pieces and visually track possible winning placements

#### 3.6.2 Stimulus/Response Sequences

Stimulus: the player will click above the game board near a column\
Response: the game will place their piece at the lowest space in the column that is not occupied, to simulate gravity

#### 3.6.3 Functional Requirements

REQ-1: recreated game board style\
REQ-2: active piece snapping\
REQ-3: fake gravity on the board

## 4. External Interface Requirements

### 4.1 User Interfaces
Title Screen
- 16:9 aspect ratio
- start button
- help button
- quit button
- logo
- background image

Title Screen\
![Title Screen UI](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Images/UI/Title-Screen.png?raw=true)

Setup Menu
- 16:9 aspect ratio
- selection slider for player count
- selection slider for board scaling (-2 through +2)
- selection slider for new features (none, some, and all)
- intuitive color selection interface
- start game button
- back button

Setup Screen\
![Setup Screen UI](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Images/UI/Setup-Screen.png?raw=true)

Game Screen
- 16:9 aspect ratio
- collapsable player list
- help button
- piece to follow the cursor above the board
- board that scales with the number of players and board scale setting

Game Screen\
![Game Screen UI](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Images/UI/Game-Screen.png?raw=true)



### 4.2 Hardware Interfaces
This software uses the standard java interfaces.


### 4.3 Software Interfaces
This software uses the standard java and libGDX/openGL interfaces.


### 4.4 Communications Interfaces
N/A

## 5. Other Nonfunctional Requirements

### 5.1 Performance Requirements
The software's win calculation time should be less than 5 seconds on any hardware. Ideally this calculation will\
take nowhere near this long however it is dependant on the number of piece types added to the game.


### 5.2 Safety Requirements
N/A

### 5.3 Security Requirements
N/A

### 5.4 Software Quality Attributes
The software will be portable and reliable as it makes, and requires, no extra files outside of its jar and it can run on any device with java without any elevated priveleges. 


## 6. Other Requirements
N/A

## Appendix A: Glossary
N/A = Not Applicable

## Appendix B: Analysis Models
Use Case Diagram\
![Use Case Diagram](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Diagrams/UseCaseDiagram.png?raw=true)\
\
\
\
Activity Diagram\
![Activity Diagram](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Diagrams/ActivityDiagram.png?raw=true)\
\
\
\
Sequence Diagram\
![Sequence Diagram](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Diagrams/SequenceDiagram.png?raw=true)\
\
\
\
Class Diagram\
![Class Diagram](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Diagrams/ClassDiagram.png?raw=true)\
\
\
\
State Machine Diagram\
![State Machine Diagram](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Diagrams/StateMachineDiagram.png?raw=true)


## Appendix C: Project Scheduling

COCOMO II Model - Function Points Estimate\
![COCOMO II Model Function Points Estimate](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Diagrams/COCOMOFP.png?raw=true)

COCOMO II Model - SLOC Estimate\
![COCOMO II Model SLOC Estimate](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Diagrams/COCOMOSLOC.png?raw=true)

Gantt Chart Semester-1\
![Gantt Chart Semester-1](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Diagrams/GanttSemester1.png?raw=true)

Gantt Chart Semester-2\
![Gantt Chart Semester-2](https://github.com/Nekomancer834/ConnectX/blob/main/Documents/Diagrams/GanttSemester2.png?raw=true)

## Appendix D: Issues List

TBD - Help Screen Updates
* while the help screen is implemented as of the v6 release, feedback outside the dev team may warrant updates to the help menu and its contents

## Appendix E: Github Link

- https://github.com/Nekomancer834/ConnectX

