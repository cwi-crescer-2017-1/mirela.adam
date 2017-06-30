angular.module('app').factory('UsuarioService', function ($http) {
    var urlBase = 'http://localhost:9090/usuarios';

    function listarUsuarios() {
        return $http.get(urlBase);
    };

    function cadastrarUsuario(usuario) {
        return $http.post(urlBase, usuario);
    };

    return {
        listarUsuarios: listarUsuarios,
        cadastrarUsuario: cadastrarUsuario
    };

})