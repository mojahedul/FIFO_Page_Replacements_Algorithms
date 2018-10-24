First In First Out Page Replacement algorithm
===============================================

Category : Operating System

An implementation of First In First Out(FIFO) Page Replacement algorithm.

Description
------------

In a computer operating system that uses paging for virtual memory management, page replacement algorithms decide which memory pages to page out, sometimes called swap out, or write to disk, when a page of memory needs to be allocated. But, if the needed one that is already on memory, then page fault don't occurs.
Page fault occurs only when a page is needed but not resides in memory.

In FIFO Page Replacement algorithm, it mainly specifies as "The page which will be the first to be inserted will be the first(i.e: the oldest) to be replaced". That's the summary of FIFO Page Replacement algorithm.

Here, the occurrence set of pages is termed by reference string and the free frames number is the number of cells in queue.

Requirements
------------

This implementation is done in java. It requires (as input) :

 - A reference string of definite length
 - Free page frames number
 

Examples :
----------


    Input :
    -------
    
    Enter reference string (separating with space): 7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1
    Enter free frames number: 3
    3
    7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1

    Outputs for FIFO page replacement algorithm:
    --------------------------------------------

    7----
    7--0--
    7--0--1
    2--0--1
    2--3--1
    2--3--0
    4--3--0
    4--2--0
    4--2--3
    0--2--3
    0--1--3
    0--1--2
    7--1--2
    7--0--2
    7--0--1


    Reference string length: 20
    Page hit: 5
    Page fault number = Total page number - Page hit number
    Page fault number = 15
    Page fault rate = 75.0%
    
    
So, this is a sample inputs and outputs for the program. It may contain bugs, but then, it will be updated with fixes.
Thanks to all for paying a visit.
