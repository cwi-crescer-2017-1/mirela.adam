angular.module('app').controller('HomepageController',
    function ($scope, $routeParams, $localStorage, $location, authService, UsuarioService, PostService, toastr) {
        $scope.logout = authService.logout;
        $scope.buscarContatos = buscarContatos;
        $scope.buscarAmigos = buscarAmigos;
        $scope.editarPerfil = editarPerfil;
        $scope.enviarPost = enviarPost;
        $scope.verSolicitacoes = verSolicitacoes;

        buscarUsuario();

        function buscarUsuario() {
            UsuarioService.buscarUsuarioLogado().then(response => {
                $scope.usuario = response.data;
                buscarPosts($scope.usuario.id);
            });
        };

        function buscarPosts(id) {
            PostService.buscarPostagens(id).then(function (response) {            
                $scope.posts = response.data;                        
            });
        };

        function enviarPost(post) {
            if ($scope.formTexto.$valid) {
                post.id = 0;
                post.idusuario = $scope.usuario.id;
                post.datapost = new Date();

                PostService.cadastrarPost(post).then(function () {
                    toastr.success('Publicação realizada com sucesso!');
                    $scope.post.texto = "";
                    buscarPosts($scope.usuario.id);
                });
            } else {
                toastr.warning('Erro ao enviar post, tente novamente!');
            }
        };

        function verSolicitacoes(){
            $location.path('/solicitacoes');
        }

        function buscarAmigos() {
            $location.path('/buscaAmigos');
        };

        function buscarContatos() {
            $location.path('/buscaUsuarios');
        };

        function editarPerfil() {
            $location.path('/editarPerfil');
        };
    });