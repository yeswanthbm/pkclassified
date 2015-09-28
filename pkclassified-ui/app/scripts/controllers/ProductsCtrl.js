'use strict';

/**
 * @ngdoc function
 * @name generatorApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the generatorApp
 */
angular.module('generatorApp')
  .controller('ProductsCtrl', function ($scope,$location,$log,commonDataService) {
    $log.info('Inside ProductsCtrl');
    var products = this;
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.isListView = true;
     $scope.getClass = function (path) {
      if ($location.path().substr(0, path.length) === path) {
        return 'active';
      } else {
        return '';
      }
    };

    products.myInterval = 5000;
    products.noWrapSlides = false;
    var slides = products.slides = [];
    products.addSlide = function () {
        var newWidth = 600 + slides.length + 1;
        slides.push({
            image: '//placekitten.com/' + newWidth + '/300',
            text: ['More', 'Extra', 'Lots of', 'Surplus'][slides.length % 4] + ' ' +
                  ['Cats', 'Kittys', 'Felines', 'Cutes'][slides.length % 4]
        });
    };
    for (var i = 0; i < 4; i++) {
        products.addSlide();
    }

    products.oneAtATime = true;
    products.categoryList = [];
    products.productList = [];

     function getAllCategory() {
    commonDataService.getCategories(products.categoryUrl, products.searchObj)
    .then(function (data) {
            // promise fulfilled
            products.categoryList = data;
        }, function (error) {
            $log.error('Other error: ' + error);
        });
    };
    products.categoryUrl = 'categories.json';
    products.searchObj = {};
    getAllCategory();

    function getAllProducts() {
    commonDataService.getCategories(products.productUrl, products.prodsearchObj)
    .then(function (data) {
            // promise fulfilled
            products.productList = data;
        }, function (error) {
            $log.error('Other error: ' + error);
        });
    };
    products.productUrl = 'products.json';
    products.prodsearchObj = {};
    getAllProducts();

    products.setCurrentProduct = function(product){
        commonDataService.setCurrentProduct(product);
    };

    products.selectedCategory = commonDataService.getSelectedCategory();
  });
