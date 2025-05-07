
/*Деклариране на глобални променливи за индекс на слайдовете и списък със слайдове*/
let slideIndex = 0;
let slides;

document.addEventListener("DOMContentLoaded", function () {
    /*Вземане на всички елементи със селектор .slide */
    slides = document.querySelectorAll(".slide");
    /*Проверка дали има налични слайдове*/
    if (slides.length === 0) {
        console.log("Слайдърът не съществува на тази страница.");
        return;
    }
    /*Намиране на бутоните за навигазия < >*/
    let prevButton = document.querySelector(".prev");
    let nextButton = document.querySelector(".next");
    /*Добавяне на клик върху бутона, за да сменяме слайда */
    if (prevButton && nextButton) {
        prevButton.addEventListener("click", () => changeSlide(-1));
        nextButton.addEventListener("click", () => changeSlide(1));
    }
    /*Стартира авотматичната смяна на слйдовете */
    showSlides();
});
/*Автоматично преминаване към следващият слайд на всеки 3секунди*/
function showSlides() {
    /*Скриване на слайдовете */
    slides.forEach(slide => slide.style.display = "none");
    /*Увеличава индекса с 1-ца когато стигне края, за да се върне в началото */
    slideIndex = (slideIndex + 1) > slides.length ? 1 : slideIndex + 1;
    /*Показва текущият слайд */
    slides[slideIndex - 1].style.display = "block";
    /*Настройване на интервал за явтомтично превъртане на 3 секунди */
    setTimeout(showSlides, 3000);
}
/*За смяна на слайда*/
function changeSlide(n) {
    /*Скрива слайдовете */
    slides.forEach(slide => slide.style.display = "none");
    /*Изислява новият индекс, като взема края и началото на списъка */
    slideIndex = (slideIndex + n > slides.length) ? 1 : (slideIndex + n < 1 ? slides.length : slideIndex + n);
    /*Показва новият текущ слайд */
    slides[slideIndex - 1].style.display = "block";
}
