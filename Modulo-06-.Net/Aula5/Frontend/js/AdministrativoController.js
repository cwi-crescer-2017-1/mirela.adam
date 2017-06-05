angular.module('editoraCrescer').controller('AdministrativoController', 
            function ($scope, $routeParams, $localStorage, LivrosService, AutoresService, $location) {
        
    ListarLivros();
    ListarAutores();

    $scope.revisar = revisar;
    $scope.publicar = publicar;
    $scope.cadastrarLivro = cadastrarLivro;
    $scope.cadastrarAutor = cadastrarAutor;
    $scope.excluirLivro = excluirLivro;
    $scope.excluirAutor = excluirAutor;
    $scope.editarAutor = editarAutor;

    function ListarLivros() {
        LivrosService
        .listarLivros()
        .then(response => {
            $scope.livros = response.data.dados;
        })
    };

    function ListarAutores() {
        AutoresService
        .listarAutores()
        .then(response => {
            $scope.autores = response.data.dados;
        })
    };

    function excluirLivro(livro){

    let confirmou = confirm('Confirma exclusão do livro?');
    if(confirmou){
       LivrosService   .excluirLivro(livro.Isbn)
                        .then(response => {
                            window.alert('Livro excluído com sucesso!');
                            ListarLivros();
                        })
    }}

    function excluirAutor(autor){
    let confirmou = confirm('Confirma exclusão do autor?');
    if(confirmou){
       AutoresService   .excluirAutor(autor.Id)
                        .then(response => {
                            window.alert('Autor excluído com sucesso!');
                            ListarAutores();
                        })
    }};

    function revisar(livro){
        LivrosService.detalharLivro(livro.Isbn).then(function (response) {
        $scope.livroRevisao = response.data.dados[0];
        let confirmou = confirm('Confirma revisar o livro?');
        if(confirmou){
            let dataAtual = new Date(); 
            dataAtual = dataAtual.getFullYear() + '-' + (dataAtual.getMonth() + 1) + '-' +  dataAtual.getDate();
            $scope.livroRevisao.DataRevisao = dataAtual;
            LivrosService .alterarLivro($scope.livroRevisao)
                          .then (response => {
                              window.alert('Livro revisado com sucesso!');
                              ListarLivros();
                          } );
        };
    });
};

    function publicar(livro){
        LivrosService.detalharLivro(livro.Isbn).then(function (response) {
        $scope.livroPublicacao = response.data.dados[0];
        let confirmou = confirm('Confirma publicar o livro?');
        if(confirmou){
            let dataAtual = new Date(); 
            dataAtual = dataAtual.getFullYear() + '-' + (dataAtual.getMonth() + 1) + '-' +  dataAtual.getDate();
            $scope.livroPublicacao.DataPublicacao = dataAtual;
            LivrosService .alterarLivro($scope.livroPublicacao)
                          .then (response => {
                              window.alert('Livro publicado com sucesso!');
                              ListarLivros();
                          } );
        };
    });

};

    function cadastrarAutor(){
         $location.path('/cadastrarAutor');
    };

    function cadastrarLivro(){
         $location.path('/cadastrarLivro');
    };

    function editarAutor(autor){
      $location.path('/editarAutor/' + autor.Id);
    }
})