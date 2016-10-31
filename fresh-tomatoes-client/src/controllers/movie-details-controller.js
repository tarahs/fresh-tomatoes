angular.module('fresh-tomatoes').controller('MovieDetailsController',['$scope','movie','$mdDialog', function(scope, movie, $mdDialog){
    scope.movie = movie;
    scope.ratings = new Array(5);
    scope.close = function() {
          $mdDialog.cancel();
        };
}]);