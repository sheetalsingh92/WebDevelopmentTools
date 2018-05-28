/**
 * 
 */
var configModule = angular.module('app'); // Please dont not use [], dependency 

configModule
.controller("applicationContoller", function($rootScope,$scope,$window) {
	
	$rootScope.userSession;
	$rootScope.showCustomerMenu = false;

	$scope.init = function () {
		$scope.parentmethod();
	}
	
	
	 $rootScope.$on("CallParentMethod", function(){
        $scope.parentmethod();
     });

     $scope.parentmethod = function() {
         // task
    	 	
    	 	var globals = JSON.parse($window.localStorage.getItem("globals"));
    	 	if(globals){
    	 		console.log('globals exits');
    	 		$('div#guest').hide();
    	 		$('div#logout').show();
     	 	$rootScope.userSession = globals.userSession;
//    	    	    if($rootScope.userSession.role === 'customer'){
//    	    	    		console.log('customer is valid');
//    	    	    		$rootScope.showCustomerMenu = true;
//    	    	    		console.log($scope.showCustomerMenu);
//    	    	    		$('div#custMenu').show();
//    	    	    		// $scope.$digest()
//    	    	    }
//
    	 	}else{
//    	 		$('div#custMenu').hide();
//    	 		$('div#merchantMenu').hide();
    	 		$('div#guest').show();
    	 		$('div#logout').hide();
    	 		console.log('globals note exits');
    	 	}
    	   
     }
	
})
;



