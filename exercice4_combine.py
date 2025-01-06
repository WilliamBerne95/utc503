from functools import reduce

# Liste des notes
notes = [12, 15, 9, 18, 6, 20, 14]

# Conversion sur 100
notes_100 = list(map(lambda x: x * 5, notes))

# Filtrer les notes ≥ 50
notes_reussies = list(filter(lambda x: x >= 50, notes_100))

# Calculer la moyenne
moyenne = reduce(lambda x, y: x + y, notes_reussies) / len(notes_reussies)

print("Notes sur 20:", notes)
print("Notes sur 100:", notes_100)
print("Notes réussies (≥ 50):", notes_reussies)
print(f"Moyenne des notes réussies: {moyenne:.2f}")