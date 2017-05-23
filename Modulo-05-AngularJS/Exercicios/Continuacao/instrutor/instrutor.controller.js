
angular.module('myApp').controller('InstrutorController', function($scope, instrutorService) {
   carregarInstrutores();
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
    let promise = instrutorService.excluir(instrutor);
    promise.then( function(){
      carregarInstrutores();
    })
  };

  function salvar(instrutor){
    if($scope.formInstrutor.$invalid){
        return;
    }
    
    let retorno;
    if(angular.isDefined(instrutor.id)){
      retorno = instrutorService.editar(instrutor);
    } else {
      retorno = instrutorService.incluir(instrutor);
    }

    retorno.then(function(){
      carregarInstrutores();
    })
    $scope.novoInstrutor = {};
  };

  function editar(instrutor) {
    $scope.novoInstrutor = angular.copy(instrutor);
  }; 
 
 
  $scope.formataAula = function(id){
         for (a of $scope.instrutores) {
            if ( a.id === id ){
              return a.nome;
            }
         }
    };
});