var loginModule = angular.module("login.module");
loginModule
.controller('loginController', function($scope,$rootScope,$location,authService){
	var loginCtrl = this;
	loginCtrl.credentials = {};
	
	loginCtrl.login = function() {
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
		authService.login(loginCtrl.credentials).then(
			function(reponse){
				response = dummyData;
				$location.path("/");
			//	$location.path("/restaurantList");
				console.log("successs");
			}, function(response){
					//response = dummyData;
					$location.path("/")
					//searchCtrl.restaurantList = response;
					//$location.path("/restaurantList");
					console.log("error");
			});
	};
//	loginCtrl.login();
});

loginModule
.factory('authService', function($rootScope,$http,APP_CONSTANT) {
		var authService = {};
		authService.login = function (data) {
		 // var authdata = Base64.encode(data.username + ':' +
			// data.password);

            /*
			 * Use this for real authentication
			 * ----------------------------------------------
			 */
            return $http({
            	method: 'POST',
            	url: APP_CONSTANT.REMOTE_HOST+'/login',
            	params: {
            		username: data.username,
            		password: data.password
            		
            	}
            });
        };
        return authService;
});