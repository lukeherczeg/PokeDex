public class Pokemon {
    private String species;
    private int attack;
    private int defense;
    private int speed;

    public Pokemon(String species)
    {
        setSpecies(species);                             //Constructor sets species and all the values of stats
        attack = species.length() * 4 + 2;
        defense = species.length() * 2 + 7;
        speed = species.length() * 3 + 5;
    }

    public void evolve()
    {
        setSpeed(getSpeed()*2);                          //Evolve sets stats = to the current times an integer
        setAttack(getAttack()*3);
        setDefense(getDefense()*5);
    }
    //All of the following are setters and getters for the class
    public void setSpecies(String newSpecies)
    {
        this.species = newSpecies;
    }

    public void setAttack(int newAttack)
    {
        this.attack = newAttack;
    }

    public void setDefense(int newDefense)
    {
        this.defense = newDefense;
    }

    public void setSpeed(int newSpeed)
    {
        this.speed = newSpeed;
    }

    public String getSpecies()
    {
        return this.species;
    }

    public int getAttack()
    {
        return this.attack;
    }

    public int getDefense()
    {
        return this.defense;
    }

    public int getSpeed()
    {
        return this.speed;
    }
}