# Définition du dictionnaire des recettes
recipes = {
    'pizza': {'ingredients': ['farine', 'eau', 'sel', 'levure', 'tomate', 'fromage']},
    'salade': {'ingredients': ['laitue', 'tomate', 'concombre', 'vinaigre', 'huile']},
    'pates_carbonara': {'ingredients': ['pates', 'creme', 'lardons', 'fromage', 'sel', 'poivre']},
    'omelette': {'ingredients': ['oeufs', 'sel', 'poivre', 'fromage']},
    'sandwich_jambon_beurre': {'ingredients': ['pain', 'beurre', 'jambon', 'salade']}
}

def find_possible_recipes(available_ingredients):
    possible_recipes = []
    
    # Parcours de toutes les recettes
    for recipe_name, recipe_info in recipes.items():
        can_make = True
        required_ingredients = recipe_info['ingredients']
        
        # Vérification de chaque ingrédient requis
        for ingredient in required_ingredients:
            if ingredient not in available_ingredients:
                can_make = False
                break
        
        # Si tous les ingrédients sont disponibles, ajouter la recette
        if can_make:
            possible_recipes.append(recipe_name)
    
    return possible_recipes

# Test du programme
def test_recipe_finder():
    # Test avec différents ensembles d'ingrédients
    test_cases = [
        ['farine', 'eau', 'sel', 'levure', 'tomate', 'fromage', 'laitue'],
        ['oeufs', 'sel', 'poivre', 'fromage', 'laitue'],
        ['pain', 'beurre', 'jambon', 'salade', 'tomate']
    ]
    
    for ingredients in test_cases:
        print(f"\nIngrédients disponibles : {ingredients}")
        possible_recipes = find_possible_recipes(ingredients)
        if possible_recipes:
            print("Recettes possibles :")
            for recipe in possible_recipes:
                print(f"- {recipe}")
        else:
            print("Aucune recette possible avec ces ingrédients")

if __name__ == "__main__":
    test_recipe_finder()