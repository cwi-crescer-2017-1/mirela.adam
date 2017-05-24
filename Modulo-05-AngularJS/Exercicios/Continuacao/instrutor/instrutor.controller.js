
angular.module('myApp').controller('InstrutorController', function($scope, instrutorService, aulaService) {
  $scope.aulas = carregarAulas();
  $scope.instrutores = carregarInstrutores();

  $scope.editar = editar;
  $scope.salvar = salvar;
  $scope.excluir = excluir;
  
  function carregarInstrutores(){
    let retorno = instrutorService.list();

    retorno.then( function (response) {
     $scope.instrutores = response.data; 
    })
  };
 
   function excluir(instrutor){
    let confirmou = confirm('Confirma exclusão do registro?');
    if(confirmou){
      let promise = instrutorService.excluir(instrutor);
      promise.then( function(){
      window.alert('Instrutor excluído com sucesso!');
      carregarInstrutores();
    })
    }

  };

  function salvar(instrutor){
    if($scope.formInstrutor.$invalid){
        return;
    }

    let retorno;
    var msg;
    if(angular.isDefined(instrutor.id)){
      retorno = instrutorService.editar(instrutor);
      msg = 'Instrutor atualizado com sucesso!';
    } else {
      retorno = instrutorService.incluir(instrutor);
      msg = 'Instrutor incluído com sucesso!';
    }

    retorno.then(function(){
      window.alert(msg);
      carregarInstrutores();
    })
    $scope.novoInstrutor = {};
  };

  function editar(instrutor) {
    $scope.novoInstrutor = angular.copy(instrutor);
  }; 
  
  function carregarAulas(){
    let retorno = aulaService.list();

    retorno.then( function (response) {
     $scope.aulas = response.data; 
    })
  }
 
  $scope.formataAula = function(id){
         for (a of $scope.aulas) {
            if ( a.id === Number(id) ){
              return a.nome;
            }
         }
    };


});