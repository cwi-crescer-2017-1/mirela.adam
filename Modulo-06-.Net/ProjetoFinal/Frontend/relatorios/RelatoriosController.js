angular.module('app').controller('RelatoriosController', 
            function ($scope, $routeParams, $localStorage, $location) {

     function voltar(){
         $location.path('/homepage');
    }

});