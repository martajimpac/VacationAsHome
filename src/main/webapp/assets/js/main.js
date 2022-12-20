

function showText(text){
    if(text!==null){
        Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: text,
        showConfirmButton: false,
        timer: 1500
      })
    }
}