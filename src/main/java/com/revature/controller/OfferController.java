package com.revature.controller;

import com.revature.model.Car;
import com.revature.model.Offer;
import com.revature.model.Status;
import com.revature.model.User;
import com.revature.service.OfferService;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class OfferController {

    private static final Logger logger = LoggerFactory.getLogger(OfferController.class);

    OfferService offerService = new OfferService();

    public Handler getAllOffers = ctx -> {
        List<Offer> offers = new ArrayList<>();
        offers = offerService.getAllOffers();


        String customerIdString = ctx.queryParam("userid");



        List<Offer> returnOffers = new ArrayList<>();
        if(customerIdString != null){
            int customerId = Integer.parseInt(customerIdString);
            for(Offer offer: offers){
                if(offer.getCustomerId() == customerId && offer.getStatus() == Status.OPEN)
                    returnOffers.add(offer);
            }
        }

        ctx.json(returnOffers);
    };

    public Handler getOfferById = ctx -> {
        String param = ctx.pathParam("offerid");
        int id = Integer.parseInt(param);

        Offer offer = offerService.getOfferById(id);
        if(offer != null) {
            ctx.status(200).json(offer);
        }else {
            ctx.status(400).json(parseError("Offer not found"));
        }
    };

    public Handler setOffer = ctx -> {
        Offer offer = ctx.bodyAsClass(Offer.class);
        Offer offerSet = offerService.createOffer(offer);

        if(offerSet == null){
            ctx.status(400).json(parseError("Invalid creation"));
        }else{
            ctx.status(201).json(offerSet);
        }
    };

    public Handler updateOfferById = ctx -> {
        Offer offer = ctx.bodyAsClass(Offer.class);
        Offer offerUpdate = offerService.updateOfferById(offer);
        if(offerUpdate == null){
            ctx.status(400).json(parseError("User not found"));
        }else{
            ctx.status(201).json(offerUpdate);
        }
    };

    public Handler deleteOfferById = ctx -> {
        //User user = ctx.bodyAsClass(User.class);
        String param = ctx.pathParam("offerid");
        if(!offerService.deleteOfferById(Integer.parseInt(param))){
            ctx.status(400).json(parseError("Offer not found"));
        }else{
            ctx.status(200).json(parseSuccess("Offer Deleted"));
        }
    };

    private String parseError(String message){
        logger.warn(message);
        return "{\"success\":false, \"message\":\"" + message + "\"}";
    }

    private String parseSuccess(String message){
        return "{\"success\":true, \"message\":\"" + message + "\"}";
    }
}
