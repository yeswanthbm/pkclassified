'use strict';

/**
 * @ngdoc function
 * @name generatorApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the generatorApp
 */
angular.module('generatorApp')
  .controller('CategoryCtrl', function ($scope,$location,$log,commonDataService) {
    var category = this;
    $log.info('Inside CategoryCtrl'+category);
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
    category.categoryList = [];

    function getAllCategory() {
    commonDataService.getCategories(category.categoryUrl, category.searchObj)
    .then(function (data) {
            // promise fulfilled
            category.categoryList = data;
        }, function (error) {
            $log.error('Other error: ' + error);
        });
    };
    category.categoryUrl = 'categories.json';
    category.searchObj = {};
    getAllCategory();

    category.setCategory = function(categoryName){
         commonDataService.setSelectedCategory(categoryName);
    };

});
