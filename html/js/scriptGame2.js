
(function() {
  var dndHandler2 = {

    draggedElement: null, // Propriété pointant vers l'élément en cours de déplacement

    applyDragEvents: function(element2) {

      element2.cardPict = true;

      var dndHandler2 = this; // Cette variable est nécessaire pour que l'événement « dragstart » ci-dessous accède facilement au namespace « dndHandler »

      element2.addEventListener('dragstart', function(e2) {
        dndHandler2.draggedElement = e2.target; // On sauvegarde l'élément en cours de déplacement
        e.dataTransfer.setData('text/plain', ''); // Nécessaire pour Firefox
      });

    },

    applyDropEvents: function(dropper2) {

      dropper2.addEventListener('dragover', function(e2) {
        e2.preventDefault(); // On autorise le drop d'éléments
        this.className = 'cardBoard2 drop_hover'; // Et on applique le style adéquat à notre zone de drop quand un élément la survole
      });

      dropper2.addEventListener('dragleave', function() {
        this.className = 'cardBoard2'; // On revient au style de base lorsque l'élément quitte la zone de drop
      });

      var dndHandler2 = this; // Cette variable est nécessaire pour que l'événement « drop » ci-dessous accède facilement au namespace « dndHandler »

      dropper2.addEventListener('drop', function(e2) {

        var target2 = e2.target,
          draggedElement2 = dndHandler2.draggedElement, // Récupération de l'élément concerné
          clonedElement2 = draggedElement2.cloneNode(true); // On créé immédiatement le clone de cet élément

        while (target2.className.indexOf('cardBoard2') == -1) { // Cette boucle permet de remonter jusqu'à la zone de drop parente
          target2 = target2.parentNode;
        }

        target2.className = 'cardBoard2'; // Application du style par défaut

        clonedElement2 = target2.appendChild(clonedElement2); // Ajout de l'élément cloné à la zone de drop actuelle
        dndHandler2.applyDragEvents(clonedElement2); // Nouvelle application des événements qui ont été perdus lors du cloneNode()

        draggedElement2.parentNode.removeChild(draggedElement2); // Suppression de l'élément d'origine

      });

    }

  };

  var elements2 = document.querySelectorAll('.cardPict2'),
    elementsLen2 = elements2.length;

  for (var i = 0; i < elementsLen2; i++) {
    dndHandler2.applyDragEvents(elements2[i]); // Application des paramètres nécessaires aux éléments déplaçables
  }

  var droppers2 = document.querySelectorAll('.cardBoard2'),
    droppersLen2 = droppers2.length;

  for (var i = 0; i < droppersLen2; i++) {
    dndHandler2.applyDropEvents(droppers2[i]); // Application des événements nécessaires aux zones de drop
  }

})();
