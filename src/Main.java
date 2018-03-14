import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        Pokedex pokedex = new Pokedex();                            //Makes new pokedex object, assigns to pokedex
        System.out.print("Welcome to your new PokeDex!\n" +
                "How many Pokemon are in your region: ");
        Scanner input = new Scanner(System.in);
        int pokedexMax = input.nextInt();
        pokedex.setTotalNumber(pokedexMax);                          //Sets total number as the cap for the pokedex
        input.nextLine();
        System.out.print("\nYour new Pokedex can hold " + pokedexMax + " Pokemon. Let’s start using it!\n\n");
        //while statement for the ongoing menu
        while (running) {
            System.out.print("1. List Pokemon\n" +
                    "2. Add Pokemon\n" +
                    "3. Check a Pokemon’s Stats\n" +                   //Menu
                    "4. Evolve Pokemon\n" +
                    "5. Sort Pokemon\n" +
                    "6. Exit\n\n" +
                    "What would you like to do? " );

            Scanner newInput = new Scanner(System.in);
            int choice = 0;                        //Set choice equal to a redundant value not being used

            try { choice = newInput.nextInt(); }   //Simple try-catch to catch wrong input and keep the program running
            catch (InputMismatchException wrong)   //going forward to the switch.
            {/*see default of switch below*/}

            switch (choice) {
                case 1:
                    String[] pokeList = pokedex.listPokemon();                      //Makes a string array and uses listPokemon
                    String output = "";                                             //to initialize it.
                    for(int i = 0; i < pokeList.length; i++)                        //Makes a string, concatenates it with each
                    {                                                               //iteration of the string array; ie
                        output += (i+1 + ". " + pokeList[i] + "\n");                //the list of pokemon, separated by \n
                    }
                    System.out.print(output);                                       //Prints output
                    break;
                case 2:
                    System.out.print("\nPlease enter the Pokemon's Species: ");
                    String species = input.next();
                    pokedex.addPokemon(species);                                   //Uses addPokemon method.
                    break;
                case 3:
                    System.out.print("\nPlease enter the Pokemon of interest: ");
                    species = input.next();                                        //Takes in species as user input
                    if(pokedex.pokemonExists(species))                             //Uses pokemonExists to check if it needs to print Missing
                    {                                                              //If exists
                        System.out.println("\nThe stats for " + species + " are:" +
                                "\nAttack: " + pokedex.checkStats(species)[0] +         //Print stats
                                "\nDefense: " + pokedex.checkStats(species)[1] +
                                "\nSpeed: " + pokedex.checkStats(species)[2]);
                    }
                    else
                        System.out.println("Missing");
                    break;
                case 4:
                    System.out.print("\nPlease enter the Pokemon of interest: ");
                    species = input.next();                                       //Takes in species as user input
                    if(pokedex.evolvePokemon(species)) {                          //Uses evolvePokemon to check if it needs to print Missing
                        System.out.println(species + " has evolved!");            //and to evolve the pokemon.
                    }
                    else
                        System.out.println("Missing");
                    break;
                case 5:
                    pokedex.sortPokedex();                                        //Uses sort method
                    break;
                case 6:
                    running = false;
                    break;
                default:                                           // default will be the invalid input
                    System.out.println("\nThat is not a valid choice. Try again.");
            }
            System.out.print("\n");
        }
    }
}