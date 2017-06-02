angular.module('editoraCrescer').controller('LivrosController', 
            function ($scope, $routeParams, $localStorage, LivrosService, $location) {

    $scope.parametros = {
      quantidadePular: 0,
      quantidadeTrazer: 6
    };

    $scope.ListarLancamentos = ListarLancamentos;
    $scope.ListarLivros = ListarLivros;
    $scope.VerDetalhes = VerDetalhes;
    $scope.CarregarPagina = CarregarPagina;
    $scope.efetuarLogin = efetuarLogin;
    
    
    ListarLancamentos();
    ListarLivros();

    let paginaAtual = 1;

    function efetuarLogin(){
      $location.path('/administrativo');
    }

    function ListarLancamentos() {
        LivrosService
        .listarLancamentos()
        .then(response => {
            $scope.lancamentos = response.data.dados;
        })
    }

    function ListarLivros() {
        LivrosService
        .listarLivrosPaginacao($scope.parametros)
        .then(response => {
            $scope.livros = response.data.dados;
        })
    }
    
    function VerDetalhes(livro){
      $location.path('/livros/' + livro.Isbn);
    }
  
    LivrosService.listarLivros().then(response => {
       qtddPaginas(response.data.dados.length / 6)
    })
   
    function qtddPaginas(p) {
    $scope.paginas = [];
    for(var i = 1; i <= Math.ceil(p); i++) 
      $scope.paginas.push({indice: i}); 
    }
    
    function CarregarPagina(pagina) {
    if(pagina > paginaAtual) {
      $scope.parametros.quantidadePular += (pagina - 1) * 6;
    }
    else if(pagina < paginaAtual) {
      $scope.parametros.quantidadePular -= (pagina) * 6;
    }
    
    ListarLivros();
    paginaAtual = pagina;
  }
})