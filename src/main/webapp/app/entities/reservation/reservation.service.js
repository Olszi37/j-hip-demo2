(function() {
    'use strict';
    angular
        .module('jHipDemoApp')
        .factory('Reservation', Reservation);

    Reservation.$inject = ['$resource', 'DateUtils'];

    function Reservation ($resource, DateUtils) {
        var resourceUrl =  'api/reservations/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.date_from = DateUtils.convertDateTimeFromServer(data.date_from);
                        data.date_to = DateUtils.convertDateTimeFromServer(data.date_to);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
