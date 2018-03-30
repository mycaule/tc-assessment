
<p align="center">
  March 2018 TC Interview Assessment
</p>

<p align="center">
  <a href="http://travis-ci.org/mycaule/tc-assessment"><img src="https://api.travis-ci.org/mycaule/tc-assessment.svg?branch=master" alt="Build Status"></a>
  <br>
  <br>
</p>


## Running the project
```
sbt test
```

## Comments on the assignment

### Find missing elements

The idea of the solution is to recreate a list of all contiguous possible values and then eliminate the elements from the original array (sieve of Erathosthenes).

Scala `Set` would be the best structure to constrain the algorithm as the order of the output elements are not defined by a specific rule. The `Set` structure guarantees that there are no duplicates.

If you constrain the output to be sorted that solution doesn't use sets :

```scala
(arr.min to arr.max).filterNot(arr.contains(_))
```

| Description                  | Cost   | Comments                             |
|------------------------------|--------|--------------------------------------|
| Compute *Min* & *Max*        | *O(K)* | Iterate the list                     |
| Set to array conversion      | *O(N)* | Iterate the list and compute a hash  |
| Difference or check contains | *O(N)* | Finding an element and delete element|
| Total                        | *O(N)* |

*K* is the length of the original list, *N* = *Max* - *Min*.

Overall complexity is *O(N)* in both cases. Memory needed is *O(N)* although twice memory is needed in the case we use `Set`.

### Find distinct count

Considering what we told earlier on `Set`, a first naive implementation is to convert the original `Array` to a `Set`, or to use directly `Array.distinct`.

Complexity is *O(N)*, but for 30 days of data from big traffic website, the amount of memory needed is too much to handle for a single machine.

A modern technique is to distribute the data between a cluster of machines, to count the distinct values on each machine and reassemble the results. Spark is a framework to do parallel computing and provides a library to do it in Scala.

We provide an implementation in the `Exo2Spark` object.

### References

Some links on the documentation to go further.
- [Scala - Seqs](https://docs.scala-lang.org/overviews/collections/seqs.html)
- [Scala - Arrays](https://docs.scala-lang.org/overviews/collections/arrays.html)
- [Scala - Sets](https://docs.scala-lang.org/overviews/collections/sets.html)
- [Scala - Performance Characteristics](https://docs.scala-lang.org/overviews/collections/performance-characteristics.html)
