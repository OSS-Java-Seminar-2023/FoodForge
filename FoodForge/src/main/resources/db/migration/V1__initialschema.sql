CREATE TABLE Ingredient(
	ingredient_id int NOT NULL,
	ingredient_name varchar(40),
	unit varchar(10),
	PRIMARY KEY (ingredient_id)
);


CREATE TABLE Recipe(
	recipe_id int NOT NULL,
	title varchar(30),
	details text,
	difficulty varchar(30),
	prep_time smallint,
	PRIMARY KEY (recipe_id)
);

CREATE TABLE ShoppingList(
  mealplan_id int UNIQUE NOT NULL,
  shoppinglist_name varchar(30)
);


CREATE TABLE Users(
	user_id int NOT NULL,
	role varchar(20),
	username varchar(30),
	email varchar(30),
	passwd varchar(60),
	recipe_id int,
	PRIMARY KEY (user_id),
	FOREIGN KEY (recipe_id) REFERENCES Recipe(recipe_id)
);

CREATE TABLE MealPlan(
	mealplan_id int NOT NULL,
	plan_name varchar(20),
	details text,
	plan_date date,
	user_id int,
	PRIMARY KEY (mealplan_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
	
);


CREATE TABLE Review(
	review_id int NOT NULL,
	details text,
	score tinyint,
	review_date date,
	recipe_id int,
	user_id int,
	PRIMARY KEY (review_id),
	FOREIGN KEY (recipe_id) REFERENCES Recipe(recipe_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)

);


CREATE TABLE MealPlanRecipe(
	id int NOT NULL,
	mealplan_id int,
	recipe_id int,
	PRIMARY KEY (id),
	FOREIGN KEY (mealplan_id) REFERENCES MealPlan(mealplan_id),
	FOREIGN KEY (recipe_id) REFERENCES Recipe(recipe_id)

);

CREATE TABLE RecipeIngredient(
	id int NOT NULL,
	recipe_id int,
	ingredient_id int,
	quantity int,
	PRIMARY KEY (id),
	FOREIGN KEY (recipe_id) REFERENCES Recipe(recipe_id),
	FOREIGN KEY (ingredient_id) REFERENCES Ingredient(ingredient_id)
);

CREATE TABLE ShoppingListIngredient(
	id int NOT NULL,
	shoppinglist_id int,
	ingredient_id int,
	quantity int,
	unit varchar(10),
	PRIMARY KEY (id),
	FOREIGN KEY (shoppinglist_id) REFERENCES ShoppingList(mealplan_id),
	FOREIGN KEY (ingredient_id) REFERENCES Ingredient (ingredient_id)
);



ALTER TABLE ShoppingList
ADD FOREIGN KEY (mealplan_id) REFERENCES MealPlan(mealplan_id);

