# Projet LETTER GAME - RACHEDI Zakaria et SARFARAZ Momin 4A CFA

Dans le but de répondre au sujet du projet, nous avons développé le jeu "Letters Game". Ce jeu qui se joue en ligne de commande a été développé par : </br>
- `M.RACHEDI Zakaria`
- `M.SARFARAZ Ahmed-Momin`

## Choix des technologies et de l'extension imposée

Comme recommandé dans l'énoncé, nous sommes partis sur "Gradle" pour la gestion de nos dépendances. Pour l'extension, nous avons décidé de créer une IA pour le J-VS-IA. Cela s'est révélé intéressant et un vrai challenge de répondre à la problématique  `comment réagir, en fonction de J1 ?`. Le problème n'a pas été des plus simples, surtout pour la recherche des combinaisons possibles et valides à former avec les lettres du pot commun pour l'IA. 

## Design pattern utilisé

Pour pouvoir jouer à plusieurs au `Letters Game`, il faut placer un pot commun accessible par tous les joueurs. Dans ce cadre, nous avons créer une classe [`CommonPot`](src/main/java/CommonPot.java). Nous avons décidé d'appliquer le design pattern `Singleton` à cette classe. Mais pourquoi ?</br>
Simplement car cette classe doit rester :

1. `Statique`
2. `Accessible par tous`
3. `Modifiable par tous`

Le `Singleton` répondait parfaitement à ces critères. Ainsi chaque joueur accèdera à la même instance de la classe [`CommonPot`](src/main/java/CommonPot.java) et pourra la modifier. Cette modification sera visible et effective pour tous les joueurs (résultat souhaité).

## Architecture du projet

Notre code a été découpé selon les classes suivantes : 
* Stock</br> 
```
Nous considérons que tout ce qui tend au stock de lettre devait être dans un package différent
```
* Game</br> 
```
Ce sont toutes les classes liées au cycle de jeu et au tours de jeu.
```
* Players</br> 
```
Les classes liées à la gestion de chaque joueur et de l'IA, donc ses mots, ses lettres, ses points et son tour de jeu.
```

## Démarrer avec le projet

to fill

## En cas de non fonctionnement ou en cas d'erreurs

to fill
