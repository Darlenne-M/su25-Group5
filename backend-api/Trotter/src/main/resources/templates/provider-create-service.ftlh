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
                        <a class="nav-link" href="/provider-homepage/${providerId}/services/createForm">Create Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="provider-cust-stats.html">Statistics</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/provider-homepage/${providerId}#contact-us">Contact Us</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Account
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end"> <!-- Aligns dropdown to the right -->
                            <li><a class="dropdown-item" href="/provider-homepage/${providerId}/updateForm">My Profile</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="../homepage.html">Log Out</a></li>

                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav><br>
    <div class="d-flex justify-content-center">
        <div class="card w-75 mb-3">
            <div class="card-header">
                <div class="Home text-center">
                    <h4>Create Your Service Below</h4>
                </div>
            </div>
            <form class="card-body" id="new-service" action="/provider-homepage/${providerId}/services" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label class="form-label">Service Name</label>
                    <input type="text" class="form-control" name="serviceName"
                        placeholder="e.g. Dog Walking in Greensboro">
                </div>
                <div class="mb-3">
                    <label class="form-label">Description</label>
                    <textarea class="form-control" name="description" rows="3"></textarea>
                </div>
                <div class="mb-3">
                    <label class="form-label">Experience</label>
                    <input type="text" class="form-control" name="experience">
                </div>
                <div class="mb-3">
                    <label class="form-label">Pricing</label>
                    <input type="number" class="form-control" name="pricing">
                </div>
                <div class="mb-3">
                    <label class="form-label">Preferred Contact Method</label>
                    <input type="text" class="form-control" name="preferredContactMethod">
                </div>
                <div class="mb-3">
                    <label class="form-label">Service Location(s)</label>
                    <input type="text" class="form-control" name="serviceLocations">
                </div>
                <div class="mb-3">
                    <label class="form-label">Travel Radius</label>
                    <input type="text" class="form-control" name="travelRadius">
                </div>
                <div class="mb-3">
                    <label for="formFileMultiple" class="form-label">Upload Image (Optional)</label>
                    <input class="form-control" type="file" name="picture">

                </div>
                <div class="Home text-center">

                    <button type="submit" class="btn btn-primary"
                        style="background-color: rgb(255, 123, 0); border-color: orange;">
                        Create Service
                    </button>

                    <a href="/provider-homepage/${providerId}" class="btn btn-primary"
                        style="background-color: rgb(255, 123, 0); border-color: orange;">
                        Cancel
                    </a>

                </div>
            </form>
        </div>
    </div>

    </div>

</body>

</html>