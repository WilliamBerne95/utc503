# Question 1.1 : Expression lambda pour le carré de x
carre = lambda x: x * x

# Question 1.2 : Transformer une liste en liste de carrés
nombres = [1, 2, 3, 4, 5]
carres = list(map(lambda x: x * x, nombres))
print("Carrés :", carres)  # Sortie : [1, 4, 9, 16, 25]

# Question 1.3 : Expression lambda pour la somme de deux nombres
addition = lambda a, b: a + b

# Question 1.4 : Réduire la liste à sa somme totale
from functools import reduce
nombres = [1, 2, 3, 4, 5]
total = reduce(lambda a, b: a + b, nombres)
print("Somme :", total)  # Sortie : 15