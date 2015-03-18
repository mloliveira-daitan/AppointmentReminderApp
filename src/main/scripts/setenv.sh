
export BANDWIDTH_API_ENDPOINT="https://api.catapult.inetwork.com"
export BANDWIDTH_API_VERSION='v1'
export BANDWIDTH_USER_ID='<your user id here>'
export BANDWIDTH_API_TOKEN='<your api token here>'
export BANDWIDTH_API_SECRET='<your api secret here>'
export HEROKU_APP_NAME='<your heroku app name here>'

export BANDWIDTH_USER_ID='u-m6vtffypexjt3k64ecumycy'
export BANDWIDTH_API_TOKEN='t-tlq3f7nk2w5fjxre7zdmirq'
export BANDWIDTH_API_SECRET='buh23662yqwejlzohuqzpkouao22wirmhlrmgnq'


export HEROKU_APP_NAME='sheltered-eyrie-4316'

heroku config:set BANDWIDTH_USER_ID='u-m6vtffypexjt3k64ecumycy' --app <heroku app name>
	heroku config:set BANDWIDTH_API_TOKEN='t-tlq3f7nk2w5fjxre7zdmirq' --app <heroku app name>
	heroku config:set BANDWIDTH_API_SECRET='buh23662yqwejlzohuqzpkouao22wirmhlrmgnq' --app <heroku app name>
	heroku config:set HEROKU_APP_NAME='calm-scrubland-9310' --app <heroku app name>