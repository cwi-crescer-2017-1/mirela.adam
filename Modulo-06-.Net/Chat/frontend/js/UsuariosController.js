angular.module('chatCrescer').controller('UsuariosController', function ($scope, $routeParams, $localStorage, UsuariosService){
    $scope.adicionarUsuario = adicionarUsuario; 

    function listarUsuarios() {
            UsuariosService.listarUsuarios().then(function (response) {
                $scope.usuarios = response.data;
            });
    }

    function adicionarUsuario(usuario){
        UsuariosService.cadastrarUsuario(usuario).then(function (response){
            localStorage.setItem('nome', usuario.Nome,toString());
            localStorage.setItem('foto', usuario.UrlFoto,toString());
            location.href = '#!/chat';
            listaUsuarios();
        });
    }
})