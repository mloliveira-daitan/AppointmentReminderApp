This is a Appointment Reminder Application example from Bandwidth.

You'll need the following prerequisites to run these:

- A Bandwidth Application Platform account (https://catapult.inetwork.com/pages/signup.jsf)
- Maven installed (http://maven.apache.org/download.cgi#Installation)
- Jdk installed (http://www.oracle.com/technetwork/java/javase/downloads/index.html)

Create a new directory where you want to clone the example app and run the following commands from there:

	git clone git@github.com:mloliveira-daitan/ReminderApp.git
	cd ReminderApp

Now we want to deploy it to a running web server. These are the steps to deploy it to Heroku:

Heroku Deployment

You'll first need to ensure that you have a Heroku account and that the Heroku toolbelt has been installed for your environment (https://devcenter.heroku.com/articles/heroku-command)

The steps to deploy the example app to Heroku are:

1. Set up the git repo
2. Create a new Heroku app
3. Configure the Heroku app
4. Push the project to Heroku

Step 1 - Set up the git repo

	cd ReminderApp
	git init

Step 2 - Create a new Heroku app

	heroku apps:create

The following output will be showed in the console:

		Creating infinite-springs-9079... done, stack is cedar-14
    	https://infinite-springs-9079.herokuapp.com/ | git@heroku.com:infinite-springs-9079.git
    	Git remote heroku added

Your Heroku app name is <strong>infinite-springs-9079</strong>.

Step 3 - Configure the new Heroku app with your App Platform credentials and Heroku app name

Log into the Bandwidth Platform UI, go to "Account" tab and obtain your credentials. Then run the following commands:

	heroku config:set BANDWIDTH_USER_ID='<your user id from Bandwidth Platform>' --app <heroku app name>
	heroku config:set BANDWIDTH_API_TOKEN='<your api token from Bandwidth Platform>' --app <heroku app name>
	heroku config:set BANDWIDTH_API_SECRET='<your api secret from Bandwidth Platform>' --app <heroku app name>
	heroku config:set HEROKU_APP_NAME='<your Heroku app name here>' --app <heroku app name>

Step 4 - Push the project to heroku

	git push heroku master
	heroku ps:scale web=1

You can now verify that the app is successfully deployed:

	heroku logs -tail --app <heroku app name>

And you can run the app in your browser with the following command line:

	heroku 	open --app <heroku app name>

You can use the reminder application to call a number and do a simple gather menu.

You'll need a phone number on the app platform. You can get one by following these steps:

    Log in to the App Platform (https://catapult.inetwork.com/pages/login.jsf)
 	Go to the My Numbers tab and select Get New Numbers
 	Fill in the form for a number in your area and click the Search button
 	Select one of the numbers and click the Get Numbers button

Go to the reminder app, fill the "From Number" field with a Platform number and "To Number" field with a number you want to receive the call.
Click on the Create Call button. In a few seconds, you'll receive a phone call in your "To Number" phone.

You can go through the following options in your phone:

	Press 1 to terminate the call.
	Press 2 to listen to the appointment location details.
	Press 3 to repeat the menu.

At the same time, you can view information from this call, by clicking on the View Call Details button, leading to a table where you can see all current information from the call.


