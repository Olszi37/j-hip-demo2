(function() {
    'use strict';

    angular
        .module('jHipDemoApp')
        .controller('ClientDetailController', ClientDetailController);

    ClientDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Client'];

    function ClientDetailController($scope, $rootScope, $stateParams, previousState, entity, Client) {
        var vm = this;

        vm.client = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('jHipDemoApp:clientUpdate', function(event, result) {
            vm.client = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
