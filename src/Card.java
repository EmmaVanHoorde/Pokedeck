
public class Card {

	private String name;
	private String pokemonType;
    private String stage;
    private String HP;
    private String evolvesFrom;

    public Card(String nameP, String pokemonTypeP, String stageP, String HPP, String evolvesFromP)
    {
        name = nameP;
        pokemonType = pokemonTypeP;
        stage = stageP;
        HP = HPP;
        evolvesFrom  = evolvesFromP;
    }
    
    public String getName(){
    	return name;
    }
    public String getPokemonType(){
    	return pokemonType;
    }
    public String getStage(){
        return stage;
    }
    public String getHP(){
    	return HP;
    }
    public String getEvolvesFrom(){
        return evolvesFrom;
    }

}
