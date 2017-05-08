var myModuleConfig = function($stateProvider, $urlRouterProvider){

    $urlRouterProvider.otherwise("/");

    $stateProvider.state("home", {
        url: "/",
        templateUrl: "/views/home.html"
    }).state("viewDepartments", {
        url: "/view-departments/",
        templateUrl: "/views/view-departments.html",
        controller: "viewDepartmentsController"
    }).state("admin", {
        url: "/admin/",
        templateUrl: "/views/admin/index.html"
    }).state("admin.departments", {
        url: "departments/",
        templateUrl: "/views/admin/departments/index.html",
        controller: "adminDepartmentsListController"
    }).state("admin.departments.add", {
        url: "add/",
        templateUrl: "/views/admin/departments/add.html",
        controller: "adminDepartmentsAddController"
    }).state("admin.departments.edit", {
        url: "edit/:departmentId",
        templateUrl: "/views/admin/departments/edit.html",
        controller: "adminDepartmentsEditController"
    });
};
myModuleConfig.$inject = ["$stateProvider", "$urlRouterProvider"];

// Services

var departmentsService = function($resource){
    return $resource("/api/departments/:id",{
    	id: "@departmentId"
    },{
    	update: {
    		method: "PUT"
    	}
    });
};
departmentsService.$inject = ["$resource"];


// Controllers

var viewDepartmentsController = function($scope, departmentsService){
    $scope.departments = departmentsService.query();
    $scope.filterText = "";
};

viewDepartmentsController.$inject = ["$scope", "departmentsService"];

var adminDepartmentsListController = function($scope, departmentsService, $state){
    $scope.departments = departmentsService.query();
    $scope.delete = function(department){
          department.$delete(function(){
              $state.reload();
          });
    };
};

adminDepartmentsListController.$inject = ["$scope", "departmentsService", "$state"];


var adminDepartmentsAddController = function($scope, departmentsService, $state){
    $scope.department = new departmentsService();
    $scope.fieldList = [];
    $scope.save = function(){
        $scope.department.employeeList = [];
        $scope.employee = {};
        for(var i = 0 ;i < $scope.fieldList.length;i++){
        	$scope.employee.name = $scope.fieldList[i].name;
        	$scope.employee.surname = $scope.fieldList[i].surname;
        	$scope.employee.salary = $scope.fieldList[i].salary;
        	$scope.department.employeeList.push($scope.employee);
        }
        $scope.department.$save(function(){
            $state.go("admin.departments", {}, {reload: true});
        });
    };
    
    $scope.addNewChoice = function() {
      var newItemNo = $scope.fieldList.length+1;
      $scope.fieldList.push({'id':'choice'+newItemNo});
    };
      
    $scope.removeChoice = function() {
      var lastItem = $scope.fieldList.length-1;
      $scope.fieldList.splice(lastItem);
    };
    
};
adminDepartmentsAddController.$inject = ["$scope", "departmentsService", "$state"];

var adminDepartmentsEditController = function($scope, departmentsService, $state, $stateParams){
    $scope.department = departmentsService.get({id: $stateParams.departmentId});

    $scope.update = function(){
        $scope.department.$update(function(){
            $state.go("admin.departments", {}, {reload: true});
        });
    };
};
adminDepartmentsEditController.$inject = ["$scope", "departmentsService", "$state", "$stateParams"];



// Init module
angular.module("myFirstAngularModule", ["ui.router", "ngResource"])
    .config(myModuleConfig)
    .factory("departmentsService", departmentsService)
    .controller("viewDepartmentsController", viewDepartmentsController)
    .controller("adminDepartmentsListController", adminDepartmentsListController)
    .controller("adminDepartmentsAddController", adminDepartmentsAddController)
    .controller("adminDepartmentsEditController", adminDepartmentsEditController);