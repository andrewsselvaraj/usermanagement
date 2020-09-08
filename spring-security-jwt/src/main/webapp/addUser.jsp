<!DOCTYPE html>
<html>
<head>
<title>
AngularJs $http.post() Service Method Example
</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript">
var app = angular.module('postserviceApp', []);
app.controller('postserviceCtrl', function ($scope, $http) {
$scope.name = null;
$scope.password = null;
$scope.status = null;
$scope.lblMsg = null;
$scope.postdata = function (name, password, status) {
var data = {
name: name,
password: password,
status: status
};
//Call the services
$http.post('http://localhost:8091/signup', JSON.stringify(data)).then(function (response) {
if (response.data)
$scope.msg = "Post Data Submitted Successfully!";
}, function (response) {
$scope.msg = "Service not Exists";
$scope.statusval = response.status;
$scope.statustext = response.statusText;
$scope.headers = response.headers();
});
};
});
</script>
</head>
<body>
<h2>AngularJS Http Post Method Example</h2>
<div ng-app="postserviceApp" ng-controller="postserviceCtrl">
<div>
Name : <input ng-model="name" /><br/><br/>
Age : <input ng-model="password" /><br/><br/>
Adress : <input ng-model="status" /><br/><br/>
<input type="button" value="Send" ng-click="postdata(name, age, status)" /> <br/><br/>
</div>
<p>Output Message : {{msg}}</p>
<p>StatusCode: {{statusval}}</p>
<p>Status: {{statustext}}</p>
<p>Response Headers: {{headers}}</p>
</div>
</body>
</html>