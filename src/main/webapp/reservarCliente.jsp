<%-- 
    Document   : reservarCliente
    Created on : 18 dic. 2022, 15:44:36
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Modelo.Alojamiento" %>
<%@page import="Modelo.Imagen" %>
<%@page import="Datos.AlojamientoDB" %>
<%@page import="Datos.ImagenDB" %>
<!DOCTYPE html>
<html lang="en-US" dir="ltr">

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

  </head>


  <body>
    <!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
    <main class="main" id="top">
      <nav class="navbar navbar-expand-lg navbar-light py-3 d-block" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container"><a class="navbar-brand" href="index.jsp"><img class="d-inline-block" src="assets/img/gallery/logo.png" width="50" alt="logo" /><span class="fw-bold text-primary ms-2">VacationAsHome</span></a>
          <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto pt-2 pt-lg-0 font-base">
              <li class="nav-item px-2"><a class="nav-link fw-medium active" aria-current="page"><span class="nav-link-icon text-800 me-1 fas fa-map-marker-alt"></span><span class="nav-link-text"></span></a></li>
              <li class="nav-item px-2"><a class="nav-link"> <span class="nav-link-icon text-800 me-1 fas fa-plane"></span><span class="nav-link-text"></span></a></li>
              <li class="nav-item px-2"><a class="nav-link"> <span class="nav-link-icon text-800 me-1 fas fa-hotel"></span><span class="nav-link-text"></span></a></li>
              <li class="nav-item px-2"><a class="nav-link"><span class="nav-link-icon text-800 me-1 fas fa-bolt"></span><span class="nav-link-text"></span></a></li>
            </ul>
            <form>
              <a class="nav-item px-2"></a>
              <a href="register.jsp" class="btn btn-voyage-outline order-0" type="submit"><span class="text-primary">Sign in</span></a>
            </form>
          </div>
        </div>
      </nav>
        
        <section class="mt-7 py-0">
        <div class="bg-holder w-50 bg-right d-none d-lg-block" style="background-image:url(assets/img/gallery/hero-section-1.png);">
        </div>
        <!--/.bg-holder-->

        <div class="container">
          <div class="row">
            <div class="col-lg-6 py-5 py-xl-5 py-xxl-7">
              <h1 class="display-3 text-1000 fw-normal">Let’s make a tour</h1>
              <h1 class="display-3 text-primary fw-bold">Discover the beauty</h1>
              <div class="pt-5">
                   <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <!-- MODIFICACION===============================================-->
                        <form class="row g-4 mt-5" method="post" action="ReservaServlet">
                        <!-- Para diferenciar entre diferentes formularios===============================================-->
                        <input type="hidden" id="method" name="method" value="1">  
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label class="form-label visually-hidden" for="inputAddress1">Provincia</label>
                            <input class="form-control input-box form-voyage-control" id="inputAddress1" type="text" placeholder="Provincia" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                          </div>
                        </div>
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label class="form-label visually-hidden" for="inputAddress2">Municipio</label>
                            <input class="form-control input-box form-voyage-control" id="inputAddress2" type="text" placeholder="Municipio" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"> </i></span>
                          </div>
                        </div>                 
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label class="form-label visually-hidden" for="inputPersonOne">Person</label>
                            <select class="form-select form-voyage-select input-box" id="inputPersonOne">
                              <option selected="selected">1</option>
                              <option>2</option>
                              <option>3</option>
                              <option>4</option>
                              <option>5</option>
                              
                            </select><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-user"> </i></span>
                          </div>
                        </div>
                        <div class="col-12 col-xl-10 col-lg-12 d-grid mt-6">
                            <button class="btn btn-secondary" type="submit">Reservar Alojamientos</button>
                        </div>
                      </form>
                    </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
        
        
  <form action="ReservaServlet" method="post" name="formulation">
            <% ArrayList<Alojamiento> dataList= (ArrayList<Alojamiento>)request.getAttribute("alojamientos");
                ArrayList<Imagen> imgList= (ArrayList<Imagen>)request.getAttribute("imagenes");
                        if(dataList!=null){
                            for(int i=0; i<dataList.size(); i++){
                                Alojamiento r = dataList.get(i);
                                Imagen img = imgList.get(i);
                        %>
      <!-- No se en que parte del codigo hay que introducir la imagen-->
             <article class="item item-multimedia-container" data-adid="92726554">
                <picture class="item-multimedia ">
                <div class="item-ribbon-container">
                </div>
                <div class="item-gallery gallery-height-core-vitals neutral-orientation">
                <div class="mask-wrapper is-clickable initialized">
                <div class="gallery-tap left"></div>
                <div class="gallery-arrow left icon-arrow-left" style="visibility: hidden;"></div>
                <div class="mask galleryBoost" style="touch-action: pan-y; user-select: none; transition-duration: 0s; transform: translateX(0px);">
                <div class="placeholder" style="transform: translateX(-300px);"></div>
                <div class="placeholder" style="transform: translateX(0px);">
                </div>
                <div class="placeholder" style="transform: translateX(300px);"><img src="https://img3.idealista.com/blur/WEB_LISTING-M/0/id.pro.es.image.master/6c/57/47/846614101.jpg" style="visibility: visible;" alt="" width="300" height="225"></div>
                </div>
                <div class="gallery-tap right"></div>
                <div class="gallery-arrow right icon-arrow-right" style="visibility: visible;"></div>
                </div>
                </div>
                </picture>
                <div class="item-info-container">
                <a href="/inmueble/92726554/" role="heading" aria-level="2" class="item-link" title="Habitación en calle Virgen del Val, 5, Val, Alcalá de Henares">
                <%= r.getNombre() %> <!-- Poner nombre en el titulo del alojamiento-->
                <%= r.getUbicacionDescrita() %>
                </a>
                <div class="price-row ">
                <span class="item-price h2-simulated">?<span class="txt-big">€/mes</span></span>
                </div>
                <div class="item-detail-char">
                <span class="item-detail"><%= r.getNumDormitorios() %><span>dormitorios</span></span>
                <span class="item-detail"><%= r.getMaxHuespedes() %><span>maximo numero de huespedes</span></span>
                <span class="item-detail"><span class="icon-sex-circle boy"></span> <%=r.getNumCamas()%> <span>camas</span></span>
                <span class="item-detail"><span class="icon-no-smoking"></span> <%=r.getNumBaños()%><span>baños</span><</span>
                </div>
                <div class="item-description description">
                <p class="ellipsis ">
                    <%= r.getCaracteristicas() %>
                    <%= r.getServicio() %>
                    <%= r.getValoracionGlobal() %>
                </p>
                </div>
                <div class="item-toolbar">
                <button class="icon-chat email-btn action-email fake-anchor"><span>Contactar</span></button>
                <button title="Guardar" class=" favorite-btn action-fav fake-anchor" data-role="add" data-text-add="Guardar" data-text-remove="Favorito">
                <i class="icon-heart" role="img"></i>
                <span>Guardar</span>
                </button>
                <button class="icon-delete trash-btn action-discard fake-anchor" data-role="add" title="Descartar" data-text-remove="Descartar" rel="nofollow">
                </button>
                </div>
                </div>
            </article>

         <%}
        }else{
%>
            <div class="col-lg-7 mx-auto text-center mb-6"></div>
            <div class="col-lg-7 mx-auto text-center mb-6">
                <h5 class="fw-bold fs-3 fs-lg-5 lh-sm mb-3" style="color: red" >No results found</h5>
            </div>
            <%
        }
         %>
    </form>
        
      <!-- <section> begin FOOTER =====================================================================================================================-->
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
    <script data-main="libs/main" src="libs/require.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600;700&amp;display=swap" rel="stylesheet">
  </body>

</html>
