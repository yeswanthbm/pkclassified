'use strict';

/**
 * @ngdoc function
 * @name generatorApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the generatorApp
 */
angular.module('generatorApp')
  .controller('ProductDetailsCtrl', function ($scope, $location, $log, $modal, commonDataService) {
    $log.info('Inside ProductDetailsCtrl');
    var productDetails = this;
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

    productDetails.myInterval = 0;
    productDetails.noWrapSlides = false;
    var slides = productDetails.slides = [];
    productDetails.addSlide = function () {
        var newWidth = 1000 + slides.length + 1;
        slides.push({
            image: '//placekitten.com/' + newWidth + '/500',
            text: ['More', 'Extra', 'Lots of', 'Surplus'][slides.length % 4] + ' ' +
                  ['Cats', 'Kittys', 'Felines', 'Cutes'][slides.length % 4]
        });
    };
    for (var i = 0; i < 4; i++) {
        productDetails.addSlide();
    }
    productDetails.selectedCategory = commonDataService.getSelectedCategory();
    productDetails.selectedProduct =  commonDataService.getCurrentProduct();


    productDetails.items = ['item1', 'item2', 'item3'];

    productDetails.animationsEnabled = true;

    productDetails.open = function (size) {

        var modalInstance = $modal.open({
            animation: productDetails.animationsEnabled,
            templateUrl: 'myModalContent.html',
            controller: 'ModalInstanceCtrl',
            controllerAs: 'modalInstance',
            size: size,
            resolve: {
                items: function () {
                    return productDetails.items;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            productDetails.selected = selectedItem;
        }, function () {
            $log.info('Modal dismissed at: ' + new Date());
        });
    };

    productDetails.toggleAnimation = function () {
        productDetails.animationsEnabled = !productDetails.animationsEnabled;
    };

  });

// Please note that $modalInstance represents a modal window (instance) dependency.
// It is not the same as the $modal service used above.
angular.module('generatorApp').controller('ModalInstanceCtrl', function ($scope, $modalInstance, items) {
  var modalInstance = this;
  modalInstance.items = items;
  modalInstance.selected = {
    item: modalInstance.items[0]
  };

  modalInstance.ok = function () {
    $modalInstance.close(modalInstance.selected.item);
  };

  modalInstance.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});
