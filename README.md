SongManager

Song manager is a program that allows you to manage multiple lists of songs saved in XML and CSV formats. It is a tool that facilitates work. Allows you to enter songs into the system from an XML and CSV file. The following actions are possible:

-adding votes for individual songs and all -removing voices from a specific song and all voices -adding individual songs from the keyboard -sorting songs by parameters (voices / categories) -writing information after changes to the screen -saving information to XML and CSV files

The program does not allow you to add the same song multiple times, then it adds up the number of votes for song

The program is covered with Junit unit tests, checking the correctness of the operation of individual methods

The program was built on the basis of Apache Maven.

Running the program is possible on Linux and Windows systems


--------------------------------------------------------------------

To run the program in Windows:

1. Open the CMD command prompt
2. Navigate to the directory where the compile.bat file is located using the cd command
3. Enter the command "compile.bat"
4. Enter the command "run.bat"

To run the program in Linux:

1. Open a command prompt
2. Navigate to the directory where the compile.sh file is located using the cd command
3. Enter the command "compile.sh"
4. Enter the command "run.sh"

XML / CSV files that are to be loaded must be located in the ".. \target" folder 
