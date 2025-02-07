from dataclasses import dataclass
from typing import List
import asyncio
import random

# Question 1 : Structure Personne immuable
@dataclass(frozen=True)
class Personne:
    nom: str
    age: int

# Question 2 : Fonction anniversaire
def anniversaire(personnes: List[Personne]) -> List[Personne]:
    return [Personne(p.nom, p.age + 1) for p in personnes]

# Question 3 et 4 : Promesses avec async/await
async def getRandomNumber():
    await asyncio.sleep(1)  # Délai d'une seconde
    return random.randint(1, 100)

async def main():
    # Générer deux nombres aléatoires en parallèle
    nombre1, nombre2 = await asyncio.gather(
        getRandomNumber(),
        getRandomNumber()
    )
    print(f"Nombres aléatoires : {nombre1}, {nombre2}")

# Pour exécuter le code asynchrone
if __name__ == "__main__":
    asyncio.run(main())