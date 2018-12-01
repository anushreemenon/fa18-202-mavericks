# Weekly Scrum Report
## Week 1: (11/4 to 11/10)
 * **What tasks did I work on / complete?**
 1. Browsed through various games available on the internet. Found out some demos (https://www.youtube.com/watch?v=XP1riBB3XNE) and suggested a list of 4 games for brainstorming: duck-hunt, pong, donkey kong and the highway-crossing.
 2. Finalized on the "crossy read" which is based on the similar concepts of the highway-crossing game
 3. Helped refine the user-stories and divide them into much simpler scenarios
 4. Identified the possible design patterns that can be applied to these scenarios

 I chose "**Simplicity**" and as a part of this XP value, I made certain suggestions:
 1. Keeping a simple, clear and short set of requirements and gameplay rules (such as scoring, rewards, player lives) so that the user does not get confused. This will also help us during development.
 2. Try not to introduce "design patterns" right from the beginning because this may complicate the design. 
 3. Start with the basic user stories from the set we created earlier and keep the implementation simple so that we can have a basic working prototype. 
 4. Use GreenFoot to actually try to implement a small animation (just as PoC) to get some idea about how the game is going to look and gain some confidence.


 * **What am I planning to work on next?**
   - Design and implement the "road" terrain of the game 

 * **What tasks are blocked waiting on another team member?**
   - No blocking items, so far.
------------------------------------

## Week 2: (11/11 to 11/17)
 * **What tasks did I work on / complete?**
 1. Constructed the use-case diagram comprising of all the possible use cases
 2. Started working on a user story 'As a player I want to cross land by avoiding obstacles' - wrote the logic to check if there is an obstacles (such as tree or rock) in the way when the player tries to move up/down/left/right. Partial implementation is done.

 * **What am I planning to work on next?**
 1. Work with Sharwari figure out the logic to construct and load multiple terrains and scroll them across the screen as the game progresses
 2. Implement the remaining part of above user story. Working on the code for 'drag the player backwards as the terrains scroll down if the player is stationary at one place and there is a tree/rock in front of him'
 3. Creation of class diagram

 * **What tasks are blocked waiting on another team member?**
   - None

------------------------------------

## Week 3: (11/18 to 11/24)
 * **What tasks did I work on / complete?**
 1. Finished the development for user story 'As a player I want to cross land by avoiding obstacles' and submitted for testing. 
 2. Added and tested the code to stop current level when the player reaches the edge of the world
 3. Added code to gradually drag down the Player with the moving terrains so that it touches lower edge of World and die.
 4. Worked on the "land" terrain. Added more trees and rocks in the 'land' terrain
 5. Committed the class diagram

 * **What am I planning to work on next?**
 1. Development and implementation of user story - Create a starter page
 2. Implement the "decorator" pattern for "Level" board.
 3. Cleanup and revisit the class diagram.
 4. Add sequence diagrams for the parts that I worked on, thus far.
 
 * **What tasks are blocked waiting on another team member?**
   - None
   
   ----------------------------------
   
## Week 4: (11/25 to 12/1)
 * **What tasks did I work on / complete?**
 1. Added "decorator pattern" for level counter board 
 2. Designed and Added a star up screen for the game with backround music
 3. Added exception handling for sounds played in the game
 4. Updated the class diagram. Added a new class overview diagram with less details and more readability
 5. Contributed into the making of ad video

 * **What am I planning to work on next?**
 1. Prepare for the demo and presentation of the game
 
 * **What tasks are blocked waiting on another team member?**
   - None
