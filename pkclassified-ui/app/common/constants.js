'use strict';
/**
 * @ngdoc function
 * @name generatorApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the generatorApp
 */
angular.module('generatorApp')
.constant('TWO_MINUTES', 12000)
.constant('NO_OF_RECORDS_PER_PAGE', 6)
.constant('REQUEST_IN_MILLISECONDS',5000)
.constant('SERVICE_URLS',{
                GET_VENDORS_LIST_URL:'vendor/getVendorList',
                GET_SYSTEMS_URL :'system/getSystemDefinitionList',
                GET_COMPONENT_CODES_URL:'component/getComponentList',
                GET_VNDR_SYS_DTLS_URL:'vendor/getVendorSystemDetails'
});




// Vendor constants
// See style guide: http://go.up.com/angularstyleguide#vendor-globals
