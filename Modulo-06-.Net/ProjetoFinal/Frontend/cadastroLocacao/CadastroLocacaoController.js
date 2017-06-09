angular.module('app').controller('CadastroLocacaoController', 
            function ($scope, $routeParams, $localStorage, LocacoesService, ClientesService, 
                    ProdutosService, PacotesService, OpcionaisService, $location, toastr) {

    $scope.cadastrar = cadastrar;
    $scope.buscarCliente = buscarCliente;
    $scope.voltar = voltar;
    $scope.exibirFormulario = false;
    $scope.gerarOrcamento = gerarOrcamento;
    $scope.mostrarValor = false;

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

    function gerarOrcamento(locacao){
        var total = 0;
        var totalDias = locacao.Pacote.QtdDias;

        for (var opcional of locacao.Opcionais) {
           total += opcional.ValorDiaria * totalDias;
        };
        total += locacao.Pacote.Valor;
        total += locacao.Produto.ValorDiaria * totalDias;
        
        $scope.valorOrcamento = total;
        $scope.mostrarValor = true;
    }

    function buscarCliente(cpf){
        ClientesService.buscarPorCpf(cpf)
        .then( response =>  {
            $scope.clienteBuscado = response.data.dados;  
            if ($scope.clienteBuscado !== null) {
                    buscarConsoles();
                    buscarPacotes();
                    buscarOpcionais();
                $scope.exibirFormulario = true;
            } else if(typeof cpf !== 'undefined'){
                toastr.warning('Cliente não localizado');
            };
        });
    };
    $scope.produtos = [];
    function buscarConsoles() {
        ProdutosService.listarProdutos()
            .then (response => {
                for (var produto of response.data.dados) {
                    if (produto.QtdEstoque !== 0){
                        $scope.produtos.push(produto);
                    };
                };
            })        
    };

    function buscarPacotes() {
        PacotesService.listarPacotes()
            .then (response => {
                $scope.pacotes = response.data.dados;
            });        
    };

    $scope.opcionais = [];
    function buscarOpcionais() {
        OpcionaisService.listarOpcionais()
            .then (response => {
                for (var opcional of response.data.dados) {
                    if (opcional.QtdEstoque !== 0){
                        $scope.opcionais.push(opcional);
                    };
                };
            });        
    };
});