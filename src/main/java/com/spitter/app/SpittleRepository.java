package com.spitter.app;

import java.util.List;

/*
 To display a list of spittles in the home page
 */

public interface SpittleRepository {
    /*
    @params: max   - maximum ID of the spittle that should be returned
             count - number of spittle objects to be returned
     */
    List<Spittle> findSpittles(long max, int count);

    Object findOne(long spittleId);

    Spitter findByUserName(String userName);
}
