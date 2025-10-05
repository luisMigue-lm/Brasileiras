const inputFoto = document.getElementById("foto")
const preview = document.getElementById("preview-foto")

inputFoto.addEventListener("change", () =>  {
    const file = inputFoto.files[0]
    if (file) {
        const reader = new FileReader()
        reader.onload = (e) => {
            preview.src = e.target.result
        }
        reader.readAsDataURL(file)
    }
})