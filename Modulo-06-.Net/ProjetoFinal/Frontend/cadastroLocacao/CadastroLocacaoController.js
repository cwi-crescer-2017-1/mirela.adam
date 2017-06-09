angular.module('app').controller('CadastroLocacaoController', 
            function ($scope, $routeParams, $localStorage, LocacoesService, ClientesService, 
                    ProdutosService, PacotesService, OpcionaisService, $location, toastr) {
    buscarConsoles();
    buscarPacotes();
    buscarOpcionais();
    $scope.cadastrar = cadastrar;
    $scope.buscarCliente = buscarCliente;
    $scope.voltar = voltar;
    $scope.exibirFormulario = false;

    function voltar(){
         $location.path('/homepage');
    }

    function cadastrar(locacao){
        locacao.Id = 0;
        locacao.Cliente = $scope.clienteBuscado;
        LocacoesService.cadastrarLocacao(locacao)
                    .then( function() {
                        toastr.success('Locação cadastrada com sucesso!', 'Locação incluída');
                        $location.path('/homepage'); 
                    });
    };

    function gerarOrcamento(){

    }

    function buscarCliente(cpf){
        ClientesService.buscarPorCpf(cpf)
        .then( response =>  {
            $scope.clienteBuscado = response.data.dados;  
            $scope.exibirFormulario = true;
        });
    };

    function buscarConsoles() {
        ProdutosService.listarProdutos()
            .then (response => {
                $scope.produtos = response.data.dados;
            })        
    };

    function buscarPacotes() {
        PacotesService.listarPacotes()
            .then (response => {
                $scope.pacotes = response.data.dados;
            })        
    };

    function buscarOpcionais() {
        OpcionaisService.listarOpcionais()
            .then (response => {
                $scope.opcionais = response.data.dados;
            })        
    };
});