var app = angular.module("product-app", []);
app.controller("prod-ctrl", function($scope, $http) {
	$scope.produits = null;
	$scope.motCLe = ""; 
	$scope.currentPage = 0; 
	$scope.size = 2; 
	
	$scope.chercherProduits = function (){
		
//		$http.get("http://localhost:8080/findProduct?field="+$scope.motCLe);
		$http.get("http://localhost:8080/findProduct?field="+$scope.motCLe
				+"&page=" + $scope.currentPage
				+"&size=" + $scope.size		
		)
		.then(function onSuccess(response) {
			// Handle success
			$scope.produits = response.data;
		}, function onError(response) {
			// Handle error
			var data = response.data;
			console.log(data);
		});
		
	}; 

});