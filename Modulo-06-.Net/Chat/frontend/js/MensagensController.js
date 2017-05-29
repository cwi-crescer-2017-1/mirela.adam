angular.module('chatCrescer').controller('MensagensController', function ($scope, $routeParams, $localStorage, MensagensService) {
   var intervaloParaBusarMensagens = function () {
            obterMensagens();
            setInterval(intervaloParaBusarMensagens, 3000);
        }

    $scope.mensagens = {};
    $scope.enviarMensagem = enviarMensagem;
    $scope.usuario = { 
                        nome:localStorage.getItem('nome'), 
                        UrlFoto:localStorage.getItem('foto') 
                    };

    function obterMensagens() {
        MensagensService
        .obterMensagens()
        .then(response => {
            $scope.mensagens = response.data;
        })
    }

    function enviarMensagem(msg) {
        MensagensService
        .enviarMensagem(msg)
        .then(mensagens => {
            obterMensagens();
        })
        $scope.mensagem = "";
    }
});