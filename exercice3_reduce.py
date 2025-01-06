from functools import reduce

# Liste des ventes
ventes = [120, 50, 30, 20, 90, 100]

# Calculer le total des ventes
total_ventes = reduce(lambda x, y: x + y, ventes)

# Challenge supplémentaire : calculer le produit
produit = reduce(lambda x, y: x * y, ventes)

print("Liste des ventes:", ventes)
print("Total des ventes:", total_ventes)
print("Produit des ventes:", produit)