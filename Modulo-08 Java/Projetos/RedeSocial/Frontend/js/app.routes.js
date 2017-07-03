angular.module('app').config(function ($routeProvider) { 
        $routeProvider 
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'login/login.html'
        })
        .when('/cadastroUsuario', {
            controller: 'CadastroUsuarioController',
            templateUrl: 'cadastroUsuario/cadastroUsuario.html'
        })
        .when('/homepage', { 
            controller: 'HomepageController', 
            templateUrl: 'homepage/homepage.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              } 
        })
        .when('/buscaUsuarios', { 
            controller: 'BuscaUsuariosController', 
            templateUrl: 'buscaDeUsuarios/buscaUsuarios.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              } 
        })
        .when('/verPerfil/:id', {
            controller: 'PerfilController',
            templateUrl: 'perfil/perfil.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              } 
        })
        .when('/buscaAmigos', {
            controller: 'AmigosController',
            templateUrl: 'amigos/amigos.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              } 
        })
        .when('/editarPerfil', {
            controller: 'EdicaoController',
            templateUrl: 'editarPerfil/editarPerfil.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              } 
        })
        .otherwise({redirectTo:'/login'}); 
});
