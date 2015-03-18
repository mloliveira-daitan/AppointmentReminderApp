<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
     import="com.reminder.bean.NumbersBean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% NumbersBean numbersBean=(NumbersBean)request.getAttribute("numbersBean");
pageContext.setAttribute("numbers", numbersBean.getNumbers());
%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bandwidth Sample App</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="/javascript/reminderapp.js"></script>

    <!-- Custom styles for this template -->
    <style type="text/css">
		body {
		  padding-top: 50px;
		}
		.starter-template {
		  padding: 20px 15px;
		  text-align: center;
		}
		.navbar-header {
			height: 70px;
		}
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">

          <a class="navbar-brand" href="./"><img src="./img/logoTop.png"></a>
        </div>
      </div>
    </nav>

    <div class="container">

		<div class="starter-template">
		<h1>Bandwidth Sample App</h1>
		<p class="lead">Voice Appointment Reminders</p>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="well well-lg">
          <form class="form-horizontal" action="start_call.html" id="form-call">
            <div class="form-group">
              <label class="col-sm-4 control-label">Phone Number to Call "from"</label>
              <div class="col-sm-4">
                <select class="form-control" id="fromNumber">
<c:forEach items="${numbers}" var="number">
<option value='${number}'>${number}</option>
</c:forEach>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Phone Number to Call "to"</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="toNumber" placeholder="+15554443333">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-offset-4 col-sm-9">
                <button type="button" class="btn btn-success btn-lg" id='createCall'>Start Call</button>
              </div>
            </div>
          </form>
				</div>
			</div>
		</div>

    </div><!-- /.container -->

</body>
</html>


