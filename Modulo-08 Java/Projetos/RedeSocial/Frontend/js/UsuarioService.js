angular.module('app').factory('UsuarioService', function ($http) {
    var urlBase = 'http://localhost:9090/usuarios';

    function listarUsuarios() {
        return $http.get(urlBase);
    };

    function cadastrarUsuario(usuario) {
        return $http.post(urlBase, usuario);
    };

    function buscarPorNomeOuEmail(texto){
        return $http.get(urlBase+"/buscar/"+texto);
    }

    function buscarUsuarioPorId(id){
        return $http.get(urlBase + "/perfil/" + id);
    }

    function buscarAmigos(){
        return $http.get(urlBase + "/amigos");
    }

    function buscarUsuarioPorEmail(email){
        return $http.get(urlBase + "/" + email);
    }

    return {
        buscarUsuarioPorEmail: buscarUsuarioPorEmail,
        buscarAmigos: buscarAmigos,
        buscarUsuarioPorId: buscarUsuarioPorId,
        buscarPorNomeOuEmail: buscarPorNomeOuEmail,
        listarUsuarios: listarUsuarios,
        cadastrarUsuario: cadastrarUsuario
    };

})