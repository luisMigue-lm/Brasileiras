const toggleSenha = document.getElementById("toggle-senha");
  const campoSenha = document.getElementById("senha");

  toggleSenha.addEventListener("click", () => {
    const tipo = campoSenha.getAttribute("type") === "password" ? "text" : "password";
    campoSenha.setAttribute("type", tipo);

    toggleSenha.src = tipo === "password" 
      ? "/img/icons/olho-fechado.svg" 
      : "/img/icons/olho-aberto.svg";
  });