# Question 2.1 : Créer une fonction multiplicateur
def creer_multiplicateur(n):
    return lambda x: x * n

# Question 2.2 : Créer les fonctions double et triple
double = creer_multiplicateur(2)
triple = creer_multiplicateur(3)

# Question 2.3 : Tester les fonctions
print("Double de 5 :", double(5))  # Sortie : 10
print("Triple de 5 :", triple(5))  # Sortie : 15