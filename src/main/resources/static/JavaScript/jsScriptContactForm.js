/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("contactForm").addEventListener("submit", function (event) {
        event.preventDefault(); // Спира презареждането на страницата

        let name = document.getElementById("fname").value.trim();
        let lname = document.getElementById("lname").value.trim();
        let email = document.getElementById("email").value.trim();
        let country = document.getElementById("country").value.trim();
        let message = document.getElementById("subject").value.trim();
        let responseMessage = document.getElementById("response");

        if (responseMessage) { // Проверка дали елементът съществува
            responseMessage.style.display = "block"; // Показва съобщението

            if (name === "" || lname === "" || email === "" || country === "" || message === "") {
                responseMessage.innerText = "Моля, попълнете всички полета!";
                responseMessage.style.color = "red";
            } else {
                responseMessage.innerText = "Формата е изпратена успешно!";
                responseMessage.style.color = "green";

                // Изчистване на полетата
                document.getElementById("contactForm").reset();
            }
        } else {
            console.error("Елементът #response не е намерен в DOM.");
        }
    });
});
