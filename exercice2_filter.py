# Liste des âges
ages = [12, 25, 17, 18, 40, 15, 22]

# Filtrer les adultes (≥ 18 ans)
adultes = list(filter(lambda x: x >= 18, ages))

# Challenge supplémentaire : filtrer les seniors (≥ 60 ans)
ages_test_seniors = [65, 45, 70, 18, 80, 25, 62]
seniors = list(filter(lambda x: x >= 60, ages_test_seniors))

print("Tous les âges:", ages)
print("Adultes:", adultes)
print("Seniors:", seniors)