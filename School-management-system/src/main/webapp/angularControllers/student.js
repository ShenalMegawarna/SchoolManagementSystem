angular.module('demo', [])
.controller('student', function($scope, $http) {
    $http.get('http://localhost:8080/students').
        then(function(response) {
            $scope.students = response.data;
        });
    
    $scope.addStudent = function(){
    	$http.post('http://localhost:8080/student',$scope.student).
    	then(function(response) {
    		alert(response);
    	
    	});
    };
    
    $scope.del = function(student){
    	var result = confirm("Are you sure you want to delete " +student.firstName + " ?");
    	if(result === true){
    		$http.delete('http://localhost:8080/student/'+student.id).
    		then(function(response) {
        		alert("Successfully Deleted");
        	
        	});
    	}
    };
    
    
    $scope.edit = function(student){
    	var result = confirm("Are you going to edit " +student.firstName);
    	$scope.student = student;
    };
    
        
    $scope.update = function() {
    	$http.put('http://localhost:8080/student/', $scope.student).
		then(function(response) {
    		alert("Successfully Updated");
    	
    	});
    }
    
    
});