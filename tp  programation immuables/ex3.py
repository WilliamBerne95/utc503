from dataclasses import dataclass
from typing import List, Dict, Optional
from decimal import Decimal

@dataclass(frozen=True)
class Article:
    nom: str
    prix: Decimal
    quantite: int

@dataclass(frozen=True)
class LigneCommande:
    article: Article
    quantite: int

@dataclass(frozen=True)
class Commande:
    lignes: List[LigneCommande]

@dataclass(frozen=True)
class Promotion:
    nom: str
    montant_minimum: Decimal
    reduction_pourcentage: Decimal

class Inventaire:
    def __init__(self):
        self._articles: Dict[str, Article] = {}

    def ajouter_article(self, article: Article) -> 'Inventaire':
        nouveau_inventaire = Inventaire()
        nouveau_inventaire._articles = self._articles.copy()
        nouveau_inventaire._articles[article.nom] = article
        return nouveau_inventaire

    def mettre_a_jour_quantite(self, nom_article: str, nouvelle_quantite: int) -> 'Inventaire':
        if nom_article not in self._articles:
            return self
        
        article = self._articles[nom_article]
        nouveau_inventaire = Inventaire()
        nouveau_inventaire._articles = self._articles.copy()
        nouveau_inventaire._articles[nom_article] = Article(
            nom=article.nom,
            prix=article.prix,
            quantite=nouvelle_quantite
        )
        return nouveau_inventaire

def calculer_montant_commande(commande: Commande, inventaire: Inventaire) -> Decimal:
    return sum(
        ligne.quantite * inventaire._articles[ligne.article.nom].prix
        for ligne in commande.lignes
    )

def appliquer_promotions(
    montant: Decimal,
    promotions: List[Promotion]
) -> Decimal:
    for promotion in promotions:
        if montant >= promotion.montant_minimum:
            montant = montant * (1 - promotion.reduction_pourcentage / 100)
    return montant