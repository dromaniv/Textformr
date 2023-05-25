// JS for drag and drop functionality as well as clearing the queue
var bricks = document.querySelectorAll('.brick');
var queue = document.getElementById('queue');

bricks.forEach(function(brick) {
    brick.addEventListener('dragstart', function(event) {
        event.dataTransfer.setData('text/plain', event.target.innerText);
        event.target.classList.add('selected');
    });

    brick.addEventListener('dragend', function(event) {
        event.target.classList.remove('selected');
    });
});

function allowDrop(event) {
    event.preventDefault();
}

function drop(event) {
    event.preventDefault();
    var transformation = event.dataTransfer.getData('text/plain');
    var brick = document.createElement('div');
    brick.className = 'brick';
    brick.textContent = transformation;
    queue.appendChild(brick);
}


var clearQueueButton = document.getElementById('clearQueueButton');
clearQueueButton.addEventListener('click', function() {
    clearQueue();
});

function clearQueue() {
    var queue = document.getElementById('queue');
    while (queue.firstChild) {
        queue.firstChild.remove();
    }
}