angular.module('app').controller('AmigosController',
	function ($scope, $routeParams, $localStorage, $location, authService, AmigoService) {
		$scope.logout = authService.logout;
		$scope.voltar = voltar;
		$scope.verPerfil = visualizarPerfil;

		buscarAmigos();

		function visualizarPerfil(id) {
			$location.path('/verPerfil/' + id);
		};

		function voltar() {
			$location.path('/homepage');
		};

		function buscarAmigos() {
			AmigoService.buscarAmigos().then(response => {
				$scope.amigos = response.data;
			});
		};

	}); 	