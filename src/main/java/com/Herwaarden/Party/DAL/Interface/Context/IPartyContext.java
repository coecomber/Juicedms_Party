package com.Herwaarden.Party.DAL.Interface.Context;

import com.Herwaarden.Party.Model.PartyModel;

public interface IPartyContext {
    PartyModel getPartyByUserId(int userId);
    boolean createParty(int userIdOne, int userIdTwo);
    boolean deleteParty(int userId);
}
