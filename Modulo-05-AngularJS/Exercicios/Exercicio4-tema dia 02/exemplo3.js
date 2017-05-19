var myApp = angular.module('Aula02', []);

myApp.filter('mascada',function(){
  return function(nome){
         return nome.replace(/(nunes)/i,'$ $1 $');
  };
});

myApp.filter('formataNomeAula', function() {
    return function(aula) {
        return aula.numero.toString().padStart(3, '0') + " - " + aula.nome.toUpperCase();
}
});

myApp.controller('Exemplo', function($scope) {
$scope.instrutores = instrutores;

var instrutores = [{
    nome: 'Bernardo',
    aula: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  },
  {
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  }
];



function insereAulaEProfessorEmArray() {
  var array = [];

  instrutores.forEach(function (i) {
      for(aula of i.aula) {
        array.push( { aula: aula, instrutor: i.nome } )
      }
    }
  )
  return array;
}

$scope.aulaInstrutor = insereAulaEProfessorEmArray();

});