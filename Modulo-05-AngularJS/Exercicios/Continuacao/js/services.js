angular.module('myApp').factory('aulaService', function ($http) { 
  let urlBase = 'http://localhost:3000/aula';

  function getTodasAsAulas() { 
    return $http.get(urlBase); 
  }; 
 
  function editar(aula) { 
    return $http.put(urlBase + '/' + aula.id, aula);
  }; 

  function incluir(aula){
    return $http.post(urlBase, aula);
  }

  function excluir(aula) {
    return $http.delete(urlBase + '/' + aula.id);
  }
 
 
  return { 
    list: getTodasAsAulas, 
    editar: editar, 
    incluir: incluir,
    excluir: excluir
  }; 
});


angular.module('myApp').factory('instrutorService', function ($http) { 
  let urlBase = 'http://localhost:3000/instrutor';

  function getTodosOsInstrutores() { 
    return $http.get(urlBase); 
  }; 
 
 function editar(instrutor) { 
    return $http.put(urlBase + '/' + instrutor.id, instrutor);
  }; 

  function incluir(instrutor){
    return $http.post(urlBase, instrutor);
  }

  function excluir(instrutor) {
    return $http.delete(urlBase + '/' + instrutor.id);
  }

    return { 
    list: getTodosOsInstrutores, 
    editar: editar, 
    incluir: incluir,
    excluir: excluir
  }; 
});