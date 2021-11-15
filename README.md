# Projet Compilation

## Contributeurs

Ce projet a été réalisé dans le cadre de la formation à TELECOM Nancy par quatre élèves de deuxième année qui sont:    

MASK MASK <<mask@telecomnancy.eu>>   
moi <<mask.mask@telecomnancy.eu>>    
MASK MASK <<mask.mask@telecomnancy.eu>>    
MASK MASK <<mask.mask@telecomnancy.eu>>  

## Encadrants

Suzanne Collin <<suzanne.collin@telecomnancy.eu>>    
Sébastien Da Silva <<sebastien.dasilva@telecomnancy.eu>>    
Gérald Oster <<gerald.oster@telecomnancy.eu>>    

## Présentation

L’objectif de ce projet est d’écrire un compilateur.  

## Lancement

Le compilateur `blood` qui vous est proposé est disponible [ici](./bloody.sh). <br>
Utilisation: <br>
`./bloody.sh <path_to_.blood_file> [OPTIONS]`

Options:
- `-debug` : Affiche le code interprété, la TDS, TDT, Descripteur de classes, Code assembleur, Résultat de l'éxécution, Etat des registres
- `-without_infos` : Affiche seulement le résultat de l'exécution
- sans option l'assembleur compilera, assemblera, et exécutera et à la fin affichera l'état des registres


## Structure du dépôt

Dossier     	    | Contenu
--------------------|---------------------------------
`test/` 	        | Tests d'assemblage dans `assembly/` et **pipelines**
`src/` 		        | Code
`src/../antlr`  	| Passes
`src/../tds`     	| Table des symboles
`src/../tdt`     	| Table des types
`src/../controls`   | Contrôles sémantiques
`src/../assembly`   | Génération de code
`GP/`  			    | Rapport et éléments de GDP
`jar/`  			| `microPIUPK.jar`

## Soutenance
Le [fichier](./test/assembly/quality_tests/presentation.blood) qui vous a été présenté pendant la soutenance récapitule l'ensemble des niveaux évalués.

## Partie 1 : Grammaire et AST
### Lancement de la partie 1

Il faut ouvrir `Antlr`, ouvrir la [grammaire](./src/Grammaire.g) et selectionner l'un des fichiers `.blood` présents dans le répertoire [test](./test). <br>

### Tests de la partie 1

Les différents tests sont recensés dans [la présentation de la soutenance](./PCL1-intermediate.md).


### Rapport

Vous trouverez le rapport de la partie I [ici](./GP/Rapport1.pdf).

## Partie 2
### Contrôles sémantiques et TDS
Vous trouverez le fichier de tests de contrôles sémantique de la soutenance [ici](./test/pres2_controles_semantiques.blood).<br>
Pour lancer les contrôles sémantiques (sur celui cité plus haut et ceux sur les autres fichiers), utiliser les `tasks` de `application`.<br>
Pour lancer le debugger sur les contrôles sémantiques et afficher la TDS, utiliser les `tasks` de `debug`.

Les contrôles sémantiques implémentés sont :

| Contrôle                                                     | Responsable        |
| ------------------------------------------------------------ | ------------------ |
| **Redéclaration**                                            |                    |
| Redéclaration dans le même bloc                              | MASK      |
| Redéclaration de classe                                      | moi |
| Redéclaration de méthode dans le même bloc                   | MASK    |
| **Mots clés du langage**                                     |                    |
| Utilisation de mots clefs réservés                           | MASK      |
| Vérification de l'usage de this et super                     | MASK         |
| L'usage de `result` est interdit dans une méthode qui ne renvoit pas de résultat | MASK    |
| La présence de `result`est vérifiée quand un type de retour est précisé | moi |
| L'usage de `result` est contrôlé :                            | moi |
| - si `result` est présent uniquement  dans un `while` un avertissement est émis| |
| - si `result` est présent uniquement  dans une branche de `if` un avertissement est émis| |
| **Cohérence**                                                |                    |
| Cohérence de types (affectation)                             | MASK    |
| Cohérence de type entre les paramètres formels et effectifs  | MASK    |
| Cohérence de type dans les expressions arithmétiques         | MASK    |
| Cohérence entre type de retour attendu (si attendu) et type de retour  effectif | MASK    |
| Nombre de paramètre formel = nombre de paramètre effectif    | moi |
| Variables déclarées avant utilisation                        | MASK      |
| if(integer) / while(integer)                                 | moi |
| Le type d'une variable/fonction existe                       | MASK         |
| Lors d'un message, la destination existe-t-elle?             | MASK         |
| Division par 0                                               | moi |
| Division par/de choses inapropriées (String)                 | moi |
| Lors d'un override vérifier que la fonction qu'on override existe | MASK         |
| Lors d'un extends vérifier que la classe de laquelle on hérite existe | moi |
| En cas de cast, vérifier que le cast est fait par une superclasse | MASK      |
| **Constructeur**                                             |                    |
| Pas d'usage de result dans les constructeurs                 | MASK         |
| Pas de double déclaration de constructeur                    | moi |
| Constructeur conforme à la définition de classe              | moi |


### Tests de la partie 2

Les différents tests sont recensés dans [le répertoire de tests d'assemblage](./test/assembly). <br>
Les tests sont chacun associés à une task `Gradle` ou lançables collectivement avec les scripts : 
- [tests de build : géneration de code, assemblage et exécution](./test/assembly_and_launch.sh)
- [tests de qualité : géneration de code, assemblage, exécution et vérification du résultat](./test/pipeline_check_permanent_tests_quality.sh)
### Rapport

Vous trouverez le rapport de la partie II [ici](./GP/Rapport2.pdf).
