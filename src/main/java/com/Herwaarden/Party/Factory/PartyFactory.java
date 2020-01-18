package com.Herwaarden.Party.Factory;

import com.Herwaarden.Party.DAL.Context.PartyContextSQL;
import com.Herwaarden.Party.DAL.Interface.Repositories.IPartyRepository;
import com.Herwaarden.Party.DAL.Repository.PartyRepository;

public class PartyFactory {
    public PartyRepository partyRepository;

    public IPartyRepository getPartySQLRepository(){
        partyRepository = new PartyRepository(new PartyContextSQL());
        return partyRepository;
    }
}
