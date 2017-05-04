package com.kilarukiran.publicposts.ResponseModel;

import java.util.Comparator;

/**
 * Created by kirankumarkilaru on 04/05/17.
 */

public class PhotoDateComparator implements Comparator<Photo> {
    @Override
    public int compare(Photo o1, Photo o2) {
        if(o1.getCreatedAt().before((o2.getCreatedAt())))
            return  1;
        if(o1.getCreatedAt().after(o2.getCreatedAt()))
            return -1;
        return 0;
    }
}
