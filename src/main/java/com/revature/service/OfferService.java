package com.revature.service;

import com.revature.model.Offer;
import com.revature.model.User;
import com.revature.repository.OfferRepository;
import com.revature.repository.UserRepository;

import java.util.List;

public class OfferService {
    private OfferRepository offerRepository;

    public OfferService(){offerRepository = new OfferRepository();}

    public List<Offer> getAllOffers() {
        return offerRepository.getAll();
    }

    public Offer createOffer(Offer offer){return offerRepository.create(offer);}


    public Offer getOfferById(int id){return offerRepository.getById(id);}

    public Offer updateOfferById(Offer offer){return offerRepository.update(offer);}

    public boolean deleteOfferById(int id){
        return offerRepository.deleteById(id);
    }
}
