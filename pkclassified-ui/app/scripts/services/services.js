'use strict';

angular.module('generatorApp')
.factory('httpInterceptor', HttpInterceptor)
.factory('errorInterceptor', ErrorInterceptor)
.factory('commonDataService', commonDataService);

function commonDataService($http, $q, $log) {
    var selectedCategory;
    var currentProduct = [];
        ////////////


        function getErrorMessages() {
                var fireUrl = 'assets/resources/error-messages.json';
                $log.info('fireUrl : '+fireUrl);
                return $http.get(fireUrl)
                        .then(function(response) {
                                if (typeof response.data === 'object') {
                                        return response.data;
                                } else {
                                        // invalid response
                                        return $q.reject(response.data);
                                }

                        }, function(response) {
                                // something went wrong
                                return $q.reject(response.data);
                        });
        }

        function setSelectedCategory (categoryName) {
                selectedCategory = categoryName;
        }

        function getSelectedCategory () {
                return selectedCategory;
        }

        function setCurrentProduct (product) {
                currentProduct = product;
        }

        function getCurrentProduct () {
                return currentProduct;
        }
        function getCategories(serviceUrl, searchObj) {
                //var postdata = searchObj;
                var fixUrl = 'resources/';
                var fireUrl = fixUrl+serviceUrl;
                $log.info('fireUrl : '+fireUrl+searchObj);
                return $http.get(fireUrl)
                        .then(function(response) {
                                if (typeof response.data === 'object') {
                                        return response.data;
                                } else {
                                        // invalid response
                                        return $q.reject(response.data);
                                }
                        }, function(response) {
                                // something went wrong
                                return $q.reject(response.data);
                        });
        }

    var service = {
        /*getTableData: getTableData,
        SetRecordInDB : SetRecordInDB,*/
        setSelectedCategory : setSelectedCategory,
        getSelectedCategory : getSelectedCategory,
        getCategories: getCategories,
        getErrorMessages: getErrorMessages,
        setCurrentProduct : setCurrentProduct,
        getCurrentProduct : getCurrentProduct
    };
    return service;
}

function HttpInterceptor(SERVICE_URL) {
        return {
                'request': function(config) {
                        if (config.url.indexOf(SERVICE_URL) > -1 && angular.isDefined(config.data)) {
                                delete config.data.trainId;
                        }
                        return config;
                }
        };
}

/*
 * This is a very crude approach to handling application errors. You will most likely want
 * to develop a more realistic way of determining when your application errors can be removed from the screen.
 */
function ErrorInterceptor($q, $rootScope, SERVICE_URL) {
        var errors = [];
        $rootScope.errors = [];
        $rootScope.$on('$routeChangeSuccess', onSuccess);

        return {
                'response': handleResponse,
                'responseError': handleResponseError
        };

        function onSuccess() {
                errors = [];
                $rootScope.errors = [];
        }

        function handleResponse(response) {
                return response || $q.when(response);
        }

        function handleResponseError(rejection) {

                var defaultErrorMessage = 'There was an error while loading the page',
                        connectionRefusedError = 'Unable to connect to server';

                if ((rejection.status === 0 || rejection.status === 404 || rejection.status === 500) && rejection.config.url === SERVICE_URL + '/train') {
                        errors = [
                                'Check out the Spring MVC archetype to get the train service that goes along with this code deployed!',
                                'http://go.up.com/SpringMVCArchetype.  If you have this set up, check your Spring MVC context to check that they match!'
                        ];
                }
                // swallow errors that just print out the HTML of the apache error page and generically
                // catch application errors and their statuses and place them on the rootScope.
                // Again, this will need to be reconsidered for each application
                // to determine how to handle these error messages.
                else if (rejection.data.indexOf('<!DOCTYPE')) {
                        if (rejection.status === 0) {
                                addUniqueError(connectionRefusedError);
                        } else if (!!rejection.data && rejection.status) {
                                addUniqueError(rejection.data + ' (' + rejection.status + ')');
                        } else {
                                addUniqueError(defaultErrorMessage);
                        }
                } else {
                        addUniqueError(defaultErrorMessage);
                }

                $rootScope.errors = errors;
                return $q.reject(rejection);
        }

        function addUniqueError(error) {
                if (!!error && errors.indexOf(error) === -1) {
                        errors.push(error);
                }
        }

}
