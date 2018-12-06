$("#list>li").dragdrop({
  // Drag a clone of the source, and not the actual source element
makeClone: true,
// Class to apply to source element when dragging a clone of the source element
sourceClass: true,
// Specify with true that the source element should hade visibility:hidden while dragging a clone
sourceHide: "cardDeck",
// Class to apply to the element that is dragged
dragClass: "cardDeck",
// Class to apply to the dragged element when dropping is possible
canDropClass: "deckLive",
// Class to apply to the element that is dropped
dropClass: "deckLive",
// is active
isActive: true,
// if set, dragging is limited to this container
container: null,
// Default is to allow all elements to be dragged
canDrag: function($src, event) {
return $src;
},
// Default is to allow dropping inside elements with css stylesheet "drop"
canDrop: function($dst) {
return $dst.hasClass("deckLive") || $dst.parents(".collection").size()>0;
},
// Default is to move the element in the DOM and insert it into the element where it is dropped
didDrop: function($src, $dst) {
$src.appendTo($dst);
}
})};
