angular.module('app').controller('CadastroLocacaoController', 
            function ($scope, $routeParams, $localStorage, LocacoesService, $location) {

    $scope.cadastrar = cadastrar;

    function cadastrar(locacao){
        locacao.Id = 0;
        LocacoesService.cadastrarLocacao(locacao)
                    .then( function() {
                        window.alert('Locação cadastrada com sucesso!')
                        $location.path('/homepage'); 
                    });
    };

});