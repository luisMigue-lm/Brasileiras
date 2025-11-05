    document.addEventListener("DOMContentLoaded", function() {
        const viewRead = document.querySelector('.informacoes-read')
        const viewUpdate = document.querySelector('.informacoes-update')
        const viewDelete = document.querySelector('.informacoes-delete')

        const btnShowUpdate = document.querySelector('.informacoes-read .btn-alterar')
        const btnCancelUpdate = document.getElementById('cancelar-update')

        const btnShowDelete = document.querySelector('.informacoes-read .btn-deletar')
        const btnCancelDelete = document.querySelector('.cancelar-delete')


        btnShowUpdate.addEventListener('click', function(event) {
            event.preventDefault()

            viewRead.style.display = 'none'
            viewUpdate.style.display = 'block'
            viewDelete.style.display = 'none'
        })

        btnCancelUpdate.addEventListener('click', function(event) {
            event.preventDefault()

            viewRead.style.display = 'block' 
            viewUpdate.style.display = 'none'
            viewDelete.style.display = 'none'
        })

        btnShowDelete.addEventListener('click', function(event) {
            event.preventDefault()

            viewRead.style.display = 'none'
            viewDelete.style.display = 'block'
        })

        btnCancelDelete.addEventListener('click', function(event) {
            event.preventDefault()

            viewRead.style.display = 'block'
            viewDelete.style.display = 'none'
        })

    })