angular.module('chatCrescer').controller('MensagensController', function ($scope, $routeParams, $localStorage, MensagensService) {
   
    $scope.enviarMensagem = enviarMensagem;
    $scope.usuario = { 
                        Nome:localStorage.getItem('nome'), 
                        UrlFoto:localStorage.getItem('foto') 
                    };

    intervaloParaBuscarMensagens();
    
    function obterMensagens() {
        MensagensService
        .obterMensagens()
        .then(response => {
            $scope.mensagens = response.data;
            console.log($scope.mensagens);
        })
    }

    function intervaloParaBuscarMensagens () {
            obterMensagens();
            setInterval(intervaloParaBuscarMensagens, 3000);
    }

    function enviarMensagem(msg) {
        msg.usuario = $scope.usuario;
        MensagensService
        .enviarMensagem(msg)
        .then(mensagens => {
            obterMensagens();
        })
        delete $scope.mensagem;
    }
});