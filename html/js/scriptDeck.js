

// --------------------------------------------drag and drop-----------------------------------------------------------
(function() {

  var dndHandler = {

    draggedElement: null, // Propriété pointant vers l'élément en cours de déplacement

    applyDragEvents: function(element) {

      element.cardPict = true;

      var dndHandler = this; // Cette variable est nécessaire pour que l'événement « dragstart » ci-dessous accède facilement au namespace « dndHandler »

      element.addEventListener('dragstart', function(e) {
        dndHandler.draggedElement = e.target; // On sauvegarde l'élément en cours de déplacement
        e.dataTransfer.setData('text/plain', ''); // Nécessaire pour Firefox
      });

    },

    applyDropEvents: function(deckLive) {

      deckLive.addEventListener('dragover', function(e) {
        e.preventDefault(); // On autorise le drop d'éléments
        this.className = 'deckLive drop_hover'; // Et on applique le style adéquat à notre zone de drop quand un élément la survole
      });

      deckLive.addEventListener('dragleave', function() {
        this.className = 'deckLive'; // On revient au style de base lorsque l'élément quitte la zone de drop
      });

      var dndHandler = this; // Cette variable est nécessaire pour que l'événement « drop » ci-dessous accède facilement au namespace « dndHandler »

      deckLive.addEventListener('drop', function(e) {

        var target = e.target,
          draggedElement = dndHandler.draggedElement, // Récupération de l'élément concerné
          clonedElement = draggedElement.cloneNode(true); // On créé immédiatement le clone de cet élément

        while (target.className.indexOf('deckLive') == -1) { // Cette boucle permet de remonter jusqu'à la zone de drop parente
          target = target.parentNode;
        }

        target.className = 'deckLive'; // Application du style par défaut

        clonedElement = target.appendChild(clonedElement); // Ajout de l'élément cloné à la zone de drop actuelle
        dndHandler.applyDragEvents(clonedElement); // Nouvelle application des événements qui ont été perdus lors du cloneNode()

        // draggedElement.parentNode.removeChild(draggedElement); // Suppression de l'élément d'origine

      });

    }

  };

  var elements = document.querySelectorAll('.cardDeck'),
    elementsLen = elements.length;

  for (var i = 0; i < elementsLen; i++) {
    dndHandler.applyDragEvents(elements[i]); // Application des paramètres nécessaires aux éléments déplaçables
  }

  var deckLives = document.querySelectorAll('.deckLive'),
    deckLivesLen = deckLives.length;

  for (var i = 0; i < deckLivesLen; i++) {
    dndHandler.applyDropEvents(deckLives[i]); // Application des événements nécessaires aux zones de drop
  }

})();
