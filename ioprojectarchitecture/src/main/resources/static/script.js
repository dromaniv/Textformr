
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

document.getElementById('transformForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var text = document.getElementById('text').value;
    var queueBricks = document.querySelectorAll('#queue .brick');
    var transformations = Array.from(queueBricks).map(function(brick) {
        return brick.textContent;
    });

    var request = {
        text: text,
        transformations: transformations
    };

    fetch('http://localhost:8080/transform', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(request)
    })
        .then(response => response.text())
        .then(data => document.getElementById('result').innerText = data)
        .catch((error) => console.error('Error:', error));
});

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