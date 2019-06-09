// print("Hello, this is testing");
const key = 'b597a1dea2517708cda27cc435a1daca';

function WeatherBalloon(cityName) {
    fetch('https://api.openweathermap.org/data/2.5/weather?q=' + cityName + '&appid=' + key)
        .then(function (resp) {
            return resp.json()
        }) // Convert data to json
        .then(function (data) {
            drawWeather(data);
        })
        .catch(function () {
            // catch any errors
        });
}

function drawWeather(d) {
    return Math.round(((parseFloat(d.main.temp) - 273.15) * 1.8) + 32);

}