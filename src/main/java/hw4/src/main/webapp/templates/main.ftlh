<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Страница Поиска</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
        crossorigin="anonymous">
</head>
<body>
<div class="px-4 py-5 my-5 text-center">
  <h1 class="display-5 fw-bold">Поиск учеников</h1>


  <div class="col-lg-6 mx-auto">
    <form class="p-4 p-md-3 border rounded-5 bg-light" method="post">
      <div class="row row-cols-3">
        <div>
          <input type="text" class="form-control" id="studentCourseName" name="studentCourseName"
                 placeholder="введите название курса" required="" >
        </div>
        <div>
        </div>
      </div>
    </form>
  </div>
   <form class="p-4 p-md-3 border rounded-5 bg-light" method="post">
    <button class="w-10 btn btn-primary btn-lg" type="submit" value="">Искать</button>
  </form>
  <div class="px-4 py-5 my-5 text-center">
    <h1 class="display-5 fw-bold">Поиск учителей</h1>
    <div class="col-lg-6 mx-auto">
      <form class="p-4 p-md-3 border rounded-5 bg-light" method="post">
        <div class="row row-cols-3">
          <div>
            <input type="text" class="form-control" id="teacherCourseName" name="teacherCourseName"
                   placeholder="введите название курса" required="" >
          </div>
          <div>
          </div>
        </div>
      </form>
    </div>

    <form class="p-4 p-md-3 border rounded-5 bg-light" method="post">
      <button class="w-10 btn btn-primary btn-lg" type="submit" value="">Искать</button>
    </form>
    </form>
  </div>


</body>
</html>