angular.module('myApp', ['ngRoute']);

angular.module('myApp').filter('transformaBoolean',function(){
  return function(booleano){
         return booleano? 'Sim' : 'Não';
  };
});
