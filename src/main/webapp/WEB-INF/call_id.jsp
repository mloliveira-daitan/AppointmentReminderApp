<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="com.reminder.bean.CallBean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% CallBean callBean=(CallBean)request.getAttribute("callBean");
pageContext.setAttribute("call", callBean.getBean());
%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bandwidth Sample App</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">

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
		<a href="./start" class="btn btn-lg btn-success">Start A New Call</a>
		</div>


		<div class="row">
			<div class="col-md-8 col-md-offset-2">

				<div class="well well-lg">
					<h4>Call Details</h4>
					<table class="table table-bordered">
						<!-- DETECT IF THIS IS A FORM SUBMISSION AND DISPLAY NOTICE CALL IS STARTING-->
						<tbody><tr><td>id:</td><td>${call.id}</td></tr>
						       <tr><td>state:</td><td>${call.state}</td></tr>
						       <tr><td>direction:</td><td>${call.direction}</td></tr>
						       <tr><td>to:</td><td>${call.to}</td></tr>
						       <tr><td>from:</td><td>${call.from}</td></tr>
						       <tr><td>startTime:</td><td>${call.startTime}</td></tr>
						       <tr><td>activeTime:</td><td>${call.activeTime}</td></tr>
						       <tr><td>endTime:</td><td>${call.endTime}</td></tr>
						       <tr><td>chargeableDuration:</td><td>${call.chargeableDuration}</td></tr>
						       <tr><td>callbackUrl:</td><td>${call.callbackUrl}</td></tr>
						       <tr><td>transcriptionEnabled:</td><td>${call.transcriptionEnabled}</td></tr>
						       <tr><td>transcriptions:</td><td>${call.transcriptions}</td></tr>
						       <tr><td>recordingEnabled:</td><td>${call.recordingEnabled}</td></tr>
						       <tr><td>recordings:</td><td>${call.recordings}</td></tr>
						       <tr><td>events:</td><td>${call.events}</td></tr>
					</tbody></table>
				</div>		
			</div>
		</div>

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="bootstrap-3.1.1/js/bootstrap.min.js"></script>


</body></html>