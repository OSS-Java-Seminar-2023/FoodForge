CREATE TABLE User
(
    id       UUID NOT NULL,
    role     varchar(20),
    username varchar(30),
    email    varchar(30),
    passwd   varchar(60),
    PRIMARY KEY (id)
);

CREATE TABLE Ingredient
(
    id              UUID NOT NULL,
    ingredient_name varchar(40),
    unit            varchar(10),
    PRIMARY KEY (id)
);



CREATE TABLE ShoppingList
(
    id                UUID NOT NULL,
    shoppinglist_name varchar(30)
);



CREATE TABLE Recipe
(
    id         UUID NOT NULL,
    title      varchar(30),
    details    text,
    difficulty varchar(30),
    prep_time  smallint,
    user_id    UUID,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES User (id)
);

CREATE TABLE MealPlan
(
    id        UUID NOT NULL,
    plan_name varchar(20),
    details   text,
    plan_date date,
    user_id   UUID,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES User (id)

);


CREATE TABLE Review
(
    id          UUID NOT NULL,
    details     text,
    score       tinyint,
    review_date date,
    recipe_id   UUID,
    user_id     UUID,
    PRIMARY KEY (id),
    FOREIGN KEY (recipe_id) REFERENCES Recipe (id),
    FOREIGN KEY (user_id) REFERENCES User (id)

);


CREATE TABLE MealPlanRecipe
(
    id          UUID NOT NULL,
    mealplan_id UUID,
    recipe_id   UUID,
    PRIMARY KEY (id),
    FOREIGN KEY (mealplan_id) REFERENCES MealPlan (id),
    FOREIGN KEY (recipe_id) REFERENCES Recipe (id)

);

CREATE TABLE RecipeIngredient
(
    id            UUID NOT NULL,
    recipe_id     UUID,
    ingredient_id UUID,
    quantity      int,
    PRIMARY KEY (id),
    FOREIGN KEY (recipe_id) REFERENCES Recipe (id),
    FOREIGN KEY (ingredient_id) REFERENCES Ingredient (id)
);

ALTER TABLE ShoppingList
    ADD FOREIGN KEY (id) REFERENCES MealPlan (id);


CREATE TABLE ShoppingListIngredient
(
    id              UUID NOT NULL,
    shoppinglist_id UUID,
    ingredient_id   UUID,
    quantity        int,
    unit            varchar(10),
    PRIMARY KEY (id),
    FOREIGN KEY (shoppinglist_id) REFERENCES ShoppingList (id),
    FOREIGN KEY (ingredient_id) REFERENCES Ingredient (id)
);

