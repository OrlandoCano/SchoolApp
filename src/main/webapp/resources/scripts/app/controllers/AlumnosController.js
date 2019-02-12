app.controller("AlumnosController", ['$scope', 'DataService',
                function ($scope, DataService) {
	
	var dialog = $('#infoModal');
	var infoText = $('#infoText'); 
	$scope.loadAlumno = function(id){
		var onSuccess = function(data){
			$scope.alumno = data;
		};
		var onError = function(data, error){
			console.error(data);
			console.error(error);
		}
		DataService.getAlumno(id, onSuccess, onError);
	};
	
	var loadAlumnos = function(){
		var onSuccess = function(data){
			$scope.alumnos = data;
			console.info($scope.alumnos);
		};
		var onError = function(data, error){
			console.error(data);
			console.error(error);
		}
		DataService.getAlumnos(onSuccess, onError);
	};
	
	$scope.deleteAlumno = function(id){
		var onSuccess = function(data){
			infoText.html("Alumno Deleted");
			if($scope.alumno.id === id){
				$scope.clear();
			}
			dialog.modal('show');
			loadAlumnos();
		};
		var onError = function(data, error){
			console.error(data);
			console.error(error);
		}
		DataService.removeAlumno(id, onSuccess, onError);
	};
	
	$scope.saveAlumno = function(){
		var onSuccess = function(data){
			console.info("alumno added");
			$scope.alumno = data;
			loadAlumnos();
		};
		var onError = function(data, error){
			console.error(data);
			console.error(error);
		}
		DataService.addAlumno($scope.alumno, onSuccess, onError);
	};
	$scope.clear = function(){
		$scope.alumno.id = null;
		$scope.alumno.firstName = null;
		$scope.alumno.lastName = null;
	}
	var init = function (){
		loadAlumnos();
	};
	
	init();
}]);