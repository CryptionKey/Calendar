# Application mobile : CALENDAR

## Développeur (3A)

- Daniel Elgrably


&nbsp;

## Présentation

Simple projet démontrant l'utilisation d'API REST et de recyclerview dans une application android codé en Java.

Cette application affiche le calendrier des chabbats et fêtes juives en utilisant l'API suivante disponible sur Github : "https://www.hebcal.com/home/195/jewish-calendar-rest-api". Par ailleurs, toujours avec cette API, nous pouvons afficher les montées du chabat. En effet, chaque chabbat, nous lisons une section des livres du pentateuque, de façons à les finir en un ans. Cette section est subdivisée en 7 montées (sous section). Enfin, le "maftir" reprend les derniers versets de la septième montée. Puis la haftarah est constituée d'un passage tiré des livres des prophètes. 


&nbsp;

## Prérequis

- Installation d'Android Studio</br>
Ce projet est le premier que nous réalisons sous Android Studio, il n'y avait donc pas d'autres prérequis.


&nbsp;

## Consignes respectées : 

- Deux écrans; trois activités
- Appels WebService à une API Rest
- Architecture MVC
- Animation entre deux écrans


&nbsp;

## Fonctionnalités: 

### Premier écran 

- Splash affichant une pokeball.

<img src="img_readme/splash.png" alt="splash">

### Ecran Home 

- Affiche la liste des pokémons avec une barre de recherche.

<img src="img_readme/liste_pokemon.png" alt="liste pokemon">   <img src="img_readme/recherche.png" alt="recherche">

### Ecran du détail du pokémon

- Affiche les différentes informations sur le pokémon 
- Puces type, weaknesses, previous evolution et next evolution sont cliquables 
- Redirection en fonction de la puce  :
	- Type, weaknesses : Vers la liste des pokémons du type selectionné 
	- Evolution : Vers le détail du pokémon selectionné

<img src="img_readme/detail_pokemon.png" alt="détail pokemon"> <img src="img_readme/detail_pokemon_2.png" alt="détail pokemon"> 

### Filtres 

Affichage obtenu avec la selection des types eau et plante

<img src="img_readme/filtre_eau.png" alt="détail pokemon"> <img src="img_readme/filtre_plante.png" alt="détail pokemon"> 
