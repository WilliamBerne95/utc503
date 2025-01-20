% Faits sur les hommes et femmes
homme(jean).
homme(jacques).
homme(paul).
homme(marc).
femme(marie).
femme(julie).
femme(sophie).
femme(lisa).

% Relations parent
parent(jean, paul).
parent(marie, paul).
parent(jean, sophie).
parent(marie, sophie).
parent(jacques, jean).
parent(julie, jean).
parent(marc, lisa).

% Règles pour père et mère
pere(X, Y) :- homme(X), parent(X, Y).
mere(X, Y) :- femme(X), parent(X, Y).

% Exercice 2 : Règle pour les grands-parents
grand_parent(X, Y) :- parent(X, Z), parent(Z, Y).

% Exercice 3 : Règle pour les frères et sœurs
frere_soeur(X, Y) :- 
    parent(P, X), 
    parent(P, Y), 
    X \= Y.

% Exercice 6 : Longueur d'une liste
longueur([], 0).
longueur([_|Queue], N) :- 
    longueur(Queue, N1), 
    N is N1 + 1.

% Exercice 7 : Trouver un élément dans une liste
membre(X, [X|_]).
membre(X, [_|Queue]) :- membre(X, Queue).

% Exercice 8 : Règle pour les oncles et tantes
oncle_tante(X, Y) :- 
    parent(P, Y),           % P est parent de Y
    frere_soeur(X, P).      % X est frère/sœur de P

% Exercice 9 : Relations pour les cousins
cousin(X, Y) :- 
    parent(P1, X),          % P1 est parent de X
    parent(P2, Y),          % P2 est parent de Y
    frere_soeur(P1, P2).    % P1 et P2 sont frère/sœur