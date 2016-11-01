angular.module('fresh-tomatoes').controller('MovieReviewController',['$scope','MovieRatingsService','$mdDialog', function(scope, movieRatingsService, $mdDialog){

    scope.movies = null;
    scope.searchKey = "";

    scope.getMovies = function(){
        movieRatingsService.getMovies(scope.searchKey,function(data, error){

            if(error){
                return;
            }
            scope.movies = data.content;
        });
    };


    scope.ratings = new Array(5);

    scope.showMovieDetails = function(ev, movie) {
        $mdDialog.show({
          controller: 'MovieDetailsController',
          templateUrl: '/dist/views/movie-details.html',
          parent: angular.element(document.body),
          targetEvent: ev,
          clickOutsideToClose:true,
          locals:{
            movie: movie
          }, // Only for -xs, -sm breakpoints.
        })
        .then(function(answer) {
          scope.status = 'You said the information was "' + answer + '".';
        }, function() {
          scope.status = 'You cancelled the dialog.';
        });
      };

      scope.getMovies();

        scope.nextPage = function(){
            console.log("Next page please...");
        }

}]);