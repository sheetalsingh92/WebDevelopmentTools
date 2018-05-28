var registerModule = angular.module("registration.module");
registerModule
.controller('registrationController', function($scope,$rootScope,$location,registerService){
	var registerCtrl = this;
	registerCtrl.credentials = {};
	
	registerCtrl.register = function() {
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
		registerService.register(registerCtrl.credentials).then(
			function(reponse){
				response = dummyData;
				//$location.path("/login");
			//	$location.path("/restaurantList");
				console.log("successs");
			}, function(response){
					//response = dummyData;
					//searchCtrl.restaurantList = response;
					//$location.path("/restaurantList");
					$location.path('/login');
					console.log("error");
			});
	};
	//registerCtrl.register();
});

registerModule
.factory('registerService', function($rootScope,$http,APP_CONSTANT) {
		var registerService = {};
		registerService.register = function (data) {
		 // var authdata = Base64.encode(data.username + ':' +
			// data.password);

            /*
			 * Use this for real authentication
			 * ----------------------------------------------
			 */
            return $http({
            	method: 'POST',
            	url: APP_CONSTANT.REMOTE_HOST+'/register',
            	params: {
            		username: data.username,
            		password: data.password,
            		name:data.name,
            		dob:data.dob,
            		gender:data.gender,
            		emailID:data.emailID,
            		usertype:data.usertype
            
            		
            	}
            });
		
        };
        return registerService;
});