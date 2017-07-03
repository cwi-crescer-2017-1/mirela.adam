angular.module('app').controller('AmigosController',
	function ($scope, $routeParams, $localStorage, $location, authService, AmigoService) {
		$scope.logout = authService.logout;
		$scope.voltar = voltar;
		$scope.verPerfil = visualizarPerfil;
		$scope.exibirAmigos = false;

		buscarAmigos();

		function visualizarPerfil(id) {
			$location.path('/verPerfil/' + id);
		};

		function voltar() {
			$location.path('/homepage');
		};

		function buscarAmigos() {
			AmigoService.buscarAmigos().then(response => {
				if(response.data.length !== 0){
					$scope.amigos = response.data;
					$scope.exibirAmigos = true;
				} 
			});
		};

	}); 	