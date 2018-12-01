# Game: Crossy World

Crossy World is a new and improved version of classic arcade game - "Frogger". Crossy world is a casual game that provides a seamless experience to the player by having a continous navigation not restricted by a single screen size. The game is more of a marathon rather than sprint. More terrains can be added in future to make it even more interesting.

## Gameplay:
John Doe (Player) has to cross land, road and river by avoid all obstacles in each of the terrains. He has 3 lives to begin with. He can collect coins to increase his score and collecting 5 coins gives him an extra life. He keeps navigating through all the terrains until he reaches the finish line. On reaching the finish line, he moves to the next level. In level 2 and 3, gameplay remains same except the difficulty level increases where number of terrains to cross increases along with the speed of cars and logs. Finishing level 3 completes the game and John wins. Score is equal to the number of coins collected.

## Design:
Game uses Greenfoot game engine. We have implemented entire game from scratch (not picked up any source code from online). We identified and implemented below design patterns.

1. Composite - For composing all objects in various terrains like Road, River, Land.
2. Strategy  - To set game differently for each level.
3. Observer  - 
4. Decorator - To show levelboard graphically
5. Mediator  - 
6. Prototype - To clone objects in the world instead of creating from scratch.

## Ad video:
https://youtu.be/EpRtCIgjst0


## Project Team:
Kruti Thukral <br>
Sharwari Phadnis <br>
Pratik Bhandarkar <br>
Vishwanath Manvi <br>

## Key Contributions from team members:

### Vishwanath Manvi:

1. Pitched multiple game ideas to be implemented including the game we finalized - Crossy World.
2. Helped drive requirements discussion and design and user story creation in the initial phase.
3. Imnplemented 2 feature stories - player crossing river terrains, crashing obstacles
4. Implemented the logic of populating cars and river logs randomly.
5. Implemented 2 design patterns - 
         i. Strategy pattern for handling the game differently for each level. At each game level, the number of terrains, car and log speed changes. Also, strategy pattern can be extended to load each level differently with other terrains (not implemented currently). 
         ii. Prototype pattern for creating objects in the terrains like cars, logs, trees and rocks. So, instead of creating these objects from stratch, am using clone() feature to create more of them.

6. Helped in refactoring code from other modules, testing and fixing issues.
7. As a champion of XP value <b> "Communication" </b>, I was helping with most of the communications with the team that included setting up meetings, communicating updates over slack and whatsapp, taking notes, etc.



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



