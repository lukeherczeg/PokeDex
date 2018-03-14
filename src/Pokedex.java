import java.util.*;

public class Pokedex {
    private int totalNumber;
    private Pokemon[] pokeArray;

    public Pokedex() {                                     //Pokedex constructor
        totalNumber = 0;                                   //Makes pokeArray have as many spaces as totalnumber.
        pokeArray = new Pokemon[totalNumber];
    }

    public void setTotalNumber(int newTotalNumber)
    {
        this.totalNumber = newTotalNumber;
    }
    //Setter/getter for total number
    public int getTotalNumber()
    {
        return this.totalNumber;
    }


    public String[] listPokemon()
    {
        String[] pokeString = new String[pokeArray.length];          //Makes string array with each Pokemon in it
        for (int i = 0; i < pokeArray.length; i++)
            pokeString[i] = pokeArray[i].getSpecies();               //Uses getSpecies for each to add to the string array
        return pokeString;                                           //Returns string array
    }

    public boolean addPokemon(String species)
    {
        boolean duplicate = false;
        ArrayList<Pokemon> pokemonArrayList = new ArrayList<>(pokeArray.length);      //Makes array list for pokemon objects
        for (Pokemon poke: pokeArray) {
            pokemonArrayList.add(poke);                                               //Adds each iteration of Pokearray to the list
        }

        int newTempNumber = pokeArray.length + 1;                                     //Makes a temp total number, sets it equal to what the array size WILL be.
        for (Pokemon poke: pokeArray) {
            if (poke.getSpecies().toUpperCase().equals(species.toUpperCase())) {
                duplicate = true;                                                     //Iterates, using getSpecies() to compare the string
            }                                                                         //to the string before it, makes them both uppercase so that
        }                                                                             //case is ignored.

        if(duplicate)
        {
            System.out.println("Duplicate");//Checks for duplicates
            return false;
        }                                                                             //Checks if the totalnumber is equal
        else if(newTempNumber > this.totalNumber) {                                   //to the temp number
            System.out.println("Max");
            return false;
        }

        Pokemon newPoke = new Pokemon(species);                                       //For adding the pokemon, makes a new one
        pokemonArrayList.add(newPoke);                                                //Add the pokemon using .add for arrayLists
        Pokemon[] newPokeArray = new Pokemon[pokeArray.length + 1];                   //Makes a new pokeArray, adds one to the size,
        pokeArray = pokemonArrayList.toArray(newPokeArray);                           //Makes pokeArray = to the ArrayList.toArray
        return true;                                                                  //of the size of the newPokeArray
    }


    public int[] checkStats(String species)
    {
        int position = 0;
        int[] stats = new int[3];                                //Makes the int array that will be returned in the method
        for (int i = 0; i < pokeArray.length; i++) {
            if (pokeArray[i].getSpecies().toUpperCase().equals(species.toUpperCase())) {
                position = i;
                break;                                           //With a loop, finds and sets the position of the desired pokemon
            }
        }
        stats[0] = pokeArray[position].getAttack();
        stats[1] = pokeArray[position].getDefense();            //Sets the stats using getAttack() for
        stats[2] = pokeArray[position].getSpeed();              //the pokemon at the right position

        return stats;
    }


    public void sortPokedex()
    {
        ArrayList<Pokemon> pokemonArrayList = new ArrayList<>(pokeArray.length);  //Makes a new arrayList of pokemon
        for (Pokemon poke: pokeArray) {                                           //Fills the arrayList with each pokemon in pokeArray
            pokemonArrayList.add(poke);
        }
        Collections.sort(pokemonArrayList, new Comparator<Pokemon>() {            //Uses Collections.sort, using Comparator<Pokemon>
            @Override                                                             //to override the compare method so that it compares
            public int compare(Pokemon o1, Pokemon o2) {                          //the names of 2 pokemon objects (Using getSpecies())
                return o1.getSpecies().toUpperCase().compareTo(o2.getSpecies().toUpperCase());
            }
        });
        for (int i = 0; i < pokemonArrayList.size(); i++) {                       //Sets each Pokemon in pokeArray to each
            pokeArray[i] = pokemonArrayList.get(i);                               //Pokemon in the arrayList, so the sorting is complete
        }
    }


    public boolean evolvePokemon(String species)
    {
        boolean duplicate = true;
        int position = 0;
        for (int i = 0; i < pokeArray.length; i++) {
            if (pokeArray[i].getSpecies().toUpperCase().equals(species.toUpperCase())) {
                position = i;
                duplicate = false;                   //Like checkStats, finds position of desired pokemon,
                break;                               //except uses duplicate boolean
            }
        }
        if(duplicate)                                //If duplicate, the boolean method returns false
            return false;
        pokeArray[position].evolve();                //The Pokemon at the desired position is evolved
        return true;
    }


    public boolean pokemonExists(String species)
    {
        for (Pokemon poke: pokeArray) {
            if (poke.getSpecies().toUpperCase().equals(species.toUpperCase())) {
                return true;
            }                          //For each Pokemon in the array, check if the
        }                              //string of getSpecies is the same as the string entered
        return false;                  //If there is a match, exists = true
    }
}