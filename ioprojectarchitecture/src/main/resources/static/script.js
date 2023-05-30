document.getElementById('transformForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var text = document.getElementById('text').value;
    var queueBricks = document.querySelectorAll('#queue .brick');
    var transformations = Array.from(queueBricks).map(function(brick) {
        return brick.textContent.toLowerCase();
    });

    var request = {
        text: text,
        transformations: transformations
    };

    fetch('/transform', {
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

