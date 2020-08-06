
public class Country {
	
	private String name;
	private int population;
	private boolean speakEnglish;
	private String city;
	
	public Country() {
		
	}
	
	public Country(String name, int population, boolean speakEnglish, String city) {
		super();
		this.name = name;
		this.population = population;
		this.speakEnglish = speakEnglish;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public boolean isSpeakEnglish() {
		return speakEnglish;
	}

	public void setSpeakEnglish(boolean speakEnglish) {
		this.speakEnglish = speakEnglish;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + ", speakEnglish=" + speakEnglish + ", city="
				+ city + "]";
	}
	
	

}
