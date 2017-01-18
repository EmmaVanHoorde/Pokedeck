
public class Card {

	private String name;
	private String pokemonType;
	private String cardType;
	private String trainerType;
	private String trainerBox;
	private String trainerRule;
	private int HP;    
    private int stage;
    private int collectorCardNumber;
        
    //public Card(String nameP, String PokemonTypeP, String cardTypeP, String trainerTypeP, String trainerBoxP, String trainerRuleP, int HPP, int stageP, int collectorCardNumberP)
    public Card(String nameP, String pokemonTypeP){
        name = nameP;
        pokemonType = pokemonTypeP;
//        cardType = cardTypeP;
//        trainerType = trainerTypeP;
//        trainerBox = trainerBoxP;
//        trainerRule = trainerRuleP;
//        HP = HPP;
//        stage = stageP;
//        collectorCardNumber = collectorCardNumberP;
        
        
    }
    
    public String getName(){
    	return name;
    }
    public String getPokemonType(){
    	return pokemonType;
    }
    public String getCardType(){
    	return cardType;
    }
    public String getTrainerType(){
    	return trainerType;
    }
    public String getTrainerBox(){
    	return trainerBox;
    }
    public String getTrainerRule(){
    	return trainerRule;
    }
    public int getHP(){
    	return HP;
    }
    public int getStage(){
    	return stage;
    }
    public int getcollectorCardNumber(){
    	return collectorCardNumber;
    }
}
