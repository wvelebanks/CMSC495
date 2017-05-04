This is a functional program with the ability to clock in and clock out, as well as delete your previous entries

This program does NOT have database functionality which is what needs to be added. All the data here is hardcoded

If you notice, the data is loaded into session variables such as the timeEntry list ( which holds all the timesheet
entries for the user). This was done so that the jsp and other servlets pull from this variable rather than the
DB directly. This makes the program more modular and makes it easy to add the DB code.

All that needs to be done is for a DB query written to get the result set, and THEN load it into these session
variables. If we do it like this, none of the existing code will need to be modified; at least in terms of 
display

Several things to note:

- I had to gut the Employee and PunchTime classes so that i could effectivly test with it. If you notice the Date 
variables within these classes have been converted to String types, and so these will need to be reverted back. 
I also removed/modified a lot of these constructors. Fixing these classes wont take much work once the DB is incorporated

-the TestServlet class is essentially supposed to be the Login.java file we are using. Be sure to grab some of
the new code in the TestServlet class and add it to the Login.java file

-Dashboard.jsp has been modified to allow for the buttons to work, so we need to use the one here

-I included comments in all of these servlets that explain what the code does. It also includes 'suggestions'
as to where to incorporate the query

What needs to be done:

1. These classes/servlets need to be modified to work with the DB. The framework is there for the functionality 
already, it just needs DB access. (Justin/Wendy please take care of this)

2. The only functions not working on the timesheet page is the: Submit timesheet button and the status of the timesheet
Thats because we dont really know what happens when we click the submit button. We never determined what it should do
(All of us need to figure this out)

3. Edit Profile screen needs to allow the user to connect with the DB and make changes. Please refer to my JSP
code to see how I connected the buttons in the timesheet page to a servlet function. (Ianne was working on this, but
Justin/Wendy you will need to help with the DB portion)

4. Manage users screen needs to pull up all employees assigned to the supervisor (if they are one). We will liekly
not have time to allow the supervisor to view the timesheets or anything like that, but the table should hopefully work.
(Justin/Wendy your assistance for the DB portion is needed, Ianne if you are done with the Edit Profile screen you can
start on the servlet for this)



