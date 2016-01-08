
package polytech.dc.event;

import polytech.dc.gameCharacters.Hero;

public final class DisplayStory {
    public static void pyramid(){
    System.out.println("\t                        .d88b.                ");
    System.out.println("\t                        88  88                ");
    System.out.println("\t        '               '8bd8'              '");
    System.out.println("\t       /=\\\\              '88'             //=\\");
    System.out.println("\t      /===\\ \\        g888SEAL888g       / /===\\");
    System.out.println("\t     /=====\\' \\           88          / '/=====\\");
    System.out.println("\t    /=======\\'' \\         88        / ''/=======\\");
    System.out.println("\t   /=========\\ ' '\\       88      /' ' /=========\\");
    System.out.println("\t  /===========\\''   \\    d88b   /   ''/===========\\");
    System.out.println("\t /=============\\ ' /    d8888b   \\ ' /=============\\");
    System.out.println("\t/===============\\/                 \\/===============\\");
    }
    public static void welcome() {
        System.out.println(".___________________________________________________________________.");
        System.out.println("| _    _         _    _        _    _         _    _        _    _ |");
        System.out.println("| \\/}/     /}    \\/}/     /}   \\/}/     /}    \\/}/     /}   \\/}/   |");
        System.out.println("| |_    _/|\\_    |_    _/|\\_   |_    _/|\\_    |_    _/|\\_   |_     |");
        System.out.println("| | \\    / \\     | \\    / \\    | \\    / \\     | \\    / \\    | \\    |");
        System.out.println("|vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv|");
        System.out.println("|                                                                  |");
        System.out.println("|               WELCOME TO THE PYRAMIDE OF THE DEAD                |");
        System.out.println("|         .*.                                          .*.         |");
        System.out.println("|        ;(;);________________________________________;(;);        |");
        System.out.println("|        |;;;    _    _         _    _        _    _   ;;;|        |");
        System.out.println("|        | ;/}    \\/}/     /}    \\/}/     /}   \\/}/    /; |        |");
        System.out.println("|        |_/|\\_    |_    _/|\\_    |_    _/|\\_   |_   _/|\\_|        |");
        System.out.println("|        | / \\     | \\    / \\     | \\    / \\    | \\   / \\ |        |");
        System.out.println("|      __|vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv|__      |");
        System.out.println("|__________________________________________________________________|\n");
    }
    public static void introduction() {
        System.out.println("\t    __________________________________________");
        System.out.println("\t   ()_________________________________________)");
        System.out.println("\t    (                                        (");
        System.out.println("\t     )                                        )");
        System.out.println("\t     |              THE LEGEND                |");
        System.out.println("\t     |                                        |");
        System.out.println("\t     | For an eternity, Anubis is keeping     |");
        System.out.println("\t     | hide a big treasure into the pyramid.  |");
        System.out.println("\t     | Lot of archeologists and tombs raider  |");
        System.out.println("\t     | tried to take it from him but they     |");
        System.out.println("\t     | never came back...The legends say the  |");
        System.out.println("\t     | person who will own this treasure      |");
        System.out.println("\t     | could become immortal. But the pyramid |");
        System.out.println("\t     | is full of monsters and creatures,     |");
        System.out.println("\t     | and they hate intruders... If you      |");
        System.out.println("\t     | decide to enter,and they'll do         |");
        System.out.println("\t     | anything to kill you.                  |");
        System.out.println("\t     |                                        |");
        System.out.println("\t     (_________________________________________)");
        System.out.println("\t    ()_________________________________________)\n");
    }
    
    public static void beginning() {
        System.out.println("\t    _____________________________________________");
        System.out.println("\t   ()____________________________________________)");
        System.out.println("\t    (                                           (");
        System.out.println("\t     )                                           )");
        System.out.println("\t     | Welcome to the first room of the pyramid. |");
        System.out.println("\t     | To success this level and move up to the  |");
        System.out.println("\t     | next room, you have to reach 50 XP.       |");
        System.out.println("\t     | Be on your guard and don't trust anyone...|");
        System.out.println("\t     | or the pyramid will be your tombstone !   |");
        System.out.println("\t     |                                           |");
        System.out.println("\t     (__________________________________________(");
        System.out.println("\t    ()___________________________________________)\n");
    }

    public static void level(Hero heroPlayer) {
        System.out.println("\t    _____________________________________________");
        System.out.println("\t   ()____________________________________________)");
        System.out.println("\t    (                                           (");
        System.out.println("\t     )                                           )");
        System.out.println("\t     | Congratulation, you successed level "+ (heroPlayer.getLevel()-1) +" !   |");
        System.out.println("\t     | Welcome to the next room. You win an armor|");
        System.out.println("\t     | to be invicible for one round, but be     |");
        System.out.println("\t     | carefull, creatures are stronger and      |");
        System.out.println("\t     | pitiless. Reach "+ heroPlayer.getConditionToChangeLevel()+" xp and stay alive     |");
        System.out.println("\t     | to move up to the next room. !            |");
        System.out.println("\t     | You have "+ heroPlayer.gethP()+" HP now !                      |");
        System.out.println("\t     (__________________________________________(");
        System.out.println("\t    ()___________________________________________)\n");
    }
    
    public static void boss(Hero heroPlayer) {
        System.out.println("   .d88b.                                               .d88b. ");
        System.out.println("   88  88                                               88  88 ");
        System.out.println("   '8bd8'                                               '8bd8' ");
        System.out.println("    '88'      ¶¶¶¶¶¶¶    ¶¶¶¶¶¶     ¶¶¶¶¶    ¶¶¶¶¶       '88'  ");
        System.out.println("g888SEAL888g  ¶¶    ¶¶  ¶¶¶  ¶¶¶   ¶¶   ¶¶  ¶¶   ¶¶  g888SEAL888g ");
        System.out.println("     88       ¶¶    ¶¶ ¶¶¶    ¶¶¶ ¶¶       ¶¶             88  ");
        System.out.println("     88       ¶¶¶¶¶¶¶  ¶¶      ¶¶  ¶¶¶¶¶    ¶¶¶¶¶         88 ");
        System.out.println("     88       ¶¶    ¶¶ ¶¶¶    ¶¶¶       ¶¶       ¶¶       88 ");
        System.out.println("    d88b      ¶¶    ¶¶  ¶¶¶  ¶¶¶   ¶¶   ¶¶ ¶¶    ¶¶      d88b ");
        System.out.println("   d8888b     ¶¶¶¶¶¶¶¶   ¶¶¶¶¶¶     ¶¶¶¶¶   ¶¶¶¶¶¶      d8888b ");
        
        System.out.println("\t    _____________________________________________");
        System.out.println("\t   ()____________________________________________)");
        System.out.println("\t    (                                           (");
        System.out.println("\t     )                                           )");
        System.out.println("\t     | God help me ! You are close to the end... |");
        System.out.println("\t     | Anubis is behind this door. If you success|");
        System.out.println("\t     | to win the fight, you will leave the      |");
        System.out.println("\t     | pyramid with the treasure. To be on the   |");
        System.out.println("\t     | safe side, you drink all your health      |");
        System.out.println("\t     | potions. If you are too weak,             |");
        System.out.println("\t     | the pyramid will be your tombstone...     |");
        System.out.println("\t     |                                           |");
        System.out.println("\t     (__________________________________________(");
        System.out.println("\t    ()___________________________________________)\n"); 
    }
    
    public static void loose() {
        System.out.println("                                     ____");
        System.out.println("                              __,---'     `--.__");
        System.out.println("                           ,-'                ; `.");
        System.out.println("                          ,'                  `--.`--.");
        System.out.println("                         ,'                       `._ `-.");
        System.out.println("                        ;                     ;     `-- ;");
        System.out.println("                       ,-'-_       _,-~~-.      ,--      `.");
        System.out.println("                       ;;   `-,;    ,'~`.__    ,;;;    ;  ;");
        System.out.println("                       ;;    ;,'  ,;;      `,  ;;;     `. ;");
        System.out.println("                       `:   ,'    `:;     __/  `.;      ; ;");
        System.out.println("     GAME OVER !        ;~~^.   `.   `---'~~    ;;      ; ;");
        System.out.println("                        `,' `.   `.            .;;;     ;'");
        System.out.println("                        ,',^. `.  `._    __    `:;     ,'");
        System.out.println("                        `-' `--'    ~`--'~~`--.  ~    ,'");
        System.out.println("                       /;`-;_ ; ;. /. /   ; ~~`-.     ;");
        System.out.println("-._                   ; ;  ; `,;`-;__;---;      `----'");
        System.out.println("   `--.__             ``-`-;__;:  ;  ;__;");
        System.out.println(" ...     `--.__                `-- `-'");
        System.out.println("`--.:::...     `--.__                ____");
        System.out.println("    `--:::::--.      `--.__    __,--'    `.");
        System.out.println("        `--:::`;....       `--'       ___  `.");
        System.out.println("            `--`-:::...     __           )  ;");
        System.out.println("                  ~`-:::...   `---.      ( ,'");
        System.out.println("                      ~`-:::::::::`--.   `-.");
        System.out.println("                          ~`-::::::::`.    ;");
        System.out.println("                              ~`--:::,'   ,'");
        System.out.println("                                   ~~`--'~");
    }
   
    public static void winBoss() {
        System.out.println("           _.-=====-._");
        System.out.println("        .-'           '-.");
        System.out.println("     .'                   '.");
        System.out.println("   .'       _.-===-._       '.");
        System.out.println("  /      .-'_.-===-._'-.      \\");
        System.out.println(" /     .' .'         '. '.     \\");
        System.out.println(" |    /  /             \\  \\    |");
        System.out.println(" |    |  |             |  |    |     ______________________________________");
        System.out.println(" |    |  \\             /  |    |    ()____________________________________)");
        System.out.println(" |    |   '._________.'   |    |     (                                  (");
        System.out.println(" |    |                   |    |      )                                  )");
        System.out.println(" |    |   /           \\   |    |      | CONGRATULATION,                  |");
        System.out.println(" |    |  |/  _.-=-._  \\|  |    |      |   You defeat the big boss Anubis.|");
        System.out.println(" |    |  \\'_/`-. .-'\\_'/  |    |      | In his tombstone, you found      |");
        System.out.println(" |    |   '-\\ _ V _ /-'   |    |      | this amazing treasure, which     |");
        System.out.println(" |    |     .' 'v' '.     |    |      | will make you rich and famous.   |");
        System.out.println(" |    |   .'|   |   |'.   |    |      |    Now, you can exit the pyramid,|");
        System.out.println(" |    |   v'|   |   |'v   |    |      | more stronger than ever. You     |");
        System.out.println(" |    |     |   |   |     |    |      | will be a true hero when you     |");
        System.out.println(" |    |    .\\   |   /.    |    |      | will come back to home...        |");
        System.out.println(" |    |   (_.'._^_.'._)   |    |      |                                  |");
        System.out.println(" |    |    \\       //     |    |      |                                  |");
        System.out.println(" |    |     \'-   -'/      |    |      |                                  |");
        System.out.println(" |    |   _     _     _   |    |      |  Thanks for playing,             |");
        System.out.println(" |    |  | |   | |   | |  |    |      |                                  |");
        System.out.println(" |    |  |_|   |_|   |_|  |    |      |        Jérémy Dollé & Léa Collin |");
        System.out.println(" |    | .---------------. |    |      |                                  |");
        System.out.println(" |    | |               | |    |      (__________________________________(");
        System.out.println(" |     \\ '._         _.' /     |     ()___________________________________)");
        System.out.println("  \\     '._ ''-----''  .'     /");
        System.out.println("   '._   | '-.-.-.-.-.'    _.'");
        System.out.println("     .'  | | | | | | |    '.");
        System.out.println("  .-'    | | | | | | |      '-.");
        System.out.println(" (       | | | | | | |         )");
        System.out.println("  '------'-'-'-'-'-'-'--------'");
    }
}




 


 







 

  
