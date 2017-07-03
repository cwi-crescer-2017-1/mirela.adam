angular.module('app', ['ngRoute', 'auth', 'toastr']);

// Configurações utilizadas pelo módulo de autenticação (authService)
angular.module('app').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:9090/usuarios',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/homepage',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login'
});

angular.module('app').filter('formataSexo',function(){
  return function(sexo){
         if(sexo === 'F'){
         	return 'Feminino';
         } else if(sexo === 'M'){
         	return 'Masculino';
         }
         return 'Não Informado';
 };
});