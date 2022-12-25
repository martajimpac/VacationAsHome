<%-- 
    Document   : vistaCliente
    Created on : 18 dic. 2022, 18:21:47
    Author     : franc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelo.Reserva"%>
<%@page import="Modelo.Imagen"%>
<%@page language="java" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- ===============================================-->
    <!--    Document Title-->
    <!-- ===============================================-->
    <title>VacationAsHome</title>

    <!-- ===============================================-->
    <!--    Favicons-->
    <!-- ===============================================-->
    <link rel="apple-touch-icon" sizes="180x180" href="assets/img/favicons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/img/favicons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/img/favicons/favicon-16x16.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicons/favicon.ico">
    <link rel="manifest" href="assets/img/favicons/manifest.json">
    <meta name="msapplication-TileImage" content="assets/img/favicons/mstile-150x150.png">
    <meta name="theme-color" content="#ffffff">

    <!-- ===============================================-->
    <!--    Stylesheets-->
    <!-- ===============================================-->
    <link href="assets/css/theme.css" rel="stylesheet" />
    <link href="assets/css/main.css" rel="stylesheet" />
  </head>


  <body>
    <!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
    <main class="main" id="top">
      <nav class="navbar navbar-expand-lg navbar-light py-3 d-block" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container"><a class="navbar-brand" href="index.jsp"><img class="d-inline-block" src="assets/img/gallery/logo.png" width="50" alt="logo" /><span class="fw-bold text-primary ms-2">VacationAsHome Host</span></a>
          <button class="navbar-toggler cobuttollapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto pt-2 pt-lg-0 font-base">
              <li class="nav-item px-2"><a class="nav-link fw-medium active" aria-current="page"><span class="nav-link-icon text-800 me-1 fas fa-map-marker-alt"></span><span class="nav-link-text"></span></a></li>
              <li class="nav-item px-2"><a class="nav-link"> <span class="nav-link-icon text-800 me-1 fas fa-plane"></span><span class="nav-link-text"></span></a></li>
              <li class="nav-item px-2"><a class="nav-link"> <span class="nav-link-icon text-800 me-1 fas fa-hotel"></span><span class="nav-link-text"></span></a></li>
              <li class="nav-item px-2"><a class="nav-link"><span class="nav-link-icon text-800 me-1 fas fa-bolt"></span><span class="nav-link-text"></span></a></li>
            </ul>
            <form>
              <a class="nav-item px-2"></a>
              <a href="register.jsp" class="btn btn-voyage-outline order-0" type="submit"><img id="iconoRegister" src="./assets/img/icons/register.png" /><span class="text-primary"></span></a>
            </form>
          </div>
        </div>
      </nav>
      <!-- <section> close ============================-->
      <!-- ============================================-->
            <form class="row g-4 mt-5" action="ReservarServlet" metod="post">
              <% Reserva dataList= (Reserva)request.getAttribute("res");
                            Imagen im= (Imagen)request.getAttribute("imgen");
                        if(dataList!=null){
                            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
                            // Crea un objeto Date con la fecha actual
                            // Convierte la fecha a una cadena de texto con el formato especificado
                            String fecha1String = formateador.format(dataList.getFechaEntrada());
                            String fecha2String = formateador.format(dataList.getFechaSalida());

                        %>
                              <div class="col-md-6 card card-span h-100 text-white"><img class="img-fluid h-100" src="assets/img/gallery/maldives.png" alt="..." />
                              </div>
                              <div class="col-md-6 text-white">
                                  <div class="card-body ps-2">
                                      <div class="card-body ps-0">
                                          <h5 class="fw-bold text-1000 mb-4 text-truncate"><%=request.getAttribute("nom")%></h5>
                                          <div class="d-flex align-items-center justify-content-start"><span class="text-800 fs--1 me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-900 me-3">Fecha de entrada: <%=fecha1String %></span><span class="text-800 fs--1 me-2"><i class="fas fa-calendar"></i></span><span class="text-900">Fecha de salida: <%=fecha2String %></span></div>
                                          <div class="d-flex align-items-center justify-content-start"><span class="text-800 fs--1 me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-900 me-3">Numero de huespedes: <%=dataList.getNumHuespedes() %></span></div>
                                          <h1 class="mb-3 text-primary fw-bolder fs-4"><span>$175</span></h1>
                                          <span class="text-800 fs--1 me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-900 me-3">Dividir pago</span><input name="check" type="checkbox" value=true>
                                      </div>
                                      <div><textarea name="comentarios" style="width: 600px; height: 100px;">Comentarios</textarea></div>
                                    <input class="form-control input-box form-voyage-control" id="ocultar" name="fechaEntrada" style="display: none;" type="text" placeholder=<%=dataList.getFechaEntrada()%> />
                                    <input class="form-control input-box form-voyage-control" id="ocultar" name="fechaSalida" style="display: none;" type="text" placeholder=<%=dataList.getFechaSalida() %> />
                                    <input class="form-control input-box form-voyage-control" id="ocultar" name="numHuespe" style="display: none;" type="text" placeholder=<%=dataList.getNumHuespedes() %> />
                                    <input class="form-control input-box form-voyage-control" id="ocultar" name="estado" style="display: none;" type="text" placeholder="realizada" />
                                    <input class="form-control input-box form-voyage-control" id="ocultar" name="Alojamiento_ubicacionPrecisa" style="display: none;" type="text" placeholder=<%=dataList.getAlojamiento_ubicacion_precisa() %> />
                                    <input class="form-control input-box form-voyage-control" id="ocultar" name="Alojamiento_Anfitrion_email" style="display: none;" type="text" placeholder=<%=dataList.getAlojamiento_anfitrion_email() %> />
                                    <!--<input class="form-control input-box form-voyage-control" id="ocultar" name="precio" style="display: none;" type="text" placeholder=/> -->
                                      <div class="mt-4 col-12 col-xl-12 col-lg-12 d-grid">
                                          <button class="btn btn-secondary" type="submit">Reservar</button>
                                      </div>
                                  </div>
                              </div>
                <%}else{}%>
          </form>
      
      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="py-0 overflow-hidden">
        <div class="container">
          <div class="row">
            <div class="col-6 col-sm-4 col-lg-6">
              <div class="py-7"><img class="d-inline-block" src="assets/img/gallery/logo.png" width="50" alt="logo" /><span class="fw-bold fs-4 text-primary ms-2">VacationAsHome</span>
                <ul class="list-unstyled mt-4">
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">News</a></li>
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">Terms &amp; Conditions</a></li>
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">Privacy</a></li>
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">About Us</a></li>
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">FAQs</a></li>
                </ul>
              </div>
            </div>
            <div class="col-6 col-8 col-lg-6 bg-primary-gradient bg-offcanvas-right">
              <div class="p-3 py-7 p-md-7">
                <p class="text-light"><i class="fas fa-phone-alt me-3"></i><span class="text-light">+34 1234567890</span></p>
                <p class="text-light"><i class="fas fa-envelope me-3"></i><span class="text-light">pdsc2223@gmail.com</span></p>
                <p class="text-light"><i class="fas fa-map-marker-alt me-3"></i><span class="text-light lh-lg">333, UVA, Valladolid, Spain<br/>Europe</span></p>
                <div class="mt-6"><a href="#!"> <img class="me-3" src="assets/img/icons/facebook.svg" alt="..." /></a><a href="#!"> <img class="me-3" src="assets/img/icons/twitter.svg" alt="..." /></a><a href="#!"> <img class="me-3" src="assets/img/icons/instagram.svg" alt="..." /></a></div>
                <p class="mt-3 text-light text-center text-md-start"> Made with&nbsp;
                  <svg class="bi bi-suit-heart-fill" xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="#EB6453" viewBox="0 0 16 16">
                    <path d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z"></path>
                  </svg>&nbsp;by&nbsp;<a class="text-light" href="https://themewagon.com/" target="_blank">ThemeWagon </a>
                </p>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->
      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->

    </main>
    <!-- ===============================================-->
    <!--    End of Main Content-->
    <!-- ===============================================-->

    <!-- ===============================================-->
    <!--    JavaScripts-->
    <!-- ===============================================-->
    <script src="vendors/@popperjs/popper.min.js"></script>
    <script src="vendors/bootstrap/bootstrap.min.js"></script>
    <script src="vendors/is/is.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
    <script src="vendors/fontawesome/all.min.js"></script>
    <script src="assets/js/theme.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600;700&amp;display=swap" rel="stylesheet">
  </body>

</html>

