<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Ученики</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
        crossorigin="anonymous">
</head>

    <h1 class="display-5 fw-bold">Список учеников</h1>
    <#list studentList as student>
    <div class="col-lg-6 mx-auto">
      <form class="p-4 p-md-3 border rounded-5 bg-light" action="" method="post">
        <div class="row row-cols-7">
          <div class="row row-cols-3">
            <div class="display-7 fw-bold">
              <p>Имя :</p>
            </div>
            <div class="display-7 fw-bold">
              ${student.firstName}
            </div>
          </div>
          <div class="row row-cols-3">
            <div class="display-7 fw-bold">
              <p>фамилия :</p>
            </div>
            <div class="display-7 fw-bold">
              ${student.lastName}
            </div>
          </div>
          <div class="row row-cols-3">
            <div class="display-7 fw-bold">
              <p>учиться ? :</p>
            </div>
            <div class="display-7 fw-bold">
              ${student.isStudent}
            </div>
          </div>
        </div>
      </form>
    </div>
  </#list>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>