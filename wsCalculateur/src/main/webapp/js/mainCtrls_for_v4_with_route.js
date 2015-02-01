var myAjsControllers = angular.module('myAjsControllers', []);
 
myAjsControllers.controller('ProductListCtrl', function ($scope,$http) {

 $http.get('data/products.json').success(function(data) {
	$scope.products = data;
	});

$scope.orderProp = '-date'; //by default , -date : ordre decroissant , date : ordre croissant

$scope.title = "list of smartphones";

});


myAjsControllers.controller('ProductDetailCtrl', ['$scope', '$routeParams',
 function($scope, $routeParams) {
 	$scope.prodId = $routeParams.prodId;
}]);
