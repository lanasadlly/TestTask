package com. test. StringGroupingSolution;

import java. util. ArrayList;
import java. util. HashMap;
import java. util. List;
import java. util. Map;

public class GroupingAlgorithmExecutor
{
    record StringPositionElement (String string, int position) {}

    private final List <String> stringList;
    private final Map <StringPositionElement, Integer> elementsMap;
    private final Map <Integer, List <String>> parentResultGroups;
    private final UnionFind unionFind;

    GroupingAlgorithmExecutor (List <String> stringList)
    {
        this. stringList = stringList;
        elementsMap = new HashMap <> ();
        parentResultGroups = new HashMap <> ();
        unionFind = new UnionFind (stringList. size ());
    }

    List <List <String>> execute ()
    {
        fillElementsMap ();
        fillParentResultGroups ();
        return sortGroups ();
    }

    private void fillElementsMap ()
    {
        int stringIndex = 0;
        for (String str : stringList)
        {
            String [] sections = str. split (";");

            for (int i = 0; i < sections. length; i++)
            {
                if (sections [i]. length () == 2)
                    continue;
                
                StringPositionElement element =
                    new StringPositionElement (sections [i], i);

                if (!elementsMap. containsKey (element))
                    elementsMap. put (element, stringIndex);
                else
                    unionFind. union (elementsMap. get (element), stringIndex);
            }

            stringIndex++;
        }
        
        elementsMap. clear ();
        System. gc ();
    }

    private void fillParentResultGroups ()
    {
        for (int i = 0; i < stringList. size (); i++)
        {
            int parent = unionFind. find (i);

            if (!parentResultGroups. containsKey (parent))
            {
                parentResultGroups. put (parent,
                    new ArrayList <> (List. of (stringList. get (i))));
            }
            else
                parentResultGroups. get (parent). add (stringList. get (i));
        }
    }

    private List <List <String>> sortGroups ()
    {
        List <List <String>> groups =
            new ArrayList <> (parentResultGroups. values ());

        groups. sort ((x, y) -> y. size () - x. size ());
        return groups;
    }
}
