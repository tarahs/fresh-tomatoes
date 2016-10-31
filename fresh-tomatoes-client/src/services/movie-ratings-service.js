angular.module('fresh-tomatoes').factory('MovieRatingsService',['$http', function(http){
    var self = this;
    return {
    		getMovies : function(searchKey,callback){
    			http({
                  method: 'GET',
                  url: '/api/movies?searchKey='+searchKey
                }).then(function successCallback(response) {
                    callback(response.data.data);
                  }, function errorCallback(response) {

                  });
    		}
    	}

}]);