<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <title>Customer Statistics</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
                        <a class="nav-link active" aria-current="page" href="provider-homepage.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="provider-create-service.html">Create Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="provider-cust-stats.html">Statistics</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="provider-homepage.html#contact-us">Contact Us</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Account
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end"> <!-- Aligns dropdown to the right -->
                            <li><a class="dropdown-item" href="provider-profile.html">My Profile</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="../homepage.html">Log Out</a></li>

                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>

    <div class="container py-5">
        <h2 class="mb-4 text-center">Customer Statistics</h2>

        <!-- Stats Cards -->
        <div class="row text-center mb-5">
            <div class="col-md-3">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Total Services</h5>
                        <h2>${serviceCount}</h2>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Total Bookings</h5>
                        <h2>${totalBookings}</h2>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
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


            <div class="d-flex justify-content-center">
                <div class="card w-75 mb-3">
                    <div class="card-header">
                        Dog Grooming Service

                    </div>
                    <div class="card-body">
                        <div class="mx-auto" style="max-width: 900px;">
                            <div class="row g-3 align-items-center">
                                <div class="col-md-2">
                                    <img src="../images/customer1.jpg" class="img-fluid rounded-start"
                                        alt="Customer photo">
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">

                                        <br><b>"Outstanding!"
                                            <i class="bi bi-star-fill" style="color: gold;"></i>
                                            <i class="bi bi-star-fill" style="color: gold;"></i>
                                            <i class="bi bi-star-fill" style="color: gold;"></i>
                                            <i class="bi bi-star-fill" style="color: gold;"></i>
                                            <i class="bi bi-star-fill" style="color: gold;"></i>
                                        </b>
                                        <p class="card-text">
                                            I couldn't be happier with the service! My golden retriever, Max, came out
                                            looking and
                                            smelling amazing.
                                            The groomers were so gentle and clearly love what they do. They even trimmed
                                            his nails and
                                            added a cute little bandana!
                                            The appointment was easy to book, and they were right on time.
                                            Highly recommend to any pet parent looking for a caring and professional
                                            grooming
                                            experience!
                                        </p>
                                    </div><br>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#replyModal"
                                        style="background-color: rgb(255, 123, 0); border-color: orange;">
                                        Reply
                                    </button>
                                    <!-- Reply Modal -->
                                    <div class="modal fade" id="replyModal" tabindex="-1"
                                        aria-labelledby="replyModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <form>
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="replyModalLabel">Reply to Review
                                                        </h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="mb-3">
                                                            <label for="replyText" class="form-label">Your Reply</label>
                                                            <textarea class="form-control" id="replyText" rows="4"
                                                                placeholder="Write your reply here..."></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                            data-bs-dismiss="modal">Cancel</button>
                                                        <button type="submit" class="btn btn-primary"
                                                            style="background-color: rgb(255, 123, 0); border-color: orange;">Send
                                                            Reply</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

</body>

</html>