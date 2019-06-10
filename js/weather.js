// print("Hello, this is testing");
key = 'b597a1dea2517708cda27cc435a1daca';

function weatherBalloon(cityName) {
    var result = "";
    fetch('https://api.openweathermap.org/data/2.5/weather?q=' + cityName + '&appid=' + key)
        .then(function (resp) {
            return resp.json()
        }) // Convert data to json
        .then(function (data) {
            result = drawWeather(data);
        })
        .catch(function () {
            // catch any errors
        });
    print(result);
}

function drawWeather(d) {
    print(Math.round(((parseFloat(d.main.temp) - 273.15) * 1.8) + 32));
}