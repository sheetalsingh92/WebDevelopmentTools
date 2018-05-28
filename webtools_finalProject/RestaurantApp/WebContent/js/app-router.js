/**
 * 
 */

console.log("1");
var configModule = angular.module('app') // Please dont not use [], dependency 
.config(function($routeProvider, $locationProvider) {	
	console.log("2");	
	//    $urlRouterProvider.otherwise('/login');
	$routeProvider
    // route for the home page
	.when('/', {
		 templateUrl : 'partial/MainPage.html',
		 controller  : 'welcomeController',
     	controllerAs: 'welcomeCtrl'
	})
	.when('/restaurantList', {
		 templateUrl : 'partial/SearchRestaurant.html',
	     controller  : 'searchController',
	     controllerAs: 'searchCtrl'
	})
	.when('/register', {
		 templateUrl : 'partial/Register.html',
	     controller  : 'registrationController',
	     controllerAs: 'registerCtrl'
	})
	.when('/logout', {
		redirectTo: '/'
	})
   .when('/login', {
        templateUrl : 'partial/Login.html',
        controller  : 'loginController',
        controllerAs: 'loginCtrl'
        
    })
    .when('/reviewList', {
        templateUrl : 'partial/Reviews.html',
        controller  : 'reviewController',
        controllerAs: 'reviewCtrl'
    })
    .when('/resume/view', {
        templateUrl : 'partial/personal.html',
        controller  : 'personalController'
    })
    .when('/skill', {
        templateUrl : 'partial/skill.html',
        controller  : 'skillContoller',
        controllerAs: 'skillCtrl'
    })
    .when('/personal', {
        templateUrl : 'partial/personal.html',
        controller  : 'personalContoller',
        controllerAs: 'personalCtrl'
    })
    .otherwise({ redirectTo: '/' });
})


.run(
    function ($rootScope, $location, $cookieStore,$window, $http,AUTH_EVENTS,APP_CONSTANT) {
//    	Management 
    	$rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in
    		console.log('Clicked on '+$location.path());
            if ( !($location.path() == '/'
            		|| $location.path() == '/register'
            		|| $location.path() == '/login'
            			||$location.path() == '/restaurantList'
            			||$location.path() == '/reviewList')
            		  && !$rootScope.globals.userSession) {
            		console.log('Invalid Path')
                $location.path('/');
            }else if($location.path() == '/logout'){
            		$rootScope.$broadcast(AUTH_EVENTS.logoutSuccess);
            }else{
            	console.log('Valid Path');
            }
        });
    	
	$rootScope.$on(AUTH_EVENTS.loginFailed, function(event, next){
    		console.log('Login failed');
        

    		//$scope.message = "Login failed";
    });
	
	$rootScope.$on(AUTH_EVENTS.logoutSuccess, function(event, next){
		console.log('Logout Success');
		$window.localStorage.removeItem("globals");
		$rootScope.userSession=null;
	    $rootScope.$emit("CallParentMethod", {});

		//$scope.message = "Login failed";
});
    
    $rootScope.$on(AUTH_EVENTS.loginSuccess, function(event, next){
		//$scope.message = "Login Success";
		console.log('Login success');
	    $window.localStorage.setItem("globals", angular.toJson($rootScope.globals));
	    $rootScope.userSession = JSON.parse($window.localStorage.getItem("globals")).userSession;
	    
	    $rootScope.$emit("CallParentMethod", {});
	    
	    if($rootScope.globals.usersessin.role=='admin')
		$location.path('/dashboard');
	    
    });
    
    // keep user logged in after page refresh
    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.userSession) {
        $http.defaults.headers.common[APP_CONSTANT.AUTH_KEY] = $rootScope.globals.userSession.authKey; // jshint ignore:line
	    $window.localStorage.setItem("globals", angular.toJson($rootScope.globals));
	    $rootScope.userSession = JSON.parse($window.localStorage.getItem("globals")).userSession;

    }

    

})



