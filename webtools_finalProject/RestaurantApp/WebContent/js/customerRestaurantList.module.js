var customerRestaurantListModule = angular.module("customerRestaurantList.module");
customerRestaurantListModule
.controller('customerRestaurantListController', function($scope,$rootScope,searchService,$location) {
	var customerRestaurantListCtrl = this; // variable should be Same as controllerAs:
	console.log("customerRestaurantListModule");
	//searchCtrl.restaurantList = $rootScope.restaurantList;
	searchCtrl.search = {};
	searchCtrl.search.restaurantName = $location.search().restaurantName;
	searchCtrl.search.type = $location.search().type;
	
	searchCtrl.redirectToReviews = function(restaurantID){
		console.log("meyhod called");
		$location.path("/reviewList").search('restaurantID', restaurantID);
	}
	searchCtrl.searchRestaurant = function() {
		var dummyData = [
		                 {
		                	    "restaurantID": 1,
		                	 	"restaurantName": "xyz",
		                	    "location": "mumbai",
		                	    "star_rating": 1,
		                	    "type": "veg",
		                	    "approval_status": null
		                	  },
		                	  {
		                		"restaurantID": 2,
		                		"restaurantName": "rrrr",
		                	    "location": "lll",
		                	    "star_rating": 1,
		                	    "type": "Non-veg",
		                	    "approval_status": null
		                	  }
		                	];
		  searchService.searchRestaurant(searchCtrl.search).then(
			function(reponse){
				response = dummyData;
				restaurantList = reponse;
			//	$location.path("/restaurantList");
				console.log("successs");
			}, function(response){
					response = dummyData;
					searchCtrl.restaurantList = response;
					//$location.path("/restaurantList");
					console.log("error");
			});
	};
	searchCtrl.searchRestaurant();
});
	
	searchModule
	.factory('searchService', function($rootScope,$http,APP_CONSTANT) {
			var searchService = {};
			searchService.searchRestaurant = function (data) {
			 // var authdata = Base64.encode(data.username + ':' +
				// data.password);

	            /*
				 * Use this for real authentication
				 * ----------------------------------------------
				 */
	            return $http({
	            	method: 'GET',
	            	url: APP_CONSTANT.REMOTE_HOST+'/restaurant/getRestaurantList',
	            	params: {
	            		restaurantName: data.restaurantName,
	            		type: data.type
	            		
	            	}
	            });
	        };
	        return searchService;


	
});
