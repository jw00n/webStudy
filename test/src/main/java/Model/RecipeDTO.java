package Model;

public class RecipeDTO {
	private int num;
	private String recipe_name;
	private String food_type;
	private String recipe_weather;
	private int recipe_calory;
	private String recipe_date;
	private float carbohydrate;
	private float protein;
	private float fat;
	private float calcium;
	private float sodium;
	
	public RecipeDTO(int num, String recipe_name, String food_type, String recipe_weather, int recipe_calory,
			String recipe_date, float carbohydrate, float protein, float fat, float calcium, float sodium) {
		this.num = num;
		this.recipe_name = recipe_name;
		this.food_type = food_type;
		this.recipe_weather = recipe_weather;
		this.recipe_calory = recipe_calory;
		this.recipe_date = recipe_date;
		this.carbohydrate = carbohydrate;
		this.protein = protein;
		this.fat = fat;
		this.calcium = calcium;
		this.sodium = sodium;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public String getFood_type() {
		return food_type;
	}

	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}

	public String getRecipe_weather() {
		return recipe_weather;
	}

	public void setRecipe_weather(String recipe_weather) {
		this.recipe_weather = recipe_weather;
	}

	public int getRecipe_calory() {
		return recipe_calory;
	}

	public void setRecipe_calory(int recipe_calory) {
		this.recipe_calory = recipe_calory;
	}

	public String getRecipe_date() {
		return recipe_date;
	}

	public void setRecipe_date(String recipe_date) {
		this.recipe_date = recipe_date;
	}

	public float getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(float carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public float getProtein() {
		return protein;
	}

	public void setProtein(float protein) {
		this.protein = protein;
	}

	public float getFat() {
		return fat;
	}

	public void setFat(float fat) {
		this.fat = fat;
	}

	public float getCalcium() {
		return calcium;
	}

	public void setCalcium(float calcium) {
		this.calcium = calcium;
	}

	public float getSodium() {
		return sodium;
	}

	public void setSodium(float sodium) {
		this.sodium = sodium;
	} 
	
	
	
}
