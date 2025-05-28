document.addEventListener('DOMContentLoaded', function() {
    const slides = document.querySelectorAll('.carousel-fade-slide');
    const prevButton = document.querySelector('.carousel-fade-button.prev');
    const nextButton = document.querySelector('.carousel-fade-button.next');
    const dotsContainer = document.querySelector('.carousel-fade-dots');

    if (!slides.length || !prevButton || !nextButton || !dotsContainer) {
        console.warn("No se encontraron todos los elementos necesarios para el carrusel de desvanecimiento.");
        return;
    }

    let currentSlide = 0; // Índice del slide actual

    // Función para mostrar un slide específico
    function showSlide(index) {
        // Oculta todos los slides y desactiva los puntos
        slides.forEach((slide, i) => {
            slide.classList.remove('active');
            if (dotsContainer.children[i]) {
                dotsContainer.children[i].classList.remove('active');
            }
        });

        // Muestra el slide deseado y activa su punto
        slides[index].classList.add('active');
        if (dotsContainer.children[index]) {
            dotsContainer.children[index].classList.add('active');
        }
    }

    // Función para el slide siguiente
    function nextSlide() {
        currentSlide = (currentSlide + 1) % slides.length;
        showSlide(currentSlide);
    }

    // Función para el slide anterior
    function prevSlide() {
        currentSlide = (currentSlide - 1 + slides.length) % slides.length;
        showSlide(currentSlide);
    }

    // Generar los puntos de navegación
    slides.forEach((_, index) => {
        const dot = document.createElement('span');
        dot.classList.add('dot');
        if (index === 0) {
            dot.classList.add('active'); // El primer punto activo por defecto
        }
        dot.addEventListener('click', () => {
            currentSlide = index;
            showSlide(currentSlide);
        });
        dotsContainer.appendChild(dot);
    });

    // Eventos de los botones
    prevButton.addEventListener('click', prevSlide);
    nextButton.addEventListener('click', nextSlide);

    // Mostrar el primer slide al cargar
    showSlide(currentSlide);

    // Opcional: Auto-play del carrusel
    const autoPlayInterval = 5000; // 5 segundos
    let slideInterval = setInterval(nextSlide, autoPlayInterval);

    // Pausar el auto-play al pasar el ratón por encima del carrusel
    const carouselContainer = document.querySelector('.carousel-fade-container');
    carouselContainer.addEventListener('mouseenter', () => {
        clearInterval(slideInterval);
    });
    carouselContainer.addEventListener('mouseleave', () => {
        slideInterval = setInterval(nextSlide, autoPlayInterval);
    });
});
