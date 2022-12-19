
// OBTENEMOS LOS DOCUMNETOS CON LOS DATOS DE LOCALIDAD
// JSON de los municipios
const jsonDataMunicipios = require('../json/municipios.json');
// JSON de las  Provincias
const jsonDataProvincias = require('../json/provincias.json');

municipios = [];
provincia = [] ;
for (let index = 0; index < jsonDataProvincias.length; index++) {
  municipios.push(jsonDataMunicipios[index].nm);
  provincia.push(jsonDataProvincias[index].nm);
}

console.log(municipios);
console.log(provincia);

/*
// Funcion autocompletar para introducir correctamente la Localidad
function autocompleteMatch(input) {
  if (input === '') {
    return [];
  }
  var reg = new RegExp(input);
  return search_terms.filter(function(term) {
	  if (term.match(reg)) {
  	  return term;
	  }
  });
}

function showResults(val) {
  res = $("#inputAddress1");
  res.innerHTML = '';
  let list = '';
  let terms = autocompleteMatch(val);
  for (i=0; i<terms.length; i++) {
    list += '<li>' + terms[i] + '</li>';
  }
  res.innerHTML = '<ul>' + list + '</ul>';
}

function cargar(val){
    if(val===1){
        showResults(provincia)
    }else{
        showResults(municipios)
    }
}*/

$(document).ready(function(){ 
            var availableTags  = [];

              $.ajax({ 
                    url: "../json/municipios.json", 
                    type: "GET",  
                    async: false, 
                    success: function(json){ 
                        //Proceso de los datos recibidos
                        availableTags = json['nm'];  
                        $( function() {

    $( "#inputAddress1" ).autocomplete({
      source: (request, response) => {
        // Filtramos el arreglo de tags
        let result = availableTags.filter(tag => {
          // Implementamos nuestro filtro personalizado
          return tag.toLowerCase().startsWith(request.term.toLowerCase());
        });
        // Llamamos a `response` con los datos filtrados
        response(result);
      },
      change: function(e, ui) {
        if (!ui.item) {
          $(this).val("");
        }
      },
        response: function(e, ui) {
            if (ui.content.length == 0) 
            {
                $(this).val("");
            }
        }
        })
          .on("keydown", function(e) 
          {
            if (e.keyCode == 27) 
            {
              $(this).val("");
            }
          })
  } );
                    }
              });

         }); // fin document.ready