CREATE TABLE User(
	id varchar(255) NOT NULL,
	role varchar(20),
	username varchar(30),
	email varchar(30),
	passwd varchar(60),
	PRIMARY KEY (id)
);

CREATE TABLE Ingredient(
	id varchar(255) NOT NULL,
	ingredient_name varchar(40),
	unit varchar(10),
	PRIMARY KEY (id)
);



CREATE TABLE ShoppingList(
  id varchar(255) NOT NULL,
  shoppinglist_name varchar(30)
);

CREATE TABLE Recipe(
	id varchar(255) NOT NULL,
	title varchar(30),
	details text,
	difficulty varchar(30),
	prep_time smallint,
	user_id varchar(255),
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE MealPlan(
	id varchar(255) NOT NULL,
	plan_name varchar(20),
	details text,
	plan_date date,
	user_id varchar(255),
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES User(id)
	
);


CREATE TABLE Review(
	id varchar(255) NOT NULL,
	details text,
	score tinyint,
	review_date date,
	recipe_id varchar(255),
	user_id varchar(255),
	PRIMARY KEY (id),
	FOREIGN KEY (recipe_id) REFERENCES Recipe(id),
	FOREIGN KEY (user_id) REFERENCES User(id)

);


CREATE TABLE MealPlanRecipe(
	id varchar(255) NOT NULL,
	mealplan_id varchar(255),
	recipe_id varchar(255),
	PRIMARY KEY (id),
	FOREIGN KEY (mealplan_id) REFERENCES MealPlan(id),
	FOREIGN KEY (recipe_id) REFERENCES Recipe(id)

);

CREATE TABLE RecipeIngredient(
	id varchar(255) NOT NULL,
	recipe_id varchar(255),
	ingredient_id varchar(255),
	quantity int,
	PRIMARY KEY (id),
	FOREIGN KEY (recipe_id) REFERENCES Recipe(id),
	FOREIGN KEY (ingredient_id) REFERENCES Ingredient(id)
);

ALTER TABLE ShoppingList
ADD FOREIGN KEY (id) REFERENCES MealPlan(id);


CREATE TABLE ShoppingListIngredient(
	id varchar(255) NOT NULL,
	shoppinglist_id varchar(255),
	ingredient_id varchar(255),
	quantity int,
	unit varchar(10),
	PRIMARY KEY (id),
	FOREIGN KEY (shoppinglist_id) REFERENCES ShoppingList(id),
	FOREIGN KEY (ingredient_id) REFERENCES Ingredient(id)
);





