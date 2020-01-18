package com.Herwaarden.Party.Logic;

import com.Herwaarden.Party.DAL.Interface.Repositories.IPartyRepository;
import com.Herwaarden.Party.Factory.PartyFactory;
import com.Herwaarden.Party.Model.PartyModel;

public class PartyLogic {
    private IPartyRepository partyRepository;

    public PartyLogic(){
        partyRepository = new PartyFactory().getPartySQLRepository();
    }

    public PartyModel getPartyByUserId(int userId){
        return partyRepository.getPartyByUserId(userId);
    }

    public boolean createParty(int userIdOne, int userIdTwo){
        return partyRepository.createParty(userIdOne, userIdTwo);
    }

    public boolean deleteParty(int userId){
        return partyRepository.deleteParty(userId);
    }
}
