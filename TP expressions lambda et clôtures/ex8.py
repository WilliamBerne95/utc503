# Question 3 : Fonction de calcul de réduction
def calculer_reduction(produits, fonction_reduction):
    return sum(fonction_reduction(prix) for prix in produits)

# Question 4 : Appliquer une réduction de 20%
produits = [100, 200, 300, 400, 500]  # Prix exemple
reduction_20 = lambda prix: prix * 0.8  # Fonction de réduction de 20%

total_apres_reduction = calculer_reduction(produits, reduction_20)
print(f"Total après réduction de 20% : {total_apres_reduction}€")

# Affichage du total original pour comparaison
total_original = sum(produits)
print(f"Total original : {total_original}€")
print(f"Économies : {total_original - total_apres_reduction}€")