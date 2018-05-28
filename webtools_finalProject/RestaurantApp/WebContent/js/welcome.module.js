var welcomeModule = angular.module("welcome.module");
welcomeModule
.controller('welcomeController', function($scope,$rootScope,$location) {
	var welcomeCtrl = this; // variable should be Same as controllerAs:
							// 'authCtrl'
	welcomeCtrl.message = "";
	welcomeCtrl.error = false;
	welcomeCtrl.search = {};
	
	welcomeCtrl.redirectToRestaurantList = function(){
		console.log("meyhod called");
		$location.path("/restaurantList").search('restaurantName', welcomeCtrl.search.restaurantName);
	}
	welcomeCtrl.listofRestaurantByType= function(type){
		
		$location.path("/restaurantList").search('type',type);
	}
	
	welcomeCtrl.redirectToLogin = function(){
		console.log("abc");
		$location.path("/login");
	}
	
});
	