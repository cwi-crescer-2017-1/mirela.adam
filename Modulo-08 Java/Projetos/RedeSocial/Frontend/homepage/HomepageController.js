angular.module('app').controller('HomepageController', 
            function ($scope, $routeParams, $localStorage, $location, authService) {
    $scope.logout = authService.logout;
});