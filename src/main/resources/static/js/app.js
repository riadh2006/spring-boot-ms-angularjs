var app = angular.module("product-app", []);
app.controller("prod-ctrl", function($scope, $http) {
	$scope.produits = null;
	$http.get("http://localhost:8080/findProduct?field=ta")
	.then(function onSuccess(response) {
		// Handle success
		$scope.produits = response.status;
	}, function onError(response) {
		// Handle error
		var data = response.data;
		console.log(data);
	});

});