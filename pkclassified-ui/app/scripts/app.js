'use strict';

/**
 * @ngdoc overview
 * @name generatorApp
 * @description
 * # generatorApp
 *
 * Main module of the application.
 */
angular
  .module('generatorApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap',
    'ezplus'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/location', {
        templateUrl: 'views/location.html',
        controller: 'LocationCtrl'
      })
      .when('/category', {
        templateUrl: 'views/category.html',
        controller: 'CategoryCtrl',
        controllerAs: 'category',
      })
      .when('/products', {
        templateUrl: 'views/products.html',
        controller: 'ProductsCtrl',
        controllerAs: 'products'
      })
      .when('/productDetails', {
        templateUrl: 'views/productDetails.html',
        controller: 'ProductDetailsCtrl',
        controllerAs: 'productDetails'
      })
      .when('/addpost', {
        templateUrl: 'views/addPost.html',
        controller: 'AddPostCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/contacts', {
        templateUrl: 'views/contacts.html',
        controller: 'ContactsCtrl'
      })
      .otherwise({
        redirectTo: '/location'
      });
  });

angular.module('generatorApp').controller('NavController', function($scope, $location,$rootScope)
    {

    $rootScope.userLocation = 'Hyderabad';
        $scope.getClass = function (path) {
          if ($location.path().substr(0, path.length) === path) {
            return 'active';
          } else {
            return '';
          }
        };
    });
