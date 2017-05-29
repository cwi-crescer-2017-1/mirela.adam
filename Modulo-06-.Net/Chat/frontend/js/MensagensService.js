angular.module('chatCrescer').factory('MensagensService', function ($http) {
    function obterMensagens() {
        return $http.get('http://localhost:50024/Api/Mensagens');
    }

    function enviarMensagem(msg) {
        return $http.post('http://localhost:50024/Api/Mensagens', msg);
    }

    return ({
        obterMensagens: obterMensagens,
        enviarMensagem: enviarMensagem
    });

});