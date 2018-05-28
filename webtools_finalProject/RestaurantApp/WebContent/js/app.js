/**
 * 
 */
'use strict';
 //Step 1: declare modules
 angular.module("search.module",[]);
angular.module("login.module",[]);
angular.module("welcome.module",[]);
 angular.module("addOwnertoRestaurant.module",[]);
 angular.module("addReview.module", []);
 angular.module("approveRestaurant.module", []);
 angular.module("createOwner.module", []);
 angular.module("createRestaurant.module", []);
 angular.module("customerRestaurantList.module", []);
 angular.module("deleteCustomer.module", []);
 angular.module("deleteOwner.module", []);
 angular.module("deleteRestaurant.module", []);
 angular.module("registration.module", []);
 angular.module("ownerRestaurantList.module", []);
 angular.module("review.module", []);
 angular.module("updateRestaurant.module", []);


 
 


 angular
 .module('appCoreModule', [
	 'ngRoute',
     'ngCookies',
     'ui.bootstrap'
 ]);
 
 
//Step 2: Register App
 var myapp = angular.module("app", 	
			['appCoreModule','welcome.module',
			'login.module',
			'search.module',
			'addOwnertoRestaurant.module',
			'addReview.module',
			'approveRestaurant.module',
			'createOwner.module',
			'createRestaurant.module',
			'customerRestaurantList.module',
			'deleteCustomer.module',
			'deleteRestaurant.module',
			'deleteOwner.module',
			'registration.module',
			'ownerRestaurantList.module',
			'review.module',
			'updateRestaurant.module'
		 ]);


myapp.controller("appController",function($location){
	var appCtrl =this;
	
	appCtrl.redirectToLogin = function(){
		console.log("abc");
		$location.path("/login");
	}
	
	appCtrl.redirectToRegister = function(){
		console.log("abc");
		$location.path("/register");
	}
	
});
	
	
	


