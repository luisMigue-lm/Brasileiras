document.addEventListener("DOMContentLoaded", function () {
    const btnDiminuir = document.getElementById("btn-diminuir");
    const btnAumentar = document.getElementById("btn-aumentar");
    const spanValor = document.getElementById("quantity-value");

    const inputQuantidade = document.getElementById("input-quantidade");

    if (!btnDiminuir || !btnAumentar || !spanValor || !inputQuantidade) return;

    let contagem = 0;

    function atualizarValores() {
        spanValor.textContent = contagem + (contagem === 1 ? ' unidade' : ' unidades');
        
        inputQuantidade.value = contagem;
    }

    btnAumentar.addEventListener('click', function () {
        contagem++;
        atualizarValores();
    });

    btnDiminuir.addEventListener('click', function () {
        if (contagem > 0) {
            contagem--;
            atualizarValores();
        }
    });

    atualizarValores();
});