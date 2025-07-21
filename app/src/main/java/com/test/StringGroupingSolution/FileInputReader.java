package com. test. StringGroupingSolution;

import java. io. BufferedReader;
import java. io. FileReader;
import java. io. IOException;

import java. util. ArrayList;
import java. util. HashSet;
import java. util. List;
import java. util. Set;

public class FileInputReader
{
    private final String fileName;
    private final List <String> stringList;
    private final Set <String> stringSet;
    private final BufferedReader fin;

    FileInputReader (String fileName)
        throws IOException
    {
        this. fileName = fileName;
        stringList = new ArrayList <> ();
        stringSet = new HashSet <> ();
        fin = new BufferedReader (new FileReader (this. fileName));
    }

    List <String> readStringsData ()
        throws IOException
    {
        String str;
   
        StringIteration : while ((str = fin. readLine ()) != null)
        {
            if (str. isEmpty () || !stringSet. add (str))
                continue;

            String [] sections = str. split (";");

            for (String section : sections)
            {
                if (section. length () < 2)
                    continue;

                if (!section. startsWith ("\"") || !section. endsWith ("\""))
                    continue StringIteration;
            }

            stringList. add (str);
        }

        return stringList;
    }
}
