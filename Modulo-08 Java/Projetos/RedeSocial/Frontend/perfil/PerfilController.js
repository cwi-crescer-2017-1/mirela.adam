angular.module('app').controller('PerfilController',
    function ($scope, $routeParams, $localStorage, $location, authService, UsuarioService, PostService) {
        buscarUsuario($routeParams.id);
        buscarPosts($routeParams.id);
        $scope.logout = authService.logout;
        $scope.voltar = voltar;

        function buscarUsuario(id) {
            UsuarioService.buscarUsuarioPorId(id).then(function (response) {
                $scope.usuario = response.data;
            })
        };

        function voltar() {
            window.history.go(-1);
        }

        function buscarPosts(id) {
            PostService.buscarPostagensPorUsuario(id).then(function (response) {
                $scope.posts = response.data;
            });
        };

    });