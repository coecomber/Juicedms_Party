package com.Herwaarden.Party.DAL.Repository;

import com.Herwaarden.Party.DAL.Interface.Context.IPartyContext;
import com.Herwaarden.Party.DAL.Interface.Repositories.IPartyRepository;
import com.Herwaarden.Party.Model.PartyModel;

public class PartyRepository implements IPartyRepository {

    private IPartyContext partyContext;

    public PartyRepository(IPartyContext context){
        partyContext = context;
    }

    @Override
    public PartyModel getPartyByUserId(int userId) {
        return partyContext.getPartyByUserId(userId);
    }

    @Override
    public boolean createParty(int userIdOne, int userIdTwo) {
        return partyContext.createParty(userIdOne, userIdTwo);
    }

    @Override
    public boolean deleteParty(int userId) {
        return partyContext.deleteParty(userId);
    }
}
