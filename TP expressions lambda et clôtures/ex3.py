# Question 3.1 : Définir une liste de mots
mots = ["ananas", "banane", "avocat", "raisin", "abricot", "myrtille"]

# Question 3.2 : Filtrer les mots commençant par 'a'
mots_a = list(filter(lambda x: x.startswith('a'), mots))
print("Mots commençant par 'a' :", mots_a)

# Question 3.3 : Compter les mots de plus de 5 caractères
def creer_compteur_longueur(longueur_min):
    compteur = 0
    def compteur_interne(mot):
        nonlocal compteur
        if len(mot) > longueur_min:
            compteur += 1
        return compteur
    return compteur_interne

compteur_longueur = creer_compteur_longueur(5)
for mot in mots:
    compteur_longueur(mot)
print("Mots de plus de 5 caractères :", compteur_longueur(""))