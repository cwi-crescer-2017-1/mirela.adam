angular.module('app').controller('PerfilController',
    function ($scope, $routeParams, $localStorage, $location, authService, UsuarioService, PostService) {
        buscarUsuario($routeParams.id);
        buscarPosts($routeParams.id);
        $scope.logout = authService.logout;
        $scope.voltar = voltar;
        $scope.exibirMensagem = false;

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
                if(response.data.length === 0){
                    $scope.mensagem = 'Usuário ainda não tem nenhuma publicação!';
                    $scope.exibirMensagem = true;
                } else {
                    $scope.posts = response.data;
                }
            });
        };

    });