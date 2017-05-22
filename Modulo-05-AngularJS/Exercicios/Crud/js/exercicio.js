var myApp = angular.module('Aula3', []);

myApp.filter('transformaBoolean',function(){
  return function(booleano){
         return booleano? 'Sim' : 'Não';
  };
});


myApp.controller('MainController', function($scope) {
  let aulas = [{
    id: 0,
    nome: 'OO' // Obrigatório (length = min 3, max 20)
  },
  {
    id: 1,
    nome: 'Banco de Dados I'
  },
  {
    id: 2,
    nome: 'HTML e CSS'
  },
  {
    id: 3,
    nome: 'JavaScript'
  },
  {
    id: 4,
    nome: 'AngularJS'
  } ];
  
  $scope.aulas = aulas;

  var instrutores = [
  {
    id: 0,                            
    nome: 'Bernardo',                     
    sobrenome: 'Rezende',           
    idade: 30,                        
    email: 'bernardo@cwi.com.br',        
    dandoAula: true,                  
    aula: [0, 4],                     
    urlFoto: 'img/default.png'  
  }, 
  {
    id: 1,                            
    nome: 'André',                     
    sobrenome: 'Nunes',           
    idade: 33,                        
    email: 'nunes@cwi.com.br',        
    dandoAula: false,                  
    aula: [1],                     
    urlFoto: 'img/default.png'
  }
];

  $scope.instrutores = instrutores;

  if($scope.idInstrutor !== null){
    $scope.nome = 'Teste';
  }

  $scope.incluirInstrutor = function(instrutor) {
      if($scope.formInclusaoInstrutor.$invalid){
         return;
      }

      if(typeof instrutor.id === 'undefined'){

        for (a of $scope.instrutores) {
            if(instrutor.nome === a.nome && instrutor.sobrenome === a.sobrenome){
                window.alert('Instrutor já cadastrado.');
                $scope.novoInstrutor = {};
                return;
            }
            if(instrutor.email === a.email){
              window.alert('Email já está sendo utilizado');
              return;
            }
        }

      let proximoID = $scope.instrutores[$scope.instrutores.length-1].id;
      instrutor.id = proximoID+1;
      if (typeof instrutor.urlFoto === 'undefined') {
        instrutor.urlFoto = 'img/default.png';
      }
      instrutor.dandoAula = instrutor.dandoAula !== true ? false : true;
      for (let i=0; i < instrutor.aula.length; i++) {
          instrutor.aula[i] = Number(instrutor.aula[i]);
      }
      let copiaNovoInstrutor = angular.copy(instrutor);
      window.alert('Inclusão realizada com sucesso');
      $scope.instrutores.push(copiaNovoInstrutor);
      $scope.novoInstrutor = {};
      return;

      } else {
        for (ins of $scope.instrutores) {
          if(ins.id === instrutor.id){
            for (let i=0; i < instrutor.aula.length; i++) {
                instrutor.aula[i] = Number(instrutor.aula[i]);
            }

            typeof instrutor.nome === 'undefined'? ins.nome = instrutor.nome : null;
            
            ins.sobrenome = instrutor.sobrenome;
            
            ins.email = instrutor.email;
            
            ins.dandoAula = instrutor.dandoAula;
            
            ins.aula = instrutor.aula;
            
            ins.idade = instrutor.idade;
            
            window.alert('Alteração realizada com sucesso');
            $scope.novoInstrutor = {};
            return;
          }
        }
      }
      window.alert('Instrutor não cadastrado');
      $scope.novoInstrutor = {};
  }

  $scope.incluirAula = function(aula) {
      if($scope.formInclusaoAula.$invalid){
         return;
      }

      if(typeof aula.id === 'undefined'){
        
        for (a of $scope.aulas) {
            if(aula.nome === a.nome){
                window.alert('Aula já cadastrada.');
                $scope.novaAula = {};
                return;
            }
        }

        let proximoID = $scope.aulas[$scope.aulas.length-1].id;
        aula.id = proximoID+1;
        let copiaNovaAula = angular.copy(aula);
        $scope.aulas.push(copiaNovaAula);
        window.alert('Inclusão realizada com sucesso');
        $scope.novaAula = {};
        return;
      } else {
        for (a of $scope.aulas) {
          if(a.id === aula.id){
            a.nome = aula.nome;
            window.alert('Alteração realizada com sucesso');
            $scope.novaAula = {};
            return;
          }
        }
        window.alert("Aula não cadastrada.");

      } 
      $scope.novaAula = {};
  }

  $scope.excluirAula = function(id) {
      if($scope.formExcluirAula.$invalid){
         return;
      }
      for (var i = 0; i < $scope.aulas.length; i++) {
        if ($scope.aulas[i].id === id) {  
          for (ins of instrutores){
            for(var aux = 0; aux < ins.aula.length; aux++){
              if(ins.aula[aux] === id){
                window.alert('Não é possível excluir esta aula. Está sendo utilizada.');
                $scope.idAula = "";    
                return;
              }
            } 
          }
          $scope.aulas.splice(i, 1);
          window.alert('Aula excluída com sucesso.');
          $scope.idAula = "";    
          return;
        } 
      }
       window.alert('Aula não cadastrada.');
       $scope.idAula="";
      return;
  }

  $scope.formataAula = function(id){
         for (a of $scope.aulas) {
            if ( a.id === id ){
              return a.nome;
            }
         }
    
  };

    $scope.excluirInstrutor = function(id) {
      if($scope.formExcluirInstrutor.$invalid){
         return;
      }
      for (var i = 0; i < $scope.instrutores.length; i++) {
        if ($scope.instrutores[i].id === id) {  
            if(!$scope.instrutores[i].dandoAula) {
                $scope.instrutores.splice(i, 1);        
                window.alert('Instrutor excluído com sucesso.');
                $scope.idInstrutor = "";    
                return;
            } else {
                window.alert('Não é possível excluir este instrutor. Está dando aula.');
                $scope.idInstrutor = "";    
                return;
            }
        }
      } 
      window.alert('Instrutor não cadastrado.');
      $scope.idInstrutor = "";    
      return;
  }
  


});