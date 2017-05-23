angular.module('myApp').controller('AulaController', function($scope, aulaService) {
 
  carregarAulas();
  $scope.editar = editar;
  $scope.salvar = salvar;
  $scope.excluir = excluir;
  
  function carregarAulas(){
    let retorno = aulaService.list();

    retorno.then( function (response) {
     $scope.aulas = response.data; 
    })
  }

  function excluir(aula){
    let promise = aulaService.excluir(aula);
    promise.then( function(){
      carregarAulas();
    })
  };

  function salvar(aula){
    if($scope.formAula.$invalid){
      return;
    }
    
    let retorno;
    if(angular.isDefined(aula.id)){
      retorno = aulaService.editar(aula);
    } else {
      retorno = aulaService.incluir(aula);
    }

    retorno.then(function(){
      carregarAulas();
    })
    $scope.aulaNova = {};
  }

  function editar(aula) {
    $scope.aulaNova = angular.copy(aula);
  } 
});