'use strict'

angular.module('app.controllers', [])

.controller('RandomQuoteCtrl', function($scope, $http, $stateParams, QuoteService) {
	
	QuoteService.random()
		.$promise.then(function(quote) {
			$scope.quote = quote;
			$http.get("/api/author/" + quote.authorId)
			.then(function(response) {
				$scope.author = response.data;
			});
		});
})
.controller('SaveQuoteCtrl', function($scope, $state, QuoteService) {
    
    $scope.saveQuote = function() {
        QuoteService.save(
            $scope.quote,
            function(response) {
                $state.go("quote", {});
            },
            function(err) {
                console.log(err);
            }
        );
    };
})
.controller('QuotesCtrl', function($scope, $http, $stateParams) {
	
	$http.get("/api/quote/" + $stateParams.authorId).then(function(quotes){
		
		$scope.quotes = quotes.data;
	})
});