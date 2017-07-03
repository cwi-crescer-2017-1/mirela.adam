angular.module('app').controller('SolicitacaoController',
    function ($scope, $routeParams, $localStorage, $location, authService, SolicitacaoService, AmigoService, toastr) {

        $scope.voltar = voltar;
        $scope.logout = authService.logout;
        $scope.aceitar = aceitar;
        $scope.existeSolicitacao = false;
        $scope.recusar = recusar;

        carregarSolicitacoes();

        function recusar(id){
            AmigoService.recusarSolicitacao(id)
            .then(response => {
                toastr.success('Solicitação excluída!');
                history.go(0);
            });
        };

        function aceitar(id){
            AmigoService.aceitarSolicitacao(id)
            .then(response => {
                toastr.success('Agora vocês são amigos!');
                history.go(0);
            });
        };

        function carregarSolicitacoes() {
            SolicitacaoService.carregarSolicitacoes()
                .then(response => {
                    if(response.data.length !== 0){
                        $scope.solicitacoes = response.data;
                        $scope.existeSolicitacao = true;
                    }
                })
        };

        function voltar() {
            $location.path('/homepage');
        };


    });