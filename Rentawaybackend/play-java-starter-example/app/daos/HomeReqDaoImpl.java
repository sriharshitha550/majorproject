package daos;

import models.HomeReq;
import play.db.jpa.JPAApi;

import javax.inject.Inject;

public class HomeReqDaoImpl implements HomeReqdao{


    final JPAApi jpaApi;

    @Inject
    public HomeReqDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }


    public HomeReq create(HomeReq home) {
        if (null == home) {
            throw new IllegalArgumentException("home must be provided");
        }
        jpaApi.em().persist(home);
        return home;

    }


    public HomeReq update(HomeReq home) {
        if (null == home) {
            throw new IllegalArgumentException("home must be provided");
        }
        if (null == home.getId()) {
            throw new IllegalArgumentException("home id must be provided");
        }

        final HomeReq existinghome = jpaApi.em().find(HomeReq.class, home.getId());
        if (null == existinghome) {
            return null;
        }

        existinghome.setLocation(home.getLocation());
        existinghome.setFromDate(home.getFromDate());
        existinghome.setToDate(home.getToDate());
        existinghome.setGuestCount(home.getGuestCount());

        jpaApi.em().persist(existinghome);

        return existinghome;

    }



}
