*************************************************************************************************************
*                                         DEPARTMENT LIBRARY PROGRAM                                         *
*************************************************************************************************************

*** Intro:

This is a fully fledged dynamic web application with all functions working. The Degree to which these
functions are working might be rudementary, but they set a foundation to expand upon. For example, the
log in system is just a simple check against a preset login; its definetly not secure or anything like 
that, but utilizing a database it could be fleshed out.


*** About the program:

The program is a web application designed to be run footprint free from any browser. The program is
essentially a book tracker for a Library. There are already a few sample books entered in.

Users can view books, see if they're available, check out books, and even add new books into the library.
Users can view books but in order to do anything else, they will be required to log in. The program
will determine if there is a logged in session, and if there isnt they will be prompted to log in.

The program utilizes java servlets and javascript webpages.


*** Contents:

1. departmentLibrary folder: 10 .java source files
2. WEB-INF folder: includes  6 .jsp files


*** How to use:

1. Create a new project in Eclipse (be sure the web dev enviorment has been set up correctly, if not check out
my instructions)
2. Name the project 'Department Library' (be sure the runtimes are set correctly)
3. Create a new package and name it 'departmentLibrary'
4. Copy all the .java source files into this package
5. Next, copy all the .jsp files from the WEB-INF folder here into the WEB-INF folder of the project in Eclipse
6. Right click on the project or more specifically, on the DepartmentLibraryServlet.java and 
select "Run As -> Run on Server"
7. Select the local Tomcat server
8. If you get an error that says "HTTP Status 404 – Not Found", then simply paste the following in the
URL bar:  http://localhost:8080/Department_Library/DepartmentLibraryServlet
9. It should work, then feel free to play around with the program

The only login credentials are:
USERNAME: epetrosy
PASSWORD: abcd


*** Other Info:

This program was written and created by me, so feel free to use snippits of code or anything like that.

As you can see, we utilize an MVC (Model-View-Control) architecture here, with each component being seperate
but interacting with eachother. 

MODEL: The Model is the Java object (in this case LibraryModel.java and User.Java)
VIEW: The View is the Javascript files, which are responsible ONLY for displaying content and gathering input
CONTROL: The Control is the Java Servlets. They are responsible for processing input, and controling the flow 

With this set up, the user will only ever interact with the jsp portion of our program which adds to the 
security; the user will never have access to the actual program itself. Additionally, this seperation allows us
to make changes much easier. If we need to update the website, we will only mess around with the jsp files
and not have to touch the servlets. The opposite is true as well, if we need to modify the program, the jsp
portion remains intact. This allows for easy deployment of updates and changes.

























