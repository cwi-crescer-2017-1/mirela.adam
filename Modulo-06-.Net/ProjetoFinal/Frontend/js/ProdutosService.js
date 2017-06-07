angular.module('app').factory('ProdutosService', function ($http) {
    var urlBase = 'http://localhost:55732/Api/Produtos'

    function listarProdutos() {
        return $http.get(urlBase);
    };

    return {
        listarProdutos: listarProdutos
    };

})