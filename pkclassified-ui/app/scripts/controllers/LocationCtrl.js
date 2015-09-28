'use strict';

/**
 * @ngdoc function
 * @name generatorApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the generatorApp
 */
angular.module('generatorApp')
  .controller('LocationCtrl', function ($scope,$location,$log,$rootScope) {
    $log.info('Inside LocationCtrl');
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.getClass = function (path) {
      if ($location.path().substr(0, path.length) === path) {
        return 'active';
      } else {
        return '';
      }
    };
  });
