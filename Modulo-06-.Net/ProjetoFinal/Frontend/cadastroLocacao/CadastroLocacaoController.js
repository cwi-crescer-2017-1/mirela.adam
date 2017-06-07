angular.module('app').controller('CadastroLocacaoController', 
            function ($scope, $routeParams, $localStorage, LocacoesService, ClientesService, 
                    ProdutosService, PacotesService, OpcionaisService, $location) {
    buscarConsoles();
    buscarPacotes();
    buscarOpcionais();
    $scope.cadastrar = cadastrar;
    $scope.buscarCliente = buscarCliente;

    function cadastrar(locacao){
        locacao.Id = 0;
        LocacoesService.cadastrarLocacao(locacao)
                    .then( function() {
                        window.alert('Locação cadastrada com sucesso!')
                        $location.path('/homepage'); 
                    });
    };

    function gerarOrcamento(){

    }

    function buscarCliente(cpf){
        ClientesService.buscarPorCpf(cpf)
        .then( response =>  {
            $scope.clienteBuscado = response.data.dados;               
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