angular.module('app').controller('AmigosController', 
            function ($scope, $routeParams, $localStorage, $location, authService, UsuarioService) {
$scope.logout = authService.logout;
$scope.voltar = voltar;
$scope.verPerfil = visualizarPerfil;

buscarAmigos($localStorage.usuarioLogado.username);

function visualizarPerfil(id){
	$location.path('/verPerfil/' + id);
};

function voltar(){
	$location.path('/homepage');
};

function buscarAmigos() {
	UsuarioService.buscarAmigos().then (response => {
		console.log(response.data);
		$scope.amigos = response.data;
	});
};

});