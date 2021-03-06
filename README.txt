**********************************************************************
Hart Tools
-----------------------------------------
Author: Michael James Hart
Email: mrhartgames@yahoo.com
-----------------------------------------
This repository contains all the tools I use to make video games with libgdx. Feel
free to use them all you want in you video game making adventures! There are no
requirements for using my code, however I would deeply appreciate two things and
both are completely optional:
1.) Please provide a link to this repository so others can use these tools as well.
2.) Send me an email so I can check out your video game!

If you have any questions on how anything works, feel free to email me.
**********************************************************************

=======
Commits
=======
03/30/16:
- Updated Mode: There is now a loadAssets function, self-explanatory.
- Updated GameWorld: There is now a MetaMode that acts just like a regular mode, it runs when there are assets to be loaded.

03/29/16:
- Added Documentation: Added READMEs to all the packages up to, but not including, Renderable package.
- Refactoring: Moved around classes and deleted obsolete packages, introduced the concept of concrete packages, meaning that user defined classes should go in there.
- Initializer now holds the starting mode that begins the GameWorld, and it is now contained in the Main package. 

03/25/16:
- Updated Package: [Package - modes] --> ALL FILES. Updated all files to recognize generic Class scheme rather than GameStates. Modes must now have a constructor with 1 parameter that takes a ModeBin object (a container object that can send messages from Mode to Mode). They must have a getNextBin method, which either returns the old ModeBin they were using or a new subclass of ModeBin that can hold objects for the next Mode. Finally, the update method now returns a Class, which is the next Mode that will be transitioned to, if returning null, then no Mode update will occur.

03/23/16:
-- {Laptop Merge}
-- Added Documentation to Enumeration package, Added Tutorial document, still a work in progress.
- Created File: [Package - mode] --> Mode_Test_TSP. A mode for playing around with the Travelling Salesman Problem (TSP).
- Created File: [Package - backend] --> Permute. A class for handling permutations, still needs some work, as it uses recursion for creating permutations.
- Created Skeleton Files. Will eventually fill these in.

02/23/16:
-- { Laptop Merge }
- Updated Package: [Package - shapes] --> ALL FILES. Updated all classes to extend their respective shapes in LibGDX. Rather than using composition, inheritence was more natural.
- Updated Package: [Package - renderable] --> ALL FILES. Updated all classes to extend their respective renderable objects in LibGDX.
- Renamed Package: [Package - sprites.backgrounds] --> [Package - backgrounds]
- Updated File: [Package - backgrounds] --> Background. Background is no longer a Sprite. Due to updates in SpriteHandling, a background no longer makes sense as a Sprite. It is only a renderable and should be handled in your mode's render function as such.
- Renamed Package: [Package - spites.ui] --> [Package - ui]
- Renamed File: [Package - collisions] CollisionHandler. CollisionHandler is now Collisions.
- Deleted Class: [ALL] --> SpriteHandler_Dangles. SpriteHandler_Dangles is now officially removed and all references to it have been destroyed. SpriteHandler is the only class now available for handling sprites.

02/23/16:
- Updated File: [Package - sprites] --> Sprite. Sprite's ID instance variable is now renderLayer instead. renderLayers are exactly as they sound; Sprites in lower numbers of renderLayers are rendered first.
- Updated File: [Package - sprites] --> Sprite. Sprite now has a method for handling what occurs when Sprites are in the same renderLayer. By overriding compareTo_SameRenderLayout, you can make comparisons to other sprites in the same renderLayer with whatever you like (position, velocity, etc.)

02/20/16:
- Updated File: [Package - sprites] --> Sprite. Sprite now supports multiple comparators in its compareTo method. Before calling compareTo, a comparator should be called for which comparison you would like to use. At the moment, position X, position Y, and ID sorting is available.
- Updated File [Package - collisions] --> CollisionArea. CollisionAreas must now implement methods for getting extreme left, right, top, and bottom endpoints. This is crucial to collision handling.
- Optimized: [Package - sprites] --> SpriteHandler.  Collision handling can now sort using the X or Y axis. Will switch between the two based on which direction has the largest spread of sprite positions; this is determined by using variance (from statistics, could use standard deviation as well).
- New Bench Test: Tested X vs Y sorting versus strict X sorting in collision handling in the SpriteHandler. 

02/12/16:
- Renamed File: [Package - sprites] SpriteHandler --> SpriteHandler_Dangles. Will eventually be removed, keeping for just 1 more commit.
- New File: [Package - sprites] SpriteHandler. The old SpriteHandler is now deprecated, it shall be known as SpriteHandler_Dangles.
- New File: [Package - structures] AvlTree. Just what it sounds like, still haven't tested it nor have used it in any way; may be useful at some point.
- New File: [Package - structures] SortedArrayList. An ArrayList that holds comparable objects. Does not automatically sort when objects in the list change, however insertions are sorted and a sort() method is available for use.
- New Bench Test: Tested the new CollisionHandler. doubles and even triples the speed of collision handling compared to the old Dangle CollisionHandler. Can now have a best case of n collision checks.

01/16/16:
- Happy new year!
- Documentation: Added README's to main package and World package.
- Loaders: Added a new loader for Backgrounds.
- Backend: Created CameraDimensions, object that holds a camera's dimensions (e.g. position, width, etc.)
- Backend: Created HartMath for some Math functions that are not provided by Java.
- Enumerations: Created an Enumerations package and created Directions class in it for DPad style directions.
- Input: Created Directionable Interface to allow a class to return some direction in either 4 or 8 DPad style directions (from Directions class).
- Input: Joystick now implements Directionable.
- Input: Created InputArrows, a new style of input for keyboard input with arrows, implements Directionable.
- Mode: Created a new test mode for testing Background's.
- Mode: Created a new test mode for testing Selection's
- UI: Created UI package for menu UI style elements.
- UI: Created Selection class for selection style UI. Imagine the street fighter character selection screen; that's a selection.
- Sprites: Added setRenderPosition function to Sprite class.
- Backgrounds: Made Background shift over to RenderableObjects
- Backgrounds: Created Bounded and Unbounded Backgrounds.
- Structures: Created a new Structures package for Data Structures
- Structures: Created a new DFA (Deterministic Finite Automa) class as well as DFA_State for the states that DFA uses.
- World: GameWorld now takes in Camera from GameScreen.
- Collisions: Added CollisionUpdateable Interface.
- Sprites: Added SpriteHandler actions, SpriteNodes. Created Collidable, Resettable, and Moderator sprites.
- State: Added Abstract states that update after update and collisionUpdate function calls. Created StateUpdateable Interface as well.

12/20/15:
- Modified SpriteHandler to allow for multi-threaded updates. Bench testing results show that multi-threading is slower than normal updates. Commented out multi-threaded code.
- Modified SpriteHandler and SpritePair to use adjacency lists as structure for collisions. No longer using collision modes.
- Modified Sprite test suite to bench test how long updates take on average per cpu cycle, also made adding sprites much easier through a loop.
- Added getElapsedTime() to Timer class to allow for a stop-watch style functionality.

12/19/15:
- Created CollisionAreas and CollisionHandler classes.
- Created Collidable and Resettable interfaces.
- Collisions are now easily implemented, some basic testing needs to be done. Dormant bugs may still be amuck.
- Created SpriteHandler and SpritePairs for use with collision handlers.
- Added new Test Suite for testing Sprites and their collisions.
- Created renderable package for RenderableObjects. Now we can create TextureRegions and Animations polymorphically.
- Created shapes package for Shape2D. Now we can create circles and rectangles polymorphically.
- Modified some JavaDocs to contain my developer email.

11/24/15:
- Debugged Loaders, now fully functional.
- Added Loading Icon meta assets.
- Created the mythical Slice method that I pursued for so long in Assets.

11/24/15:
- Deprecated static Textures, Sounds, and Fonts asset loaders. Modes now use AssetManagers which will be loaded through GameWorld.
- Static loaders will be left in for legacy system games, however to prevent "black box" textures from occurring, new AssetManager modes should be utilized.
- While AssetManager from currentMode is not done loading, GameRenderer will render a loading screen which the user can specify through the GameWorld's metaAssets
- All changes here are not finished and still need to be tested!

11/19/15:
- Created "scripts" folder and created standardize.py for use with montage to merge multiple png files into a single strip png file
- Created .gitignore
- Added thumbs.db to .gitignore, to get rid of the horrendous file that pops up everytime viewing icons in the directory

11/08/15:
- Created Background class for renderable backgrounds
- Created ScrollableBackground class for backgrounds that can scroll (Not yet finished)

11/06/15:
- Renamed JoystickCommands 'scale' instance variable to 'normalized' for more readability
- Added updateVectors(float delta) to Sprite for standard vector updates.

11/05/15:
- Renamed "Assets" to "assets"
- Turned GameState into a list of constant int states, removed all deprecated request functions, now a pure static class.
- Made Button into an abstract class, isInRange is now an abstract function so that at the child level the user can define whether the touch is in range of a Circle or Rectangle.
- Created Button_InGame for in game buttons
- Changed "UI" assets directory to "input"

11/04/15:
- Added ID's to timers for freezable functionality.
- Added freeze and unfreeze functionality for Timers, has been tested and works so far with no errors.
- Added Main method to Timer for testing 
- Timer.initialize() must now be called at the beginning of your program to get the ArrayList of freeze ID's to initialize.
- Removed deprecated Task class and code referencing it (was commented out to begin with, is now deleted).
- Deleted all legacy code
- Added Global Reset timer to Logo Mode so assets can load properly
- Settings class now contains Timer IDs
- Fixed Game Class to no longer be abstract, is now instantiated straight from DesktopLauncher, AndroidLauncher, ...

11/03/15:
- Fixed a few errors with not calling Settings, instead SpaceGame was being called (from Space Game project).
- Fixed an error with Assets createRegionsFromTextures method, the array SHOULD be initialized to begin with.
- Assets createRegionsFromTextures no longer initializes the Texture Array.

11/01/15:
- Moved majority of code to legacy
- Timer from tools no longer uses tasks
- Collisions are now handled with collision areas
- Joystick and Button no longer rely on GamePad or InputHandler, directly detect touches from Gdx class.
- Added Settings class for a one stop class for all the major game settings (screen width, height, Joystick directions, etc.)
- Updated heart beat logo to signature logo
- Added backend package with: Rotation, Touch, Debuggable interface, Messages.
- Added mode package for cleaner transitions between game modes
=======
5/2/15:
- Added transparent dark joystick and buttons

4/14/15:
- Added "Assets" tools file to Assets package

4/9/15:
- Added all the latest code used from Twinjas mobile game.
