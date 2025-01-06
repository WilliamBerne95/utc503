from functools import reduce

# Liste des prix en euros
prix_euros = [50, 20, 35, 100, 80]

# Conversion en dollars
prix_dollars = list(map(lambda x: x * 1.10, prix_euros))

# Challenge supplémentaire : ajout du symbole $
prix_dollars_symbole = list(map(lambda x: f"${x:.2f}", prix_dollars))

print("Prix en euros:", prix_euros)
print("Prix en dollars:", prix_dollars)
print("Prix en dollars avec symbole:", prix_dollars_symbole)