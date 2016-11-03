/**
 * Created by lihong on 16/10/25.
 */
(function(angular) {
    var AppController = function($scope, Item) {
        Item.query(function(response) {
            $scope.items = response ? response : [];
        });

        $scope.addItem = function(name) {
            new Item({
                name: name
            }).$save(function(item) {
                $scope.items.push(item);
            });
            $scope.newItem = "";
        };

        $scope.updateItem = function(item) {
            item.$update();
        };

        $scope.deleteItem = function(item) {
            item.$remove(function() {
                $scope.items.splice($scope.items.indexOf(item), 1);
            });
        };
    };

    AppController.$inject = ['$scope', 'Item'];
    angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));
