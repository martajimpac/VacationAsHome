// mostrar las caracteriticas de los apartamentos
function mostrar() {
    var x = document.getElementById('caracteristicasAlojamiento');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}

$("#masInfo").click(function(){
    mostrar();
});