<%-- 
    Document   : index
    Created on : 18 dic. 2022, 15:44:36
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Alojamiento"%>
<%@page import="Modelo.Imagen"%>
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
              <a href="register.jsp" class="btn btn-voyage-outline order-0" type="submit"><span class="text-primary">Login</span></a>
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
                      <form class="row g-4 mt-5" method = "post" action="ReservaServlet">             
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label class="form-label visually-hidden" for="inputAddress1">Provincia</label>
                            <input class="form-control input-box form-voyage-control" id="inputAddress1" name="inputAddress1" type="text" placeholder="Provincia" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                          </div>
                        </div>
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label class="form-label visually-hidden" for="inputAddress2">Municipio</label>
                            <input class="form-control input-box form-voyage-control" id="inputAddress2" name="inputAddress2" type="text" placeholder="Municipio" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"> </i></span>
                          </div>
                        </div>
                       
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label class="form-label visually-hidden" for="inputPersonOne">Person</label>
                            <select class="form-select form-voyage-select input-box" id="inputPersonOne" name="inputPersonOne">
                               <option selected="selected" value="2">2 Adults</option>
                              <option value="3">2 Adults 1 children</option>
                              <option value="4">2 Adults 2 children</option>
                              
                            </select><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-user"> </i></span>
                          </div>           
                        </div>
                        <% String texto = (String)request.getAttribute("texto"); 
                             if(texto!=null){%>
                             <p class="text-800 fw-bold text-decoration-none" ><%= texto%></p>
                          <% } %>
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
                        
                        
                        
       <section id="testimonial">
        <div class="container">
          <div class="row h-100"> 
            <div class="col-lg-7 mx-auto text-center mb-6">
              <h5 class="fw-bold fs-3 fs-lg-5 lh-sm mb-3">Alojamientos disponibles</h5>
            </div>
            <div class="col-12">
                <div class="carousel slide" id="carouselTestimonials" data-bs-ride="carousel">
               
                
               
                <%  String direccion1 = (String)request.getAttribute("inputAddress1");
                    String direccion2 = (String)request.getAttribute("inputAddress2");
                    String huespedes = (String)request.getAttribute("inputPersonOne"); %>
                    
                 
                <!-- ESTE FORMULARIO DEBERIA SALIR DESPUES DE HABER ELEGIDO UN APARTAMENTO-->
                <!-- LE PASO LOS DATOS DE LOS ALOJAMIENTOS PARA PODER OBTENER EL MISMO ARRAY DE ALOJAMIENTOS QUE ANTES-->
                <!-- HAY QUE HACER DE ALGUNA FORMA QUE AL SELECCIONAR UNA FOTO TE SELECCIONE EL INDICE DEL ALOJAMIENTO-->
                <form class="row g-4 mt-5" action="RealizarReservaServlet" method="post" >
                <input id="inputAddress1" name="inputAddress1" type="hidden" value="<%= direccion1 %>">
                <input id="inputAddress2" name="inputAddress2" type="hidden" value= <%= direccion2 %>>
                <input id="inputPersonOne" name="inputPersonOne" type="hidden" value=<%= huespedes %>>   
                    
                    <div class="col-sm-6 col-md-6 col-xl-5">
                        <div class="input-group-icon">
                        <input class="form-control input-box form-voyage-control" id="inputDateOne" name="inputDateOne" type="date" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-calendar"></i></span>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-6 col-xl-5">
                        <div class="input-group-icon">
                            <input class="form-control input-box form-voyage-control" id="inputDateTwo" name="inputDateTwo" type="date" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-calendar"></i></span>
                         </div>
                    </div>
                    <div class="col-12 col-xl-10 col-lg-12 d-grid mt-6">
                            <button class="btn btn-secondary" type="submit">Realizar reserva</button>
                    </div> 
                
                <!-- VER ALOJAMIENTOS -->
                <% ArrayList<Alojamiento>  dataList= (ArrayList<Alojamiento>)request.getAttribute("alojamientos");
               ArrayList<Imagen>   im= (ArrayList<Imagen> )request.getAttribute("imagenes");
                        if(dataList!=null){
                            for(int i=0; i<dataList.size(); i++){
                                Alojamiento r = dataList.get(i);
                                Imagen ig=im.get(i);         
                        %>
                        <div class="col-md-4 mb-3 mb-md-0 h-100">
                        <div class="card card-span h-100 text-white"><img class="img-fluid h-100" src="data:<%= ig.getImagen() %>" alt="..." />
                            <div class="card-body ps-0">
                            <h5 ><%= r.getNombre() %></h5>
                            <span class="fw-bold text-1000 mb-4 text-truncate"><%=r.getLocalidad() %></span><span class="text-800 fs--1 me-2"><i class="fas fa-calendar"></i></span><span class="fw-bold text-1000 mb-4 text-truncate"><%=r.getValoracionGlobal() %></span>
                            <h6><%= r.getUbicacionDescrita() %></h6>
                            <h6 class="fw-bold text-1000 mb-4 text-truncate"><%= r.getCaracteristicas() %></h6>
                            <h6 class="fw-bold text-1000 mb-4 text-truncate"><%= r.getServicio() %></h6>
                            <h1 class="mb-3 text-primary fw-bolder fs-4"><span>$175</span>
                          </div>
                        </div>
                      </div>
                </form>
                
                <% String  texto2= (String)request.getAttribute("texto2");
                if("The hosting is avaliable".equals(texto2)){ %>
                    <form class="row g-4 mt-5" action="MensajeReservaServlet" method = "post">             
                        
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label for="inputFracciona">¿Desea fraccionar el pago?</label>
                            <select class="form-select form-voyage-select input-box" id="inputFracciona" name="inputFracciona">
                               <option selected="selected" value="true">Si</option>
                               <option value="false">No</option>
                            </select><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-user"> </i></span>
                          </div>           
                        </div>
                        
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label for="inputMensaje">Introduce un mensaje para el anfitrión</label>
                            <input class="form-control input-box form-voyage-control" id="inputMensaje" name="inputMensaje" type="text" placeholder="Mensaje" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                          </div>
                        </div>
                        
                        <div class="col-12 col-xl-10 col-lg-12 d-grid mt-6">
                            <button class="btn btn-secondary" type="submit">Confirmar reserva</button>
                        </div>     
                        </form>
                <% } %>
                        
                        
         <%}//del for
        }else{
%>
            <div class="col-lg-7 mx-auto text-center mb-6"></div>
            <div class="col-lg-7 mx-auto text-center mb-6">
                <h5 class="fw-bold fs-3 fs-lg-5 lh-sm mb-3" style="color: red" >No results found</h5>
            </div>
            <%
        }
         %>
         
                </div>
            </div>
          </div>
        </div>
      </section>                  
                        
                        
                        
                        
                        
       
      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="py-0 overflow-hidden">
        <div class="container-fluid">
          <div class="row">
            <div class="col-lg-6 px-0"><img class="img-fluid order-md-0 mb-4 h-100 fit-cover" src="assets/img/gallery/hero-section-2.png" alt="..." /></div>
            <div class="col-lg-6 px-0 bg-primary-gradient bg-offcanvas-right">
              <div class="mx-6 mx-xl-8 my-8">
                <div class="align-items-center d-block d-flex mb-5"><img class="img-fluid me-3 me-md-2 me-lg-4" src="assets/img/icons/locations.png" alt="..." />
                  <div class="flex-1 align-items-center pt-2">
                    <h5 class="fw-bold text-light">Visit the greatest places</h5>
                  </div>
                </div>
                <div class="align-items-center d-block d-flex mb-5"><img class="img-fluid me-3 me-md-2 me-lg-4" src="assets/img/icons/schedule.png" alt="..." />
                  <div class="flex-1 align-items-center pt-2">
                    <h5 class="fw-bold text-light">Make your own plans.</h5>
                  </div>
                </div>
                <div class="align-items-center d-block d-flex mb-5"><img class="img-fluid me-3 me-md-2 me-lg-4" src="assets/img/icons/save.png" alt="..." />
                  <div class="flex-1 align-items-center pt-2">
                    <h5 class="fw-bold text-light">Save 50% on your next trip</h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->
      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->
      
         
      <div class="col-lg-7 mx-auto text-center mb-6"></div>
      
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
    <script data-main="libs/main" src="libs/require.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600;700&amp;display=swap" rel="stylesheet">
  </body>

</html>
