<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        html {
            scroll-behavior: smooth;
        }
    </style>

</head>

<body>


    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(255, 123, 0);">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Trotter</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/provider-homepage/${providerId}">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/provider-homepage/${providerId}/services/createForm">Create
                            Service</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="#contact-us">Contact Us</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Account
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end"> <!-- Aligns dropdown to the right -->
                            <li><a class="dropdown-item" href="/provider-homepage/${provider.providerId}/updateForm">My
                                    Profile</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/logout">Log Out</a></li>

                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>


    <div id="Trotter" class="Home text-center" style="background-color: rgb(255, 123, 0);">
        <br><br><br>
        <h1 style="font-size: 3rem; font-weight: bold; color: white;">
            Welcome To Trotter ${provider.firstName}!
        </h1>
        <h6 style="color: white;">Your journey as a provider starts here!</h6>

        <div class="text-center mt-4">
            <img src="/profile-pictures/${(provider.profilePicturePath)!'homepage.jpg'}" class="card-img-top"
                style="height: 100px; width: 100px; border-radius: 50%; object-fit: cover;" alt="profile picture">
        </div>

        <br><br><br><br>
    </div><br><br>

    <div class="container py-5">
        <h2 class="mb-4 text-center">Customer Statistics</h2>

        <!-- Top Two Centered Cards -->
        <div class="row justify-content-center text-center mb-4">
            <div class="col-md-4 mb-3">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Total Services</h5>
                        <h2>${serviceCount}</h2>
                    </div>
                </div>
            </div>

            <div class="col-md-4 mb-3">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Total Bookings</h5>
                        <h2>${totalBookings}</h2>
                    </div>
                </div>
            </div>
        </div>

        <!-- Full-width Centered Bottom Card -->
        <div class="row text-center">
            <div class="col-md-8 mx-auto">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Repeating Services</h5>
                        <h2>${repeatingServices}</h2>
                        <#if repeatingServiceBookings?has_content && repeatingServiceBookings?size> 0>
                            <ul class="list-group list-group-flush mt-3">
                                <#list repeatingServiceBookings?keys as serviceId>
                                    <li class="list-group-item">
                                        ${serviceNames[serviceId]! "Unknown Service"} - Booked:
                                        ${repeatingServiceBookings[serviceId]}
                                    </li>
                                </#list>
                            </ul>
                            <#else>
                                <p class="text-muted mt-2">No repeating services.</p>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <br>
    <br>
    <div class="d-flex justify-content-center">
        <div class="card w-75 mb-3">
            <div class="card-header">
                Incoming Appointments
            </div>
            <div class="card-body">
                <h5 class="card-title">Special title treatment</h5>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <a href="#" class="btn btn-primary"
                    style="background-color: rgb(255, 123, 0); border-color: orange;">Accept</a>
                <a href="#" class="btn btn-primary"
                    style="background-color: rgb(255, 123, 0); border-color: orange;">Deny</a>
            </div>
        </div>
    </div>
    <br><br>

    <div id="services" class="d-flex justify-content-center">
        <div class="card w-75 mb-3">
            <div class="card-header">
                Your Services
            </div><br>

            <div class="container">
                <div class="row">
                    <#list servicesList as service>
                        <div class="col-md-4 mb-4"> <!-- 4 columns per card means 3 cards per row -->
                            <div class="card h-100">
                                <div class="card-body">
                                    <h5 class="card-title">${service.serviceName}</h5>
                                    <p class="card-text">${service.description}</p>
                                    <a href="/provider-homepage/${provider.providerId}/services/${service.serviceId}"
                                        class="btn btn-primary"
                                        style="background-color: rgb(255, 123, 0); border-color: orange;">
                                        View
                                    </a>

                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>

        </div>
    </div>
    </div><br>
    </div>
    <br><br>

    <div id="contact-us" class="container bg-light">
        <br><br><br><br>
        <h1 class="text-center mb-4">CONTACT</h1><br>
        <div class="row">

            <div class="col-md-6 text-start">
                <p>
                    Contact us and we'll get back to you within 24 hours.<br>
                    <i class="bi bi-geo-alt"></i> North Carolina, US<br>
                    <i class="bi bi-telephone"></i> +00 1515151515<br>
                    <i class="bi bi-envelope-at"></i> TrotterCo@gmail.com<br>
                </p>
            </div>
            <div class="col-md-6">
                <form>
                    <div class="mb-3">
                        <label for="nameInput" class="form-label">Name</label>
                        <input type="text" class="form-control" id="nameInput" placeholder="Your name">
                    </div>
                    <div class="mb-3">
                        <label for="emailInput" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="emailInput" placeholder="name@example.com">
                    </div>
                    <div class="mb-3">
                        <label for="commentTextarea" class="form-label">Comment</label>
                        <textarea class="form-control" id="commentTextarea" rows="3"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary"
                        style="background-color: rgb(255, 123, 0); border-color: orange;">
                        Send
                    </button>
                </form>
                <br><br><br><br>
            </div>
        </div>


</body>

</html>