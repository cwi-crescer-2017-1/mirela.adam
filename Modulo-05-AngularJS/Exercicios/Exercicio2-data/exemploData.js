var myApp = angular.module('Exercicio01', []);

myApp.controller('Exercicio', function($scope) {
    $scope.formataData = formataData;

    
    function formataData(){
        let dataFormatada = $scope.dataTela.replace(/(\d{2})\/(\d{2})\/(\d{4})/, '$2.$1.$3');
        var dataObjeto =  new Date(dataFormatada); 
        $scope.dataObjeto = dataObjeto;
    }
});