document.addEventListener("DOMContentLoaded", function () {
    const btnDiminuir = document.getElementById("btn-diminuir");
    const btnAumentar = document.getElementById("btn-aumentar");
    const spanValor = document.getElementById("quantity-value");
    const inputQuantidade = document.getElementById("input-quantidade");

    if (!btnDiminuir || !btnAumentar || !spanValor || !inputQuantidade) return;

    let contagem = parseInt(inputQuantidade.value) || 1;
    const max = parseInt(inputQuantidade.dataset.max) || Infinity;

    function atualizarValores() {
        spanValor.textContent = contagem + (contagem === 1 ? " unidade" : " unidades");
        inputQuantidade.value = contagem;

        btnDiminuir.disabled = contagem <= 1;
        btnAumentar.disabled = contagem >= max;
    }

    btnAumentar.addEventListener("click", function () {
        if (contagem < max) {
            contagem++;
            atualizarValores();
        }
    });

    btnDiminuir.addEventListener("click", function () {
        if (contagem > 1) {
            contagem--;
            atualizarValores();
        }
    });

    atualizarValores();
});
