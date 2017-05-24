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
     let confirmou = confirm('Confirma exclusão do registro?');
    if(confirmou){
    let promise = aulaService.excluir(aula);
    promise.then( function(){
      window.alert('Aula excluída com sucesso!')
      carregarAulas();
    })
    }
  };

  function salvar(aula){
    if($scope.formAula.$invalid){
      return;
    }
    
    let retorno;
    var msg;
    
    if(angular.isDefined(aula.id)){
      retorno = aulaService.editar(aula);
      msg = 'Aula atualizada com sucesso!';
    } else {
      retorno = aulaService.incluir(aula);
      msg = 'Aula incluída com sucesso!';
    }

    retorno.then(function(){
      window.alert(msg);
      carregarAulas();
    })
    $scope.aulaNova = {};
  }

  function editar(aula) {
    $scope.aulaNova = angular.copy(aula);
  } 
});