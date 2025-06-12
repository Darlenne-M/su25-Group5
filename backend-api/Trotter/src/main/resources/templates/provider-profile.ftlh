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
                        <a class="nav-link" href="/provider-homepage/${providerId}/services/createForm">Create
                            Service</a>
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
                            <li><a class="dropdown-item" href="/provider-homepage/${provider.providerId}/updateForm">My
                                    Profile</a></li>
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



    <div class="d-flex justify-content-center">
        <div class="card w-50 mb-3">
            <div class="card-header">
                <h5 class="text-center mb-4">Account Settings</h5>
                <h6 class="text-center mb-4">Account Information</h5>
            </div>
            <div class="setting-group" id="group-name">
                <div class="card-body">
                    <form id="update-provider" action="/provider-homepage/${provider.providerId}/update" method="post"
                        enctype="multipart/form-data">

                        <div class="row">
                            <div class="col">
                                <label for="inputFirstName" class="form-label">First Name</label>
                                <input type="text" class="form-control" name="firstName" id="inputFirstName"
                                    value="${provider.firstName}" required>
                            </div>
                            <div class="col">
                                <label for="inputLastName" class="form-label">Last Name</label>
                                <input type="text" class="form-control" name="lastName" id="inputLastName"
                                    value="${provider.lastName}" required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label for="inputAddress" class="form-label">Address</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="address" id="inputAddress"
                                    value="${provider.address}" placeholder="Apartment, studio, or floor" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <label for="inputCity" class="form-label">City</label>
                                <input type="text" class="form-control" name="city" id="inputCity"
                                    value="${provider.city}" required>
                            </div>
                            <div class="col-md-4">
                                <label for="inputState" class="form-label">State</label>
                                <input type="text" class="form-control" name="state" id="inputState"
                                    value="${provider.state}" required>
                            </div>
                            <div class="col-md-2">
                                <label for="inputZip" class="form-label">Zip</label>
                                <input type="text" class="form-control" name="zip" id="inputZip" value="${provider.zip}"
                                    required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label for="inputPhone" class="form-label">Phone Number</label>
                            <div class="col-sm-10">
                                <input type="tel" class="form-control" name="phone" id="inputPhone"
                                    value="${provider.phone}" placeholder="123-456-7890" required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label for="inputEmail3" class="col-sm-3 col-form-label">Email</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" name="email" id="inputEmail3"
                                    value="${provider.email}" required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label for="inputPassword3" class="col-sm-3 col-form-label text-wrap">Password</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" id="inputPassword3"
                                    value="${provider.password}" required>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="formFileMultiple" class="form-label">Upload profile picture</label>
                            <input class="form-control" type="file" name="picture" id="formFileMultiple">
                        </div>

                        <button type="submit" class="btn btn-primary"
                            style="background-color: rgb(255, 123, 0); border-color: orange;">
                            Update Profile
                        </button>
                    </form>
                </div>
            </div>


            <a href="/providers/delete/${provider.providerId}" class="btn btn-primary"
                style="background-color: rgb(255, 123, 0); border-color: orange;"
                onclick="return confirm('Are you sure you want to delete your account?');">
                Delete Account
            </a>

        </div>


    </div>





</body>

</html>