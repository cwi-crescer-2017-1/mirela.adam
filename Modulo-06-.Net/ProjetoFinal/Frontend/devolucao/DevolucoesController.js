angular.module('app').controller('DevolucoesController', 
            function ($scope, $routeParams, $localStorage, LocacoesService, $location,toastr) {
    
    listarLocacoesNaoDevolvidas()
    $scope.devolver = devolver;
    $scope.voltar = voltar;

    function listarLocacoesNaoDevolvidas() {
        LocacoesService.listarLocacoesNaoDevolvidas()
            .then (response => {
                $scope.locacoesNaoDevolvidas = response.data.dados;
            });
    };

    function devolver(locacao){
        let confirmou = confirm('Confirma devolução da locação?');
        if(confirmou){
            LocacoesService.devolver(locacao)
                .then (response => {
                toastr.success('Devolução efetuada com sucesso!');
                listarLocacoesNaoDevolvidas();
            });
        };    
    };

     function voltar(){
         $location.path('/homepage');
    }

});