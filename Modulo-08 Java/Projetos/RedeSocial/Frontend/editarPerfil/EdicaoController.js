angular.module('app').controller('EdicaoController',
	function ($scope, $routeParams, $localStorage, $location, $filter, toastr, authService, UsuarioService) {
		$scope.logout = authService.logout;
		$scope.voltar = voltar;
		$scope.alterar = alterar;

		buscarUsuario();

		function buscarUsuario() {
			UsuarioService.buscarUsuarioLogado().then(response => {
				$scope.usuario = response.data;
				$scope.usuario.nascimento = new Date($filter('date')($scope.usuario.nascimento, 'yyyy/MM/dd'));

			});
		};

		function voltar() {
			$location.path('/homepage');
		};

		function alterar(usuario) {
			if ($scope.formCadastro.$valid) {
				$scope.usuario.senha = $scope.novasenha;

				UsuarioService.editarUsuario(usuario).then(function () {
					toastr.success('Cadastro atualizado com sucesso!');
					$location.path('/homepage');
				});
			} else {
				toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
			}
		};


	});