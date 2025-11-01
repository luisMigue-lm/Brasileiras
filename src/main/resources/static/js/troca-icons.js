function trocarImagem(id, padrao, colorida) {
    const elemento = document.getElementById(id);
    if (!elemento) return;

    elemento.addEventListener("mouseover", () => {
        elemento.src = colorida;
    });

    elemento.addEventListener("mouseout", () => {
        elemento.src = padrao;
    })
}

trocarImagem("lupa", "/img/icons/lupa.svg", "/img/icons/lupa-verde.svg");
trocarImagem("user-image", "/img/icons/user.svg", "/img/icons/user-verde.svg");
trocarImagem("carrinho", "/img/icons/carrinho.svg", "/img/icons/carrinho-verde.svg");
trocarImagem("icon-loclz", "/img/icons/local.svg", "/img/icons/local-amarelo.svg");