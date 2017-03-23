<h1>Pokedeck</h1>

<h3>Application</h3>
Le programme ouvre une interface graphique crée avec la libraire Swing. Cette première fenêtre possède des boutons permettant 
d’ajouter une carte, de la supprimer, de la mettre à jour, de consulter l’ensemble des cartes et de rechercher des cartes en les 
filtrant par type ou par stade. Chaque bouton ouvre une nouvelle fenêtre permettant d’effectuer l’action correspondante. 
Toutes les modifications sont automatiquement sauvegardées dans le fichier tmp.data à la fermeture du programme.

<h3>Classes :</h3>
<p>Main : Permet de lancer le programme, de lire les éléments sauvegardés et d’ouvrir une fenêtre.</p>
<p>Card : Permet de créer des objets cartes constitué d’un nom, d’un type, d’un stade (niveau), d’une valeur de points de vie 
et d’une évolution. </p>
<p>Event : Contient les fonctions permettant d’ajouter une carte Pokémon, de la supprimer, de la mettre à jour, 
de consulter sa collection de cartes et de rechercher une carte par critères.</p>
<p>Close : permet de quitter le programme et de sauvegarder les modifications.</p>

<h3>Problèmes rencontrés :</h3>
J’ai trouvé que c’était un peu laborieux d’ajouter ou de modifier des éléments sur l’interface graphique au fur et mesure de l’utilisation et des actions réalisées. Pour ne pas perdre trop de temps avec l’interface graphique, étant donné que le sujet imposait seulement à ce qu’on utilise la librairie Swing, j’ai utilisé une nouvelle fenêtre pour chaque fonctionnalité et j’ai utilisé les boîtes de dialogues pour afficher des messages à l’utilisateur.
La serialization pour sauvegarder les cartes dans un fichier a été difficile à mettre en place étant donné que je n’ai pas choisi une structure appropriée au tout début.





