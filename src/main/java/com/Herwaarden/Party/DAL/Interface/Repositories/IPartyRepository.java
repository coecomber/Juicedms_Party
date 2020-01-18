package com.Herwaarden.Party.DAL.Interface.Repositories;

import com.Herwaarden.Party.Model.PartyModel;

public interface IPartyRepository {
    PartyModel getPartyByUserId(int userId);
    boolean createParty(int userIdOne, int userIdTwo);
    boolean deleteParty(int userId);
}
