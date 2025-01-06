from functools import reduce

# Exemple de données
employes = [
    {"nom": "dupont", "age": 35, "salaire": 45000},
    {"nom": "martin", "age": 42, "salaire": 55000},
    {"nom": "durand", "age": 28, "salaire": 35000}
]

# Convertir les noms en majuscules
noms_maj = list(map(lambda x: {**x, "nom": x["nom"].upper()}, employes))

# Filtrer les employés avec salaire > 50000
salaires_eleves = list(filter(lambda x: x["salaire"] > 50000, employes))

# Calculer le salaire total des employés filtrés
salaire_total = reduce(lambda x, y: x + y["salaire"], salaires_eleves, 0)

# Challenge supplémentaire : ajouter la catégorie
def categoriser_salaire(employe):
    salaire = employe["salaire"]
    if salaire < 30000:
        categorie = "junior"
    elif salaire <= 50000:
        categorie = "intermédiaire"
    else:
        categorie = "senior"
    return {**employe, "categorie": categorie}

employes_categories = list(map(categoriser_salaire, employes))

print("Employés avec noms en majuscules:", noms_maj)
print("Employés avec salaire élevé:", salaires_eleves)
print("Salaire total des employés filtrés:", salaire_total)
print("Employés avec catégories:", employes_categories)