# Question 1 : Fonction addToEach
def addToEach(n, liste):
    return [x + n for x in liste]

# Question 2 : Fonction removeDuplicates
def removeDuplicates(liste):
    return list(dict.fromkeys(liste))  # Utilisation d'un dict pour préserver l'ordre