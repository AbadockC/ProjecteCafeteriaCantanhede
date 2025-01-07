package com.abadock.projectecafeteriacantanhede.data

class FoodData {

    companion object {

        val FoodList: List<FoodModel> = listOf(
            FoodModel(12.4,"Croissant", "gluten", FoodType.MENJAR),
            FoodModel(12.4,"Croissant de nueces", "gluten, nueces",FoodType.MENJAR),
            FoodModel(12.4,"Croissant", "gluten",FoodType.MENJAR),
            FoodModel(12.4,"Croissant de nueces", "gluten, nueces",FoodType.MENJAR),
            FoodModel(12.4,"Croissant", "gluten",FoodType.MENJAR),
            FoodModel(12.4,"Croissant de nueces", "gluten, nueces",FoodType.MENJAR),
            FoodModel(12.4,"Croissant", "gluten",FoodType.MENJAR),
            FoodModel(12.4,"Croissant de nueces", "gluten, nueces",FoodType.MENJAR),
            FoodModel(12.4,"Croissant", "gluten",FoodType.MENJAR),
            FoodModel(12.4,"Croissant de nueces", "gluten, nueces",FoodType.MENJAR),
            FoodModel(12.4,"Croissant de nueces", "gluten, nueces",FoodType.MENJAR),
            FoodModel(12.4,"Croissant", "gluten",FoodType.MENJAR),
            FoodModel(12.4,"Croissant de nueces", "gluten, nueces",FoodType.MENJAR),
            FoodModel(12.4,"Croissant", "gluten",FoodType.MENJAR),
            FoodModel(3.2, "cafe con leche", "Lactosa", FoodType.BEGUDA),
            FoodModel(3.0, "Sumo de naranja", "", FoodType.POSTRE),
            FoodModel(3.2, "cafe con leche", "Lactosa", FoodType.BEGUDA),
            FoodModel(3.0, "Sumo de naranja", "", FoodType.POSTRE),
            FoodModel(3.2, "cafe con leche", "Lactosa", FoodType.BEGUDA),
            FoodModel(3.0, "Sumo de naranja", "", FoodType.POSTRE),
            FoodModel(3.2, "cafe con leche", "Lactosa", FoodType.BEGUDA),
            FoodModel(3.0, "Sumo de naranja", "", FoodType.POSTRE),
            FoodModel(3.2, "cafe con leche", "Lactosa", FoodType.BEGUDA),
            FoodModel(3.0, "Sumo de naranja", "", FoodType.POSTRE),

        )

        fun loadFood() : List<FoodModel>{
            return FoodList
        }

        val instance: FoodData by lazy {FoodData()}
    }


}