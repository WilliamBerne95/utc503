from functools import partial

# Définition du dictionnaire des recettes
recipes = {
    'pizza': {'ingredients': ['farine', 'eau', 'sel', 'levure', 'tomate', 'fromage']},
    'salade': {'ingredients': ['laitue', 'tomate', 'concombre', 'vinaigre', 'huile']},
    'pates_carbonara': {'ingredients': ['pates', 'creme', 'lardons', 'fromage', 'sel', 'poivre']},
    'omelette': {'ingredients': ['oeufs', 'sel', 'poivre', 'fromage']},
    'sandwich_jambon_beurre': {'ingredients': ['pain', 'beurre', 'jambon', 'salade']}
}

# Fonction pure qui vérifie si une recette est faisable avec les ingrédients disponibles
def is_recipe_possible(available_ingredients, recipe):
    required_ingredients = recipes[recipe]['ingredients']
    return all(map(lambda x: x in available_ingredients, required_ingredients))

# Fonction principale utilisant filter et map
def find_possible_recipes(available_ingredients):
    # Création d'une fonction partielle avec les ingrédients disponibles
    checker = partial(is_recipe_possible, available_ingredients)
    
    # Filtrage des recettes possibles
    possible_recipes = filter(checker, recipes.keys())
    
    # Conversion en liste et formatage des noms de recettes
    return list(possible_recipes)

# Fonction de test utilisant map pour traiter plusieurs cas
def test_recipe_finder():
    # Liste de cas de test
    test_cases = [
        ['farine', 'eau', 'sel', 'levure', 'tomate', 'fromage', 'laitue'],
        ['oeufs', 'sel', 'poivre', 'fromage', 'laitue'],
        ['pain', 'beurre', 'jambon', 'salade', 'tomate']
    ]
    
    # Fonction pour formater l'affichage d'un test
    def format_test_result(ingredients):
        result = find_possible_recipes(ingredients)
        return f"\nIngrédients disponibles : {ingredients}\nRecettes possibles : {result if result else 'Aucune'}"
    
    # Application de la fonction de formatage à chaque cas de test
    print(*map(format_test_result, test_cases), sep="\n")

if __name__ == "__main__":
    test_recipe_finder()