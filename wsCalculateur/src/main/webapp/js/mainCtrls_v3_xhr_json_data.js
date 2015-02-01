var myAjsApp = angular.module('myAjsApp', []);
 
myAjsApp.controller('ProductListCtrl', function ($scope,$http) {
 //jsonDataUrl = 'data/products.json';
 jsonDataUrl = 'services/rest/json/products';
 $http.get(jsonDataUrl).success(function(data) {
	$scope.products = data;
	});

$scope.orderProp = '-date'; //by default , -date : ordre decroissant , date : ordre croissant

$scope.title = "list of smartphones";

});