angular.module('fresh-tomatoes').factory('MovieRatingsService',['$http','$window', '$filter', function($http,$window,$filter){
    var self = this;

    return {
    		getMovies : function(searchKey,callback){
    			$http({
                  method: 'GET',
                  url: '/api/movies?searchKey='+encodeURIComponent(searchKey)
                }).then(function successCallback(response) {
                    if(!searchKey){
                        $window.localStorage.setItem('movies',JSON.stringify(response.data.data));
                    }
                    callback(response.data.data);
                  }, function errorCallback(response) {

                     var movies = JSON.parse($window.localStorage.getItem('movies'));

                     var moviesContent = movies.content;

                     if(searchKey){
                        moviesContent = $filter('filter')(moviesContent,{name:searchKey});
                        movies.content = moviesContent;
                     }
                     callback(movies);
                  });
    		}
    	}

}]);