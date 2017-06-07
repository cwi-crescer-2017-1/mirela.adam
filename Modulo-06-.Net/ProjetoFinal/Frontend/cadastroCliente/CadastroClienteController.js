angular.module('app').controller('CadastroClienteController', 
            function ($scope, $routeParams, $localStorage, ClientesService, $location) {

    $scope.cadastrar = cadastrar;
    $scope.voltar = voltar;

    function cadastrar(cliente){
        cliente.Id = 0;
        ClientesService.cadastrarCliente(cliente)
                    .then( function() {
                        window.alert('Cliente cadastrado com sucesso!')
                        $location.path('/homepage'); 
                    });
    };

    function voltar(){
         $location.path('/homepage');
    }

});