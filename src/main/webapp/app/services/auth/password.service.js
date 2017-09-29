(function() {
    'use strict';

    angular
        .module('jHipDemoApp')
        .factory('Password', Password);

    Password.$inject = ['$resource'];

    function Password($resource) {
        var service = $resource('api/account/change_password', {}, {});

        return service;
    }
})();
