(function() {
    'use strict';

    angular
        .module('jHipDemoApp')
        .controller('ReservationDialogController', ReservationDialogController);

    ReservationDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Reservation', 'Client', 'Room'];

    function ReservationDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Reservation, Client, Room) {
        var vm = this;

        vm.reservation = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.clients = Client.query();
        vm.rooms = Room.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.reservation.id !== null) {
                Reservation.update(vm.reservation, onSaveSuccess, onSaveError);
            } else {
                Reservation.save(vm.reservation, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('jHipDemoApp:reservationUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.date_from = false;
        vm.datePickerOpenStatus.date_to = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
