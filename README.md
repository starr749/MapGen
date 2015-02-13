# MapGen
Basic Classes that have to do with procedural generation for a dungeon map 

Currently In Java
==================

Originally I have been working on this problem in python, but since I eventually plan on implementing this code in C#, 
so I thought I might resolve the problem in Java.

### Why not C#?

Because I was taking a Java class and thought it might make for a good practice.

### What does it do?

The map is a 3 dimensional array of integers. There are different types of rooms
(think treasure toom, boss room, key room, etc), and then you have blank rooms, which I am going to call 'linking rooms.'

The current process is to randomly seed the 2 demensional array with all the special rooms we need, and then connect the rooms.
Easy. The fun begins with how to link the different rooms, since it would be boring to just use the same process to link everything,
that would make easily predictable patterns, so we have 2 differnent directions to link rooms, and then we can always mix up
the order that we're linking rooms.

I did not include my tests in this repo, mostly due to embarassment. As much as I like posting publically how I crawl these
dungeons through the code, I'd rather not post things publically until I refine things.

### What comes next?

In order to actually draw the real map, and turn this into actual rooms, I need some more information, mostly about doors.
I plan on bit shifting~ Since I only need the first 3 bits to determine the type of room, I plan on using the next 4 to
determine where the doors are in 'NSEW' fashion.

So my next step is iterating through it placing doors.
