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
    <div class="position-relative bg-light"> <br></div>

    <div class="position-relative bg-light">
        <!-- Remove Account button aligned to top-right -->
        <div class="position-absolute top-0 end-0">
            <button class="btn btn-primary" style="background-color: rgb(255, 123, 0); border-color: orange;"
                onclick="confirmRemoval()">
                Remove Account <i class="bi bi-trash3"></i>
            </button>
        </div>


        <div class="d-flex justify-content-center">
            <div class="card w-50 mb-3">
                <div class="card-header">
                    <h5 class="text-center mb-4">Account Settings</h5>
                    <h6 class="text-center mb-4">Account Information</h5>
                </div>

                <form action="/provider-homepage/${provider.providerId}/update" method="post"
                    enctype="multipart/form-data">
                    <div class="card w-50 mb-3 mx-auto">
                        <div class="card-header text-center">
                            <h5>Account Settings</h5>
                        </div>
                        <div class="card-body">
                            <!-- Name -->
                            <div class="mb-3">
                                <label for="firstName" class="form-label">First Name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName"
                                    value="${provider.firstName}" required>
                            </div>
                            <div class="mb-3">
                                <label for="lastName" class="form-label">Last Name</label>
                                <input type="text" class="form-control" id="lastName" name="lastName"
                                    value="${provider.lastName}" required>
                            </div>
                            <!-- Address -->
                            <div class="mb-3">
                                <label for="address" class="form-label">Address</label>
                                <input type="text" class="form-control" id="address" name="address"
                                    value="${provider.address}">
                            </div>
                            <!-- Phone -->
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone Number</label>
                                <input type="text" class="form-control" id="phone" name="phone"
                                    value="${provider.phone}">
                            </div>
                            <!-- Cities -->
                            <div class="mb-3">
                                <label for="serviceableCities" class="form-label">Serviceable Cities</label>
                                <input type="text" class="form-control" id="serviceableCities" name="serviceableCities"
                                    value="${provider.serviceableCities}">
                            </div>
                            <!-- Email -->
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email"
                                    value="${provider.email}" required>
                            </div>
                            <!-- Password (optional: you can leave empty to not update) -->
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password"
                                    placeholder="••••••••••">
                            </div>
                            <!-- Certifications or Licenses Upload -->
                            <div class="mb-3">
                                <label for="certifications" class="form-label">Certifications or Licenses</label>
                                <input type="file" class="form-control" id="certifications" name="certifications"
                                    accept=".pdf,.jpg,.png,.docx">
                            </div>
                            <!-- Profile Picture Upload -->
                            <div class="mb-3">
                                <label for="picture" class="form-label">Profile Picture</label>
                                <input type="file" class="form-control" id="picture" name="picture" accept="image/*">
                            </div>
                            <!-- Submit button -->
                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-warning">Update Profile</button>
                            </div>
                        </div>
                    </div>
                </form>




</body>

</html>