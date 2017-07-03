angular.module('app').controller('BuscaUsuariosController',
	function ($scope, $routeParams, $localStorage, $location, authService, toastr, UsuarioService, AmigoService) {
		$scope.logout = authService.logout;
		$scope.buscarUsuarios = buscarUsuarios;
		$scope.voltar = voltar;
		$scope.visualizarPerfil = visualizarPerfil;
		$scope.adicionarAmigo = adicionarAmigo;
		buscarUsuario();

        function buscarUsuario() {
            UsuarioService.buscarUsuarioLogado().then(response => {
                $scope.usuarioLogado = response.data;
            });
        };


		function adicionarAmigo(id){
			AmigoService.adicionarAmizade(id)
			.then (response => {
				toastr.success('Solicitação de amizade enviada!');
			})
		}

		function visualizarPerfil(id) {
			$location.path('/verPerfil/' + id);
		};

		function voltar() {
			$location.path('/homepage');
		};

		function buscarUsuarios(texto) {
			if ($scope.formBusca.$valid) {
				UsuarioService.buscarPorNomeOuEmail(texto)
					.then(response => {
						$scope.usuariosBuscados = response.data;
					});
			} else {
				toastr.warning('Informe dados para a pesquisa!');
			}
		};
	});