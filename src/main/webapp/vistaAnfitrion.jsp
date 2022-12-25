<%-- 
    Document   : vistaCliente
    Created on : 18 dic. 2022, 18:21:47
    Author     : franc
--%>

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
                      <form class="row g-4 mt-5" method="post" action="ConsultarAlojamientosServlet">
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label class="form-label visually-hidden" for="inputAddress1" name="provincia">Provincia</label>
                            <input class="form-control input-box form-voyage-control" id="inputAddress1" type="text" placeholder="Provincia" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                          </div>
                        </div>
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label class="form-label visually-hidden" for="inputAddress2" name="municipio">Municipio</label>
                            <input class="form-control input-box form-voyage-control" id="inputAddress2" type="text" placeholder="Municipio" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"> </i></span>
                          </div>
                        </div>
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <input class="form-control input-box form-voyage-control" id="inputdateOne" type="date" name="date1"/><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-calendar"></i></span>
                          </div>
                        </div>
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <input class="form-control input-box form-voyage-control" id="inputDateTwo" type="date" name="date2"/><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-calendar"></i></span>
                          </div>
                        </div>
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group-icon">
                            <label class="form-label visually-hidden" for="inputPersonOne" name="numPersonas">Person</label>
                            <select class="form-select form-voyage-select input-box" id="inputPersonOne">
                              <option selected="selected">2 Adults</option>
                              <option>2 Adults 1 children</option>
                              <option>2 Adults 2 children</option>
                              
                            </select><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-user"> </i></span>
                          </div>
                        </div>
                        <div class="col-12 col-xl-10 col-lg-12 d-grid mt-6">
                            <button class="btn btn-secondary" type="submit" name="botonReserva" id="botonReserva" name="botonEmpezarConsulta">Consultar Alojamientos</button>
                        </div>
                      </form>
                    </div>
                </div>
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

      <section id="testimonial" name="reservas">
        <div class="container">
          <div class="row h-100">
          <% String pulsado = "a"; 
            System.out.println("PULSADOR: " + pulsado);
             if(pulsado != null){
          %>
            <div class="col-lg-10 mx-auto text-center mb-6">
              <h5 class="fw-bold fs-3 fs-lg-5 lh-sm mb-3" id="tituloAlojamiento" name="tituloAlojamiento">Tus Alojamientos</h5>
              <!-- <div id="order"> 
                  <form>
                    <span class="badge bg-secondary p-2"><a href="#!"><i class="fas fa-bolt me-1">Ordenar Por Precio</i></a></span>
                    <span class="badge bg-secondary p-2"><a href="#!"><i class="fas fa-bolt me-1">Ordenar Por Lo Que Sea</i></a></span>
                  </form>
              </div> -->
            </div>
            <div class="col-12">
              <div class="carousel slide" id="carouselTestimonials" data-bs-ride="carousel">
                <div class="carousel-inner">
                  <div class="carousel-item active" data-bs-interval="10000">
                    <div class="row h-100 align-items-center g-2">
                       
                      <!-- Duplicar este div para cada uno de los alojaminetos dipsonibles -->
                      <div class="row col-md-12 mb-3 mb-md-0 h-100 mt-5">
                        <div class="col-md-6 card card-span h-100 text-white"><img class="img-fluid h-100" src="assets/img/gallery/maldives.png" alt="..." />
                            <!--<div class="card-img-overlay ps-0">
                                <span class="badge bg-secondary ms-3 me-1 p-2"><a href="reservarCliente.jsp">Reservar</a></span>
                                <span class="badge bg-secondary p-2"><a href="#!">Mas Info</a></span>
                            </div>

                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 mb-4 text-truncate">Mermaid Beach Resort: The most joyful way to spend your holiday</h5>
                            <div class="d-flex align-items-center justify-content-start"><span class="text-800 fs--1 me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-900 me-3">Maldives</span><span class="text-800 fs--1 me-2"><i class="fas fa-calendar"></i></span><span class="text-900">4 days</span></div>
                            <p class="text-decoration-line-through text-900 mt-3 mb-0">$200</p>
                            <h1 class="mb-3 text-primary fw-bolder fs-4"><span>$175</span><span class="text-900 fs--1 fw-normal">/Per person</span></h1><span class="badge bg-soft-secondary p-2"><i class="fas fa-tag text-secondary fs--1 me-1"></i><span class="text-secondary fw-normal fs-1">-15%</span></span>
                          </div>-->
                        </div>
                        <div class="col-md-6 text-white">
                            <div class="card-body ps-2">
                                <h5 class="fw-bold text-1000 mb-4 text-truncate">Mermaid Beach Resort: The most joyful way to spend your holiday</h5>
                                <div class="input-group-icon">
                                    <label class="form-label visually-hidden" for="precioNoche" name="precioNoche" type="number">precioNoche</label>
                                    <input class="form-control input-box form-voyage-control" id="precioNoche" type="text" placeholder="precioNoche" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                                </div> <div class="input-group-icon mt-2">
                                    <label class="form-label visually-hidden" for="precioNoche" name="precioFinSemana" type="number">precioFinSemana</label>
                                    <input class="form-control input-box form-voyage-control" id="precioNoche" type="text" placeholder="precioFinSemana" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                                </div> <div class="input-group-icon mt-2">
                                    <label class="form-label visually-hidden" for="precioNoche" name="precioSemana" type="number">precioSemana</label>
                                    <input class="form-control input-box form-voyage-control" id="precioNoche" type="text" placeholder="precioSemana" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                                </div> <div class="input-group-icon mt-2">
                                    <label class="form-label visually-hidden" for="precioNoche" name="precioMes" type="number">precioMes</label>
                                    <input class="form-control input-box form-voyage-control" id="precioNoche" type="text" placeholder="precioMes" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                                </div>
                                <div class="mt-4 col-12 col-xl-12 col-lg-12 d-grid">
                                    <button class="btn btn-secondary" type="submit">Guardar</button>
                                </div>
                            </div>
                        </div>
                      </div>
     
                      <div class="row col-md-12 mb-3 mb-md-0 h-100 mt-5">
                        <div class="col-md-6 card card-span h-100 text-white"><img class="img-fluid h-100" src="assets/img/gallery/maldives.png" alt="..." />
                            <!--<div class="card-img-overlay ps-0">
                                <span class="badge bg-secondary ms-3 me-1 p-2"><a href="reservarCliente.jsp">Reservar</a></span>
                                <span class="badge bg-secondary p-2"><a href="#!">Mas Info</a></span>
                            </div>

                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 mb-4 text-truncate">Mermaid Beach Resort: The most joyful way to spend your holiday</h5>
                            <div class="d-flex align-items-center justify-content-start"><span class="text-800 fs--1 me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-900 me-3">Maldives</span><span class="text-800 fs--1 me-2"><i class="fas fa-calendar"></i></span><span class="text-900">4 days</span></div>
                            <p class="text-decoration-line-through text-900 mt-3 mb-0">$200</p>
                            <h1 class="mb-3 text-primary fw-bolder fs-4"><span>$175</span><span class="text-900 fs--1 fw-normal">/Per person</span></h1><span class="badge bg-soft-secondary p-2"><i class="fas fa-tag text-secondary fs--1 me-1"></i><span class="text-secondary fw-normal fs-1">-15%</span></span>
                          </div>-->
                        </div>
                        <div class="col-md-6 text-white">
                            <div class="card-body ps-2">
                                <h5 class="fw-bold text-1000 mb-4 text-truncate">Mermaid Beach Resort: The most joyful way to spend your holiday</h5>
                                <div class="input-group-icon">
                                    <label class="form-label visually-hidden" for="precioNoche" name="precioNoche" type="number">precioNoche</label>
                                    <input class="form-control input-box form-voyage-control" id="precioNoche" type="text" placeholder="precioNoche" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                                </div> <div class="input-group-icon mt-2">
                                    <label class="form-label visually-hidden" for="precioNoche" name="precioFinSemana" type="number">precioFinSemana</label>
                                    <input class="form-control input-box form-voyage-control" id="precioNoche" type="text" placeholder="precioFinSemana" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                                </div> <div class="input-group-icon mt-2">
                                    <label class="form-label visually-hidden" for="precioNoche" name="precioSemana" type="number">precioSemana</label>
                                    <input class="form-control input-box form-voyage-control" id="precioNoche" type="text" placeholder="precioSemana" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                                </div> <div class="input-group-icon mt-2">
                                    <label class="form-label visually-hidden" for="precioNoche" name="precioMes" type="number">precioMes</label>
                                    <input class="form-control input-box form-voyage-control" id="precioNoche" type="text" placeholder="precioMes" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>
                                </div>
                                <div class="mt-4 col-12 col-xl-12 col-lg-12 d-grid">
                                    <button class="btn btn-secondary" type="submit">Guardar</button>
                                </div>
                            </div>
                        </div>
                      </div>
                    </div>
                      
                  </div>
                  
                  <!-- <div class="row">
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselTestimonials" data-bs-slide="prev"><span class="carousel-control-prev-icon" aria-hidden="true"></span><span class="visually-hidden">Previous</span></button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselTestimonials" data-bs-slide="next"><span class="carousel-control-next-icon" aria-hidden="true"></span><span class="visually-hidden">Next </span></button>
                  </div> -->
                </div> 
                  
                <!-- <div class="row flex-center">
                  <div class="col-auto position-relative z-index-2">
                    <ol class="carousel-indicators me-xxl-7 me-xl-4 me-lg-7">
                      <li class="active" data-bs-target="#carouselTestimonials" data-bs-slide-to="0"></li>
                      <li data-bs-target="#carouselTestimonials" data-bs-slide-to="1"></li>
                      <li data-bs-target="#carouselTestimonials" data-bs-slide-to="2"></li>
                      <li data-bs-target="#carouselTestimonials" data-bs-slide-to="3"></li>
                    </ol>
                  </div>
                </div> -->
              
              </div>
            </div>
            <%}%>
          </div>
        </div>
      </section>
      
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

