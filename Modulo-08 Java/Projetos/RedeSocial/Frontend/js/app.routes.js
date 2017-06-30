angular.module('app').config(function ($routeProvider) { 
        $routeProvider 
            .when('/login', {
            controller: 'LoginController',
            templateUrl: 'login/login.html'
            })
            .when('/homepage', { 
            controller: 'HomepagesController', 
            templateUrl: 'homepage/homepage.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              } 
        	})
            .otherwise({redirectTo:'/login'}); 
    });