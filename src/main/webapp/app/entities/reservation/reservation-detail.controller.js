(function() {
    'use strict';

    angular
        .module('jHipDemoApp')
        .controller('ReservationDetailController', ReservationDetailController);

    ReservationDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Reservation', 'Client', 'Room'];

    function ReservationDetailController($scope, $rootScope, $stateParams, previousState, entity, Reservation, Client, Room) {
        var vm = this;

        vm.reservation = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('jHipDemoApp:reservationUpdate', function(event, result) {
            vm.reservation = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
