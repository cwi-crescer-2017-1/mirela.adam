angular.module('chatCrescer').factory('UsuariosService', function ($http) {
    function listarUsuarios() {
        return $http.get('http://localhost:50024/Api/Usuarios');
    };

    function cadastrarUsuario(usuario) {
        return $http.post('http://localhost:50024/Api/Usuarios', usuario);
    };

    return {
        listarUsuarios: listarUsuarios,
        cadastrarUsuario: cadastrarUsuario
    };
  
});