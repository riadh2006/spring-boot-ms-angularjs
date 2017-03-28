var app = angular.module("product-app", []);
app.controller("prod-ctrl", function($scope, $http) {
	$scope.produits = null;
	$scope.motCLe = ""; 
	$scope.currentPage = 0; 
	$scope.totalPages = []; 
	$scope.size = 2; 

	$scope.goToPage = function (indexPage){
		$scope.currentPage = indexPage; 
		$scope.chercherProduits();
	};
	
	$scope.chercherProduits = function (){
		
		$http.get("http://localhost:8080/findProduct?field="+$scope.motCLe
				+"&page=" + $scope.currentPage
				+"&size=" + $scope.size		
		)
		.then(function onSuccess(response) {
			// Handle success
			$scope.produits = response.data;
			
			// First solution 
//			for (var int = 0; int < response.data.totalPages; int++) {
//				$scope.totalPages.push(int);
//			} 
			// Second solution 
			$scope.totalPages = new Array(response.data.totalPages);
			
		}, function onError(response) {
			// Handle error
			var data = response.data;
			console.log(data);
		});
		
	}; 

	$scope.getProduits = function (){
		
		$scope.currentPage = 0;
		$scope.chercherProduits();
		
	}; 

});