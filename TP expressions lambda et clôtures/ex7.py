# Question 1 : Fonction de mémorisation
def memoize(fonction):
    cache = {}
    def fonction_memo(*args):
        if args not in cache:
            cache[args] = fonction(*args)
        return cache[args]
    return fonction_memo

# Question 2 : Test avec factorielle et fibonacci
import time

@memoize
def factorielle(n):
    if n <= 1:
        return 1
    return n * factorielle(n-1)

@memoize
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

# Test de performance
def tester_performance(fonction, argument, iterations):
    debut = time.time()
    for _ in range(iterations):
        fonction(argument)
    fin = time.time()
    return fin - debut

print("Temps pour factorielle(10) répété:", 
      tester_performance(factorielle, 10, 1000))
print("Temps pour fibonacci(10) répété:", 
      tester_performance(fibonacci, 10, 1000))