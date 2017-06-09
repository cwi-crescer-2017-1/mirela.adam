angular.module('app').controller('RelatoriosController', 
            function ($scope, $routeParams, $localStorage, $location, LocacoesService) {
    
    listarLocacoesAtrasadas();
    $scope.voltar = voltar;
    $scope.listarLocacoes = listarLocacoesMensais;
    $scope.exibirRelatorioMensal = false;

    function voltar(){
         $location.path('/homepage');
    }

    function listarLocacoesAtrasadas() {
        LocacoesService.listarLocacoesAtrasadas()
            .then (response => {
                $scope.locacoesAtrasadas = response.data.dados;
            });
    };

    function listarLocacoesMensais(dataFiltro) {
        LocacoesService.listarLocacoesMensais(dataFiltro)
            .then (response => {
                $scope.locacoes = response.data.dados;
                $scope.valorTotal = calculaTotalLocacoes($scope.locacoes);
                $scope.exibirRelatorioMensal = true;
            });
    };

    function calculaTotalLocacoes(locacoes){
        var valorTotal = 0;
        for (var l of locacoes) {
            valorTotal += l.ValorRealLocacao;
        };
        return valorTotal;
    }

});