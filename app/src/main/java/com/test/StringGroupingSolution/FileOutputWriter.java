package com. test. StringGroupingSolution;

import java. io. BufferedWriter;
import java. io. FileWriter;
import java. io. IOException;

import java. nio. file.Files;
import java. nio. file.Path;

import java. util. List;

public class FileOutputWriter
{
    private final String fileName;
    private final List <List <String>> groups;
    private final BufferedWriter fout;

    FileOutputWriter (String fileName, List <List <String>> groups)
        throws IOException
    {
        this. fileName = fileName;
        this. groups = groups;
        fout = new BufferedWriter (new FileWriter (fileName));
    }

    void writeGroupsData ()
        throws IOException
    {
        try
        {
            writeHeader ();
 
            for (int i = 0; i < groups. size (); i++)
                writeGroup (i);

            fout. flush ();
        }
        catch (IOException e)
        {
            Path path = Path. of (fileName);
            Files. deleteIfExists (path);
        }
    }

    private void writeHeader ()
        throws IOException
    {
        fout. write ("Число групп с более чем одним элементом: " +
            countGroupsWithMultipleElements ());

        fout. newLine ();
        fout. newLine ();
    }

    private void writeGroup (int num)
        throws IOException
    {
        fout. write ("Группа " + (num + 1));
        fout. newLine ();

        for (String str : groups. get (num))
        {
            fout. write (str);
            fout. newLine ();
        }

        fout. newLine ();
    }

    private int countGroupsWithMultipleElements ()
    {
        int multipleElementsGroupCount = 0;

        for (int i = 0; i < groups. size (); i++)
        {
            if (groups. get (i). size () > 1)
                multipleElementsGroupCount++;
            else
                break;
        }

        return multipleElementsGroupCount;
    }
}
