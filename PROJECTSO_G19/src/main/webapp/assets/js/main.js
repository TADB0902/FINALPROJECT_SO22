var employees = []
var departments = ["IT","Economical","Chemical"]
var startId = 0
reloadDepartments()
function loadInputEmployee() {
    var user = document.getElementById('user').value
    var pass = document.getElementById('pass').value
    var name = document.getElementById('name').value
    var dateOfBirth =  document.getElementById('dob').value
    var gender = document.querySelector('input[name="gender"]:checked').value
    var languages = document.querySelectorAll('input.checkboxLanguage:checked')
    languageStr = ""
    languages.forEach(function (language){
        //ternary
        languageStr = languageStr.length > 0 ? `${languageStr}<br>${language.value}`: `${language.value}`
    })
    var departmentElement = document.getElementById("departments")
    var department = departmentElement.options[departmentElement.selectedIndex].value
    var newEmployee = {user, pass, name, department, dateOfBirth, gender, languages: languageStr}
    return newEmployee
}
function btnAddDepartment() {
    var newDepartment = prompt("Please enter your new department:", "");
    if (newDepartment == null || newDepartment == "") {
        //do nothing
    } else {
        departments.push(newDepartment)
        reloadDepartments()
    }
}
function reloadDepartments() {
    var selectDepartments = document.getElementById("departments")
    if(!selectDepartments) {
        return
    }
    while (selectDepartments.length > 0) {
        selectDepartments.remove(selectDepartments.length-1);
    }
    departments.forEach(function (department){
        var option = document.createElement("option");
        option.setAttribute("value", department);
        option.innerHTML = department
        selectDepartments.appendChild(option)
    })
}
var validateInput = function () {
    var name = document.getElementById('name').value.trim()

    var dateOfBirth =  document.getElementById('dob').value.trim()
    if (name.length == 0 || dateOfBirth.length == 0){
        return false
    }
    return true
}
function btnAddEmployee(event) {
    if(validateInput() == false) {
        return
        //Ko lam gi them
    }
    var newEmployee = loadInputEmployee()
    newEmployee.id = startId
    employees.push(newEmployee)
    addRowDataToTable(newEmployee)
    event.preventDefault()
}

function addRowDataToTable(employeeObject) {
    startId = startId + 1
    var table = document.getElementById("tblEmployees");
    var row = table.insertRow(startId);
    var cellUser = row.insertCell(0);//column 0
    cellUser.innerHTML = employeeObject.user

    var cellPass = row.insertCell(1);//column 0
    cellPass.innerHTML = employeeObject.pass

    var cellName = row.insertCell(2);//column 0
    cellName.innerHTML = employeeObject.name

    var cellDepartment = row.insertCell(3);//column 1
    cellDepartment.innerHTML = employeeObject.department

    var cellDOB= row.insertCell(4);
    cellDOB.innerHTML = `${employeeObject.dateOfBirth}`

    var cellGender= row.insertCell(5);
    cellGender.innerHTML = employeeObject.gender

    var cellFinal= row.insertCell(6);
    cellFinal.innerHTML = `<a href="#" role="button" onclick="deleteEmployee(${employeeObject.id})">Delete</a>`
}
function reloadData() {
    var table = document.getElementById("tblEmployees");
    while(table.rows.length > 1) {
        table.deleteRow(table.rows.length - 1)
    }
    startId = 0
    employees.forEach(function(employee){
        addRowDataToTable(employee)
    })
}
function deleteEmployee(id) {
    if (confirm("Are you sure you want to delete this ?")) {
        employees = employees.filter(function (employee) {
            return employee.id != id
        })
        reloadData()
    }
}