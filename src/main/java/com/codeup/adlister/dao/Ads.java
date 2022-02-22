package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get a single ad by id
    Ad individualAdID(long id);
    //
    List<Ad> getAdsBySpecificUser(long id);
    // delete ad - alfonso
    void deleteAd(long id);
    // update ad - alfonso
    void updateAd(Ad ad);
    Ad findById(long id);
}
