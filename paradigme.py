# Partie 1 : Saisie des données
def saisir_donnees():
    noms = []
    notes = []

    nb_etudiants = int(input("Combien d'étudiants souhaitez-vous saisir ? "))

    for i in range(nb_etudiants):
        nom = input(f"Nom de l'étudiant {i + 1} : ")
        note = float(input(f"Note de {nom} : "))
        noms.append(nom)
        notes.append(note)

    return noms, notes


# Partie 2 : Calcul de la moyenne
def calculer_moyenne(notes):
    return round(sum(notes) / len(notes), 2)


# Partie 3 : Répartition des étudiants
def afficher_repartition(noms, notes):
    reussite = [noms[i] for i in range(len(noms)) if notes[i] >= 10]
    echec = [noms[i] for i in range(len(noms)) if notes[i] < 10]

    print("Étudiants ayant réussi :", ", ".join(reussite))
    print("Étudiants en échec :", ", ".join(echec))


# Partie 4 : Meilleure note
def meilleure_note(noms, notes):
    index_max = notes.index(max(notes))
    print(f"L'étudiant ayant la meilleure note est {noms[index_max]} avec {notes[index_max]}.")


# Extensions
def trier_etudiants(noms, notes):
    etudiants = list(zip(noms, notes))
    etudiants.sort(key=lambda x: x[1], reverse=True)
    print("\nClassement des étudiants :")
    for i, (nom, note) in enumerate(etudiants, 1):
        print(f"{i}. {nom} : {note}")


def rechercher_etudiant(noms, notes):
    nom_recherche = input("\nEntrez le nom de l'étudiant à rechercher : ")
    if nom_recherche in noms:
        index = noms.index(nom_recherche)
        print(f"Note de {nom_recherche} : {notes[index]}")
    else:
        print("Étudiant non trouvé.")


def main():
    noms, notes = saisir_donnees()

    moyenne = calculer_moyenne(notes)
    print(f"\nLa moyenne de la classe est de {moyenne}.")

    afficher_repartition(noms, notes)

    meilleure_note(noms, notes)

    choix = input("\nSouhaitez-vous trier et rechercher des etudiants (O/N) ? ").upper()
    if choix == 'O':
        trier_etudiants(noms, notes)
        rechercher_etudiant(noms, notes)


if __name__ == "__main__":
    main()