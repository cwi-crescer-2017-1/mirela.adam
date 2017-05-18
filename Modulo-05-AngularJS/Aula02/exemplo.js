var myApp = angular.module('Exercicio01', []);

myApp.controller('Exercicio', function($scope) {
    $scope.formataData = formataData;

    
    function formataData(){
        var pattern = '/(\d{2})\/(\d{2})\/(\d{4})/';
        var replace = '$1.$2.$3'
        var dataFormatada = $scope.dataTela.replace(pattern, replace);
        console.log(dataFormatada);
        var dataObjeto =  new Date(dataFormatada); 
        $scope.dataObjeto = dataObjeto;
    }
});