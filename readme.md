# Game: Crossy World

Crossy World is a new and improved version of classic arcade game - "Frogger". Crossy world is a casual game of crossing different terrains by avoiding obstacles to get golden coins. It provides a seamless gaming experience by having continous navigation not restricted by a single screen size like frogger. The game is more of a marathon rather than sprint. More terrains can be added in future to make it even more interesting.

## Ad video:
https://youtu.be/EpRtCIgjst0

## Requirements:
### Gameplay:
John Doe (Player) has to cross land, road and river by avoid all obstacles in each of the terrains. He has 3 lives to begin with. He can collect coins to increase his score and collecting 5 coins gives him an extra life. He keeps navigating through all the terrains until he reaches the finish line. On reaching the finish line, he moves to the next level. In level 2 and 3, gameplay remains same except the difficulty level increases where number of terrains to cross increases along with the speed of cars and logs. Finishing level 3 completes the game and John wins. Score is equal to the number of coins collected.

### Use cases:
https://github.com/nguyensjsu/fa18-202-mavericks/blob/master/docs/Use-Case-Specification.pdf

## Design:
Game uses Greenfoot game engine. We have implemented entire game from scratch (not picked up any source code from online). We identified and implemented below design patterns.

1. Composite - For composing all objects in various terrains like Road, River, Land.
2. Strategy  - To set game differently for each level.
3. Observer  - To notify terrains to stop moving vertically once the player reaches finish line.
4. Decorator - To add the graphics and UI components to the Level board
5. Mediator  - 
6. Prototype - To clone objects in the world instead of creating from scratch.

### UML Diagrams:
- Class overview diagram: https://github.com/nguyensjsu/fa18-202-mavericks/blob/master/docs/uml-diagrams/Class%20Diagram%20(overview).jpg <br>
- Detailed class diagram: https://github.com/nguyensjsu/fa18-202-mavericks/blob/master/docs/uml-diagrams/Class%20Diagram.jpg <br>
- System Sequence Diagrams: https://github.com/nguyensjsu/fa18-202-mavericks/tree/master/docs/uml-diagrams <br>


## Project Team:
Kruti Thukral <br>
Sharwari Phadnis (Student ID: 012168884)<br>
Pratik Bhandarkar (Student ID: 013735748) <br>
Vishwanath Manvi <br>

## Key Contributions from team members:

### Vishwanath Manvi:

1. Pitched multiple game ideas to be implemented including the game we finalized - Crossy World.
2. Helped drive requirements discussion and design and user story creation in the initial phase.
3. Implemented 2 feature stories - player crossing river terrains, crashing obstacles
4. Implemented the logic of populating cars and river logs randomly.
5. Implemented 2 design patterns - 
         i. Strategy pattern for handling the game differently for each level. At each game level, the number of terrains, car and log speed changes. Also, strategy pattern can be extended to load each level differently with other terrains (not implemented currently). 
         ii. Prototype pattern for creating objects in the terrains like cars, logs, trees and rocks. So, instead of creating these objects from stratch, am using clone() feature to create more of them.

6. Helped in refactoring code from other modules, testing and fixing issues.
7. As a champion of XP value <b> "Communication" </b>, I was helping with most of the communications with the team that included setting up meetings, communicating updates over slack and whatsapp, taking notes, etc.

### Sharwari Phadnis

1. Implemented proof of concept for the game. This was aimed to check the possibility of implementing dynamically moving terrains.
2. Worked on exploring various ideas for Games and finalizing Crossy World for the project.
3. Created UI mockups for the primary screens in the game to get an initial idea of how the game will look.
4. Implemented code for **_Finish line_** feature.
5. Implemented navigation(up/down/left/right) of the the main Player.
6. Implemented **Observer Design pattern**:
         - Observer Design Pattern helped in notifying all the Terrains such as Roads, River, Land to stop moving vertically once the Player reaches the finish line. This helped in eliminating the singleton class and to scale the same code to all the Levels.
7. Helped in end to end testing, fixing bugs in the code.
8. Created System Sequence Diagrams mentioned in the Use Case Specification Document.
9. Developed an **Ad Video** for the game.
10. As a champion of XP value **"Courage"**, I helped in taking important decisions and implementation of feature such as changing a static terrain game to dynamically changing terrains. 

### Pratik Bhandarkar:
1. suggested several game development ideas for this project and participated in the brainstorming meeting to finalize the idea to be developed
2. Developed a comprehensive use-case diagram that consists of all the user-stories handled in the game
3. Created and maintained class diagram of all the major classes in the game
4. Coded the land terrain for the game and added more trees and rocks to it. Wired it with rest of the game.
5. Added the obstacle detection logic for the player. If there is a tree or a rock in its way, the player cannot move in that direction. This forces the user to move the player to move the player in some other direction.
6. Wrote a logic to gradually move the player along with the moving terrain towards the lowermost edge of the world. This adds a challenge because the game-user cannot keep the player standing forever at one place.
7. Added a "**decorator pattern**" for the "level counter board":
   - The LevelBoard class returns a simple string with current level number (such as "Level 2") and the LevelBoardDecorator class decorates this string with UI components and displays it on the lower-left order of the screen.
8. Designed and coded the start up screen for the game. Introduced the switching of the StarScreen to MyWorld when the "Play" button is clicked
9. Added code to handle exceptions that may be thrown while playing a game-sound
10. Helped creating an **ad video** for the game
11. As an advocate of **Simplicity**" property of XP, made suggestions to maintain readability of the code and clarity of design. Refactord the code of creating new objects and adding the to current World in Level1Strategy class. This helped in adding new functionalities and strategies during further development


## GitHub Repo:
https://github.com/nguyensjsu/fa18-202-mavericks/

## Project Task Board:
https://github.com/nguyensjsu/fa18-202-mavericks/projects/1

## Individual journals:
https://github.com/nguyensjsu/fa18-202-mavericks/blob/master/kruti.thukral-journal.md
https://github.com/nguyensjsu/fa18-202-mavericks/blob/master/sharwari-phadnis-journal.md
https://github.com/nguyensjsu/fa18-202-mavericks/blob/master/pratik.bhandarkar-journal.md
https://github.com/nguyensjsu/fa18-202-mavericks/blob/master/vishwanath.manvi-journal.md

## Sprint Task Sheet:
https://docs.google.com/spreadsheets/u/1/d/1dMe1_Ixf5i2VE0_i3Y-k3izS20wZZ5Eb07uHHIjhDTg/edit#gid=0



