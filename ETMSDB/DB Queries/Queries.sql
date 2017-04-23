-- retrieves the information for the summary of the timesheet
SELECT employee.FirstName, employee.LastName, timesheet.StartDate, timesheet.TimeIn, timesheet.TimeOut, timesheet.DateSubmitted, timesheet.PayPeriod, timesheet.Approval  
FROM etms_schemma.timesheet JOIN etms_schemma.employee
WHERE employee.employeeID = timesheet.EmployeeID;


-- retrieves usernames 
SELECT usertable.UserName  
FROM etms_schemma.usertable JOIN etms_schemma.employee
WHERE employee.employeeID = usertable.EmployeeID;


-- retrieve user name based on specified employee ID
SELECT usertable.UserName  
FROM etms_schemma.usertable 
WHERE etms_schemma.usertable.EmployeeID = 00001;

-- Retrieves all supervisors
SELECT employee.FirstName, employee.MiddleName, employee.LastName, employee.Phone, employee.Email, position.PositionName
FROM etms_schemma.employee JOIN etms_schemma.position
WHERE etms_schemma.position.PositionID = 1 AND etms_schemma.employee.PositionID = 1;

-- retrieves all suboradinates
SELECT employee.FirstName, employee.MiddleName, employee.LastName, employee.Phone, employee.Email, position.PositionName
FROM etms_schemma.employee JOIN etms_schemma.position
WHERE etms_schemma.position.PositionID = 2 AND etms_schemma.employee.PositionID = 2;
