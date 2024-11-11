init:

    # Set up the size of the screen, and the window title.
    $ config.screen_width = 800
    $ config.screen_height = 600
    $ config.window_title = "The Ren'Py Demo Game"

    # Declare the images that are used in the program.

    # Backgrounds.
    image bg carillon = "carillon.jpg"
    image bg whitehouse = "whitehouse.jpg"
    image bg washington = "washington.jpg"
    image bg onememorial = "1memorial.jpg"
    image black = Solid((0, 0, 0, 255))

    # Character pictures.
    image eileen happy = "9a_happy.png"
    image eileen vhappy = "9a_vhappy.png"
    image eileen concerned = "9a_concerned.png"

    # A character object. This object lets us have the character say
    # dialogue without us having to repeatedly type her name. It also
    # lets us change the color of her name.

    $ e = Character('Eileen', color=(200, 255, 200, 255))

# The start label marks the place where the main menu jumps to to
# begin the actual game.

label start:

    # The save_name variable sets the name of the save game. Like all
    # variables declared outside of init blocks, this variable is
    # saved and restored with a save file.
    $ save_name = "Introduction"

    # This variable is only used by our game. If it's true, it means
    # that we won the date.
    $ date = False

    # Clear the game runtime timer, so it doesn't reflect time spent
    # sitting at the main menu.
    $ renpy.clear_game_runtime()

    # Start some music playing in the background.
    $ renpy.music_start('sun-flower-slow-drag.mid')

    # Now, set up the first scene. We first fade in our washington
    # background, and then we dissolve in the image of Eileen on top
    # of it.
    scene bg washington with fade
    show eileen vhappy with dissolve

    # Store the current version of Ren'Py into a variable, so we can
    # interpolate it into the next line.
    $ version = renpy.version()

    # Display a line of dialogue. In this case, we manually specify
    # who's saying the line of dialogue. We also interpolate in the
    # version of Ren'Py we're using.
    "Girl" "Hi, and welcome to the %(version)s demo program."

    # This instantly replaces the very happy picture of Eileen with
    # one showing her merely happy. It demonstrates how the show
    # statement lets characters change emotions.
    show eileen happy

    # Another line of dialogue.
    "Girl" "My name is Eileen, and while I plan to one day star in a
            real game, for now I'm here to tell you about Ren'Py."

    # This line used the e character object, which displays Eileen's
    # name in green. The use of a short name for a character object
    # lets us save typing when writing the bulk of the dialogue.
    e "Ren'Py is a language and engine for writing and playing visual
       novel games."

    e "Our goal is to allow people to be able to write the script for
       a game, and with very little effort, turn that script into
       a working game."

    e "I can tell you about the features of Ren'Py games, or how to write
       your own game. What do you want to know about?"

    # This variable is used to save the choices that have been made in
    # the main menu.
    $ seen_set = [ ]

label choices:

    # We change the save name here.
    $ save_name = "Question Menu"

    # This is the main menu, that lets the user decide what he wants
    # to hear about.
    menu:

        # The set menu clause ensures that each menu choice can only
        # be chosen once.
        set seen_set

        # This is a menu choice. When chosen, the statements in its
        # block are executed.
        "What are some user-visible features of Ren'Py games?":

            # We call the features label. The from clause needs to be
            # here to ensure that save games work, even after we
            # change the script. It was added automatically.
            call features from _call_features_1

            # When we're done talking about features, jump back up
            # to choices.
            jump choices

        # Another choice.
        "How do I write my own games with it?":
            call writing from _call_writing_1
            jump choices

        "Can you demonstrate more features to me?":
            call demonstrate from _call_demonstrate_1
            jump choices

        # This choice has a condition associated with it. It is only
        # displayed if the condition is true (in this case, if we have
        # selected at least one other choice has been chosen.)
        "Where can I find out more?" if seen_set:
            call find_out_more from _call_find_out_more_1
            jump choices

        "Why are we in Washington, DC?":
            call washington from _call_washington_1
            jump choices

        "I think I've heard enough." if seen_set:
            jump ending


# This is the section on writing games.
label writing:

    # Change the title of the save games.
    $ save_name = "Writing Games"

    # We start off with a bunch of dialogue.
    e "If you want to write a game, we recommend that you read the
       Ren'Py reference, which you can get from our web page,
       http://www.bishoujo.us/renpy/."

    e "But here, we'll go over some of the basics of writing Ren'Py
       scripts. It might make sense if you open the source for this
       game."

    e "The source for this game can be found in the file
       game/script.rpy."

    e "The goal of Ren'Py is to make writing the game similar to
       typing up the script on the computer."

    e "For example, a line of dialogue is expressed by putting the
       character's name next to the dialogue string."

    # A string by itself like this displays without a name associated
    # with it. So it's useful for dialogue and narration.
    "I somehow remember that strings by themselves are displayed as
     thoughts or narration."

    e "The menu statement makes it easy to create menus."

    e "A number of statements let you control what is shown on the
       screen."

    # This scene statement has a with clause associated with it. In
    # this case (based on what is defined in the init clause at the
    # top of this script), it causes a fade to black, and then back
    # to the new scene.
    scene bg whitehouse with fade

    e "The scene statement clears the scene list, which is the list of
       things that are shown on the screen."

    # This shows an image, and dissolves it in.
    show eileen happy with dissolve

    e "The show statement shows another image on the screen."

    # The at clause here, displays the character on the left side of
    # the screen. The with clause causes us to slide from the old
    # position to the new position.
    show eileen happy at left with move

    e "Images can take at clauses that specify where on the screen
       they are shown."

    show eileen vhappy at left

    e "Showing a new image with the same first part of the name
       replaces the image in the scene list."

    hide eileen with dissolve

    e "Finally, the hide statement hides an image, which is useful
       when a character leaves the scene."

    show eileen happy with dissolve

    e "Don't worry, I'm not going anywhere."

    e "The with statement is used to cause transitions to
       happen. Transitions like fade..."

    # This statement hides the transient stuff from being included
    # in the next fade.
    with None

    # This with statement causes things to fade without changing the
    # scene.
    with fade

    e "... or dissolve ..."

    # In this block, the scene statement clears the scene list. So we
    # have to reshow the eileen happy image, so that it appears that
    # just the background is dissolving. Sneaky.
    with None
    scene bg washington
    show eileen happy
    with dissolve