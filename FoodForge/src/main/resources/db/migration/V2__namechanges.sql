ALTER TABLE Ingredient
RENAME COLUMN ingredient_id TO id;

ALTER TABLE Recipe
RENAME COLUMN recipe_id TO id;

ALTER TABLE ShoppingList
RENAME COLUMN mealplan_id TO id;

ALTER TABLE Users
RENAME COLUMN user_id TO id;

ALTER TABLE MealPlan
RENAME COLUMN mealplan_id TO id;

ALTER TABLE Review
RENAME COLUMN review_id TO id;


