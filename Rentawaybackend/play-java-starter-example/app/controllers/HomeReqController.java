package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import daos.HomeReqdao;

import models.HomeReq;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class HomeReqController extends Controller {



    final HomeReqdao homedao;

    @Inject
    public HomeReqController(HomeReqdao homedao) {
        this.homedao = homedao;
    }


    @Transactional
    public Result createHome(){
        final JsonNode json = request().body().asJson();

        final HomeReq home = Json.fromJson(json, HomeReq.class);

        if (null == home.getLocation()) {
            return badRequest("Location must be provided");
        }

        if (null == home.getToDate()) {
            return badRequest("To Date must be provided");
        }

        if (null == home.getFromDate()) {
            return badRequest("From Date must be provided");
        }

        if (null == home.getGuestCount()) {
            return badRequest("Guest Count must be provided");
        }

        final HomeReq newhome = homedao.create(home);

        final JsonNode result = Json.toJson(newhome);

        return ok(result);

    }

    @Transactional
    public Result updateHomeById(Integer id){

        return ok("successful");

    }

}
