angular.module('app').controller('EdicaoController', 
            function ($scope, $routeParams, $localStorage, $location, $filter, authService, UsuarioService) {
    $scope.logout = authService.logout;
    $scope.voltar = voltar;

    buscarUsuario();

    function buscarUsuario(){
    	UsuarioService.buscarUsuarioLogado().then( response => {
    		$scope.usuario = response.data;
    		$scope.dataTela = $filter('date')($scope.usuario.nascimento,'dd/MM/yyyy') ;
    	});
    };

    function voltar(){
		$location.path('/homepage');
	};

	function alterar(usuario) {
		if ($scope.formCadastro.$valid) {
        	UsuarioService.editarUsuario(usuario).then( function (){
            	toastr.success('Cadastro atualizado com sucesso!');
            	$location.path('/homepage');
        });
    	} else {
        	toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
    	}
	};


});