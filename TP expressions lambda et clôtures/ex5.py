# Question 1 : Fonction de composition
def composer(f, g):
    return lambda x: f(g(x))

# Question 2 : Test avec des expressions lambda d'exemple
carre = lambda x: x * x
double = lambda x: x * 2

# Composer les fonctions (d'abord double, puis carré)
carre_du_double = composer(carre, double)
print("Carré du double de 3:", carre_du_double(3))  # Sortie: 36 (car (3*2)²)