(function() {
    'use strict';

    angular
        .module('jHipDemoApp')
        .controller('RoomDialogController', RoomDialogController);

    RoomDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Room', 'beds'];

    function RoomDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Room, beds) {
        var vm = this;

        vm.room = entity;
        vm.clear = clear;
        vm.save = save;
        vm.beds = beds;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.room.id !== null) {
                Room.update(vm.room, onSaveSuccess, onSaveError);
            } else {
                Room.save(vm.room, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('jHipDemoApp:roomUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
