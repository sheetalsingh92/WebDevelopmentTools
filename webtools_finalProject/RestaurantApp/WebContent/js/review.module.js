var reviewModule = angular.module("review.module");
reviewModule
.controller('reviewController', function($scope,$rootScope,reviewService,$location){
	var reviewCtrl = this; 
	reviewCtrl.search={};
	reviewCtrl.search.restaurantID = $location.search().restaurantID;
	
	reviewCtrl.reviewRestaurant = function() {
		var dummyData = [
		                 {
		                	    "reviewId": 3,
		                	    "restaurantId": 15,
		                	    "comment": "aaaaa",
		                	    "starRating": 3,
		                	    "serviceRating": 3,
		                	    "foodRating": 3,
		                	    "cost": 300,
		                	    "comments": [
		                	      {
		                	        "commentId": 2,
		                	        "reviewId": 3,
		                	        "userName": "rajnikant1",
		                	        "commentDesc": "afsafsadfadsfasdd",
		                	        "replieses": []
		                	      }
		                	    ]
		                	  }
		                	];
		  reviewService.reviewRestaurant(reviewCtrl.search).then(
			function(reponse){
				response = dummyData;
				reviewCtrl.reviewList = reponse;
			//	$location.path("/restaurantList");
				console.log("successs");
			}, function(response){
					response = dummyData;
					reviewCtrl.reviewList = response;
					//$location.path("/restaurantList");
					console.log("error");
			});
	};
	reviewCtrl.reviewRestaurant();
});
	
	reviewModule
	.factory('reviewService', function($rootScope,$http,APP_CONSTANT) {
			var reviewService = {};
			reviewService.reviewRestaurant = function (data) {
			 // var authdata = Base64.encode(data.username + ':' +
				// data.password);

	            /*
				 * Use this for real authentication
				 * ----------------------------------------------
				 */
	            return $http({
	            	method: 'GET',
	            	url: APP_CONSTANT.REMOTE_HOST+'/reviewList',
	            	params: {
	            		restaurantID: data.restaurantID
	            		
	            	}
	            });
	        };
	        return reviewService;

	
});