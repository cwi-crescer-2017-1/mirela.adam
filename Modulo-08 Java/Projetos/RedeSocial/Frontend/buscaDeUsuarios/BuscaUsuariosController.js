angular.module('app').controller('BuscaUsuariosController', 
            function ($scope, $routeParams, $localStorage, $location, authService, UsuarioService) {
$scope.logout = authService.logout;
$scope.buscarUsuarios = buscarUsuarios;
$scope.voltar = voltar;
$scope.visualizarPerfil = visualizarPerfil;

function visualizarPerfil(id){
	$location.path('/verPerfil/' + id);
};

function voltar(){
	$location.path('/homepage');
};

function buscarUsuarios(texto) {
	UsuarioService.buscarPorNomeOuEmail(texto)
	.then (response => {
		$scope.usuariosBuscados = response.data;
	});	
};
});