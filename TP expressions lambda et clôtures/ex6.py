# Question 1 : Fonction filterMap
def filterMap(fonction_filtre, fonction_transformation, liste):
    return list(map(fonction_transformation, filter(fonction_filtre, liste)))

# Question 2 : Exemple d'utilisation avec des chaînes
chaines = ["", "bonjour", "monde", "", "python", "  "]
resultat = filterMap(
    lambda x: len(x.strip()) > 0,  # filtre les chaînes non vides
    lambda x: x.upper(),           # transforme en majuscules
    chaines
)
print("Chaînes filtrées et transformées:", resultat)