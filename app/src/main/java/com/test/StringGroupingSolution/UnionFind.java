package com. test. StringGroupingSolution;

public class UnionFind
{
    Integer [] parentsList;

    UnionFind (int size)
    {
        if (size < 0)
        {
            throw new NegativeArraySizeException
                ("Negative array size in UnionFind is not allowed");
        }

        parentsList = new Integer [size];
        for (int i = 0; i < size; i++)
            parentsList [i] = i;
    }

    void union (int x, int y)
    {
        if (x < 0 || x >= parentsList. length)
        {
            throw new ArrayIndexOutOfBoundsException
                ("No parent for element " + x + " in UnionFind");
        }

        if (y < 0 || y >= parentsList. length)
        {
            throw new ArrayIndexOutOfBoundsException
                ("No parent for element " + y + " in UnionFind");
        }

        int xParent = find (x);
        int yParent = find (y);

        if (xParent != yParent)
            parentsList [xParent] = yParent;
    }

    int find (int x)
    {
        if (x < 0 || x >= parentsList. length)
        {
            throw new ArrayIndexOutOfBoundsException
                ("No parent for element " + x + " in UnionFind");
        }

        int curr = x;
        
        while (curr != parentsList [curr])
            curr = parentsList [curr];

        while (x != curr)
        {
            int next = parentsList [x];
            parentsList [x] = curr;
            x = next;
        }

        return curr;
    }
}
