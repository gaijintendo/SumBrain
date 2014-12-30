SumBrain
========

BACKSTORY
---------

I had some distant-relative-in-laws stay over this Christmas. They seem like nice enough people. They come from somewhere north of London. 

They spent ~80% of the stay playing Wii U. I tore them away from it for a cycle, and walks, but they seemed to be sucked back into it constantly. Nintendo "gifted" 2006 hit Brain Training, and they played that, both managing to max out the brain age.

I suggested we make something, and this is what happened - a simplistic recreation of the speedy sums part of Brain Training.

One of them joined in, they other watched the following on Netflix:
* Little Man
* Ever After High
* Winx Club
* RuPaul's Drag Race
* Mia and Me

They were both between 12 and 15

STORY
-----

This commit is all we managed to do in an evening. I don't suggest you start with this project, but it is here for you to see what you might like to do.

Here is a list of lessons learned:

+ Download and install Android Studio
+ Set phone into Developer mode
+ How to search StackOverflow for answers (hints for showing keyboard, even event handlers)
+ First attempt did not have `appLoop()`, that was added to allow us to restart... but that got ditched anyway
+ First attempt had no splash screen, that taught us a bit about changing config.
+ Difference between `==` and `.equals()`
+ Perfect demo of a divide by zero error
+ Visual editor
+ When visual editor stopped rendering, XML
+ Hacking to make things kind of work
+ Debugging too
+ Switch/Case statements

Obviously loads of other stuff came up.

I forgot to emphasise:
* Commenting code
* Giving links/attribution to stuff ripped from StackOverflow/Android Docs etc.

I should say, I let them do the typing, but couldn't resist helping at times because they seemed incapable of using my touchpad.
Absolutely let them drive.
I was in a fortuitous position, as they seemed to have made use of Javascript/Python somehow at school, which gives me some faith in the schooling system.

REGARDING PYTHON
----------------
I once went to FOSDEM, and ended up at a dinner of RedHat peoples at La Mirabelle.
In the restaurant, a group of Pythonistas had gathered.
They were placed on a very long row of tables.
At the beginning of this row, there were two spaces.

REGARDING REDHAT DEVELOPERS
---------------------------
I once went to FOSDEM, and ended up at a dinner of Red Hat peoples at La Mirabelle.
I chose not to drink, and inevitably they decided to "go Dutch".
I decided, given the extra expense, to only tip 10%.
When the change came, it was exactly my tip, which was impressive in itself.
They decided that the fair thing to do, given the discrepancy, was to share my tip out equally amongst themselves; assuming nobody had tipped.
I explained that it was my tip, and they explained to me that people do not tip in Belgium.

WARNINGS
--------
We didn't come up with a good way of stopping the keyboard hiding.
There is no high score.
There are probably better practices for most of this - feel free to fork if it annoys you that these and other things abound. I might even try and tidy it up myself in a fork.
That said, I would not feel patronised if you were to show me how things should have been approached.