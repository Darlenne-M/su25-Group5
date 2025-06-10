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
                        <a class="nav-link active" aria-current="page" href="../homepage.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Services Available</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../homepage.html#contact-us">Contact Us</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Account
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end"> <!-- Aligns dropdown to the right -->
                            <li><a class="dropdown-item" href="../log-in.html">Log In</a></li>
                            <li><a class="dropdown-item" href="../homepage.html#Home">Sign Up</a></li>

                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>

    <br>
    <div class="d-flex justify-content-center">
        <div class="card w-75 mb-3">
            <div class="card-header">
                <h5 class="text-center mb-4 bg-light">Your Journey as a Trusted Provider Starts Here.</h5>
            </div>
            <div class="card-body">
                <form id="new-provider" action="/providers" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col">
                            <label for="inputFirstName" class="form-label">First Name</label>
                            <input type="text" class="form-control" name="firstName" id="inputFirstName" required>
                        </div>
                        <div class="col">
                            <label for="inputLastName" class="form-label">Last Name</label>
                            <input type="text" class="form-control" name="lastName" id="inputLastName" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="inputAddress" class="form-label">Address</label>
                        <input type="text" class="form-control" name="address" id="inputAddress"
                            placeholder="Apartment, studio, or floor" required>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <label for="inputCity" class="form-label">City</label>
                            <input type="text" class="form-control" name="city" id="inputCity" required>
                        </div>
                        <div class="col-md-4">
                            <label for="inputState" class="form-label">State</label>
                            <select id="inputState" name="state" class="form-select" required>
                                <option value="" selected disabled>Choose...</option>
                                <option>NC</option>
                                <!-- add more states -->
                            </select>
                        </div>
                        <div class="col-md-2">
                            <label for="inputZip" class="form-label">Zip</label>
                            <input type="text" class="form-control" name="zip" id="inputZip" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="inputPhone" class="form-label">Phone Number</label>
                        <input type="tel" class="form-control" name="phone" id="inputPhone" placeholder="123-456-7890"
                            required>
                    </div>

                    <div class="row mb-3">
                        <label for="inputEmail3" class="col-sm-3 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" id="inputEmail3" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="inputPassword3" class="col-sm-3 col-form-label text-wrap">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password" id="inputPassword3" required>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="formFileMultiple" class="form-label">Upload certifications or licenses (if
                            applicable)</label>
                        <input class="form-control" type="file" name="picture" id="formFileMultiple">
                    </div>

                    <button type="submit" class="btn btn-primary"
                        style="background-color: rgb(255, 123, 0); border-color: orange;">
                        Sign Up
                    </button>
                </form>

            </div>
        </div>
    </div>


</body>

</html>