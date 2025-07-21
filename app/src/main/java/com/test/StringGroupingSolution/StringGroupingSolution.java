package com. test. StringGroupingSolution;

import java. io. IOException;

public class StringGroupingSolution
{
    public static void main (String [] args)
    {
        if (args. length != 1)
            System. out. println ("Usage: java -jar {project_name}.jar {input_file_path}");

        try
        {
            new FileOutputWriter ("results.txt",
                new GroupingAlgorithmExecutor (new FileInputReader (args [0]).
                readStringsData ()). execute ()). writeGroupsData ();
        }
        catch (IOException e)
        {
            System. out. println ("Inpput Output operation exception");
            System. out. println (e. getMessage ());
            System. out. println ("No result written");
        }
    }
}