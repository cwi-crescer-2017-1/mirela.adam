angular.module('app').controller('HomepageController', 
            function ($scope, $routeParams, $localStorage, $location, authService, UsuarioService, PostService, toastr) {
    $scope.logout = authService.logout;
    $scope.buscarContatos = buscarContatos;
    $scope.buscarAmigos = buscarAmigos;
    $scope.editarPerfil = editarPerfil;
    $scope.enviarPost = enviarPost;

    buscarUsuario();
    buscarPosts();

    function buscarUsuario(){
    	UsuarioService.buscarUsuarioLogado().then( response => {
			$scope.usuario = response.data;		
    	});
    };

    function buscarPosts(){
        PostService.buscarPostagens().then(function(response){
            $scope.postagens = response.data;
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
                buscarPosts();
        });
        } else {
            toastr.warning('Erro ao enviar post, tente novamente!');
        }
    }

    function buscarAmigos(){
    	$location.path('/buscaAmigos');
    };

    function buscarContatos(){
    	$location.path('/buscaUsuarios');
    };

    function editarPerfil(){
        $location.path('/editarPerfil');
    };
});