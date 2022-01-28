CREATE TABLE test_recipe
(
    recipe_seq        NUMBER(15, 0)    NOT NULL, 
    recipe_name       VARCHAR2(50)     NOT NULL, 
    food_type         VARCHAR2(20)     NOT NULL, 
    recipe_weather    VARCHAR2(200)    NOT NULL, 
    recipe_calory     NUMBER(15, 0)   , 
    recipe_date       DATE             DEFAULT SYSDATE NOT NULL, 
    carbohydrate      NUMBER(15, 1)    , 
    protein           NUMBER(15, 1)   , 
    fat               NUMBER(15, 1)   , 
    calcium           NUMBER(15, 1)    , 
    sodium            NUMBER(15, 1)    , 
     PRIMARY KEY (recipe_seq)
)
/

CREATE SEQUENCE test_recipe_SEQ
START WITH 1
INCREMENT BY 1;
/

insert into test_recipe
values(test_recipe_SEQ.nextval,'가지냉국','한식','맑음',73,SYSDATE,123.1,123.2,123.3,123.4,12.3)
