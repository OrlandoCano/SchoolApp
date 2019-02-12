app.factory('DataService',  ['$http', function ($http) {
		var baseApp = 'api';
	
	    var factory =
	    {
    		getAlumnos: function (callback,errorCallback) {
    			return $http.get(baseApp+'/alumnos').success(callback).error(errorCallback);
    		},
    		getAlumno: function (id, callback,errorCallback) {
    			return $http.get(baseApp+'/alumnos/'+id).success(callback).error(errorCallback);
    		},
    		addAlumno: function (params, callback,errorCallback) {
    			return $http.post(baseApp+'/alumnos', params).success(callback).error(errorCallback);
    		},
    		removeAlumno: function (id, callback,errorCallback) {
    			return $http.delete(baseApp+'/alumnos/'+id).success(callback).error(errorCallback);
    		},
    		
//    		Materias Services
    		getMaterias: function (callback,errorCallback) {
    			return $http.get(baseApp+'/materias').success(callback).error(errorCallback);
    		},
    		getMateria: function (id, callback,errorCallback) {
    			return $http.get(baseApp+'/materias/'+id).success(callback).error(errorCallback);
    		},
    		addMateria: function (params, callback,errorCallback) {
    			return $http.post(baseApp+'/materias', params).success(callback).error(errorCallback);
    		},
    		removeMateria: function (id, callback,errorCallback) {
    			return $http.delete(baseApp+'/materias/'+id).success(callback).error(errorCallback);
    		},
	    		
	    };
	    return factory;
	    
}]);
