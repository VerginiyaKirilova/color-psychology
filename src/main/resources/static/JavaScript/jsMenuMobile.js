/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
document.addEventListener("DOMContentLoaded", function () {
  const menuToggle = document.querySelector(".menu-toggle");
  const mobileNav = document.querySelector(".mobile-nav");

  if (menuToggle && mobileNav) {
    menuToggle.addEventListener("click", function () {
      mobileNav.classList.toggle("active");
    });
  }

  // Подменю с отделен бутон
  const dropdownItems = document.querySelectorAll(".has-dropdown");

  dropdownItems.forEach(item => {
    const toggleIcon = item.querySelector(".toggle-icon");
    const dropdown = item.querySelector(".dropdown");

    if (toggleIcon && dropdown) {
      toggleIcon.addEventListener("click", function (e) {
        e.stopPropagation(); // Не позволява кликът да активира други елементи
        dropdown.classList.toggle("active");
        toggleIcon.textContent = dropdown.classList.contains("active") ? "−" : "+";
      });
    }
  });
});




