var app = angular.module('AngularWorkshop',['ngRoute','ngResource']);

var translation = null;

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
        when('/Alumnos', { templateUrl: 'resources/scripts/app/templates/Alumnos.html' }).
        when('/Materias', { templateUrl: 'resources/scripts/app/templates/Materias.html' }).
        when('/Profesores', { templateUrl: 'resources/scripts/app/templates/Profesores.html' }).
        otherwise({ redirectTo: '/Materias' });
}]);