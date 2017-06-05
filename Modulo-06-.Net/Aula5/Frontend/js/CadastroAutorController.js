angular.module('editoraCrescer').controller('CadastroAutorController', 
            function ($scope, $routeParams, $localStorage, AutoresService, $location) {
$scope.cadastrar = cadastrar;

function cadastrar(autor){
        autor.id = 0;
        AutoresService.cadastrarAutor(autor)
                    .then( function() {
                        window.alert('Cadastrado com sucesso!')
                        $location.path('/administrativo'); 
                    });
    };
});