angular.module('app').controller('CadastroClienteController', 
            function ($scope, $routeParams, $localStorage, ClientesService, $location, toastr) {

    $scope.cadastrar = cadastrar;
    $scope.voltar = voltar;

    function cadastrar(cliente){

        if ($scope.formCliente.$valid) {
        cliente.Id = 0;
        ClientesService.cadastrarCliente(cliente)
                    .then( function() {
                        toastr.success('Cadastro realizado com sucesso.', 'Cliente incluído!');
                        $location.path('/homepage'); 
                    });
        } else {
            toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
        }
    
};

    function voltar(){
         $location.path('/homepage');
    }

});