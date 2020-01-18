package com.Herwaarden.Party.DAL.Context;

import com.Herwaarden.Party.DAL.Interface.Context.IPartyContext;
import com.Herwaarden.Party.Model.PartyModel;

import java.sql.*;

public class PartyContextSQL implements IPartyContext {

    private String sqlUrl;
    private String usernameUrl;
    private String passwordUrl;

    // Constructors
    public PartyContextSQL(){
        sqlUrl = "jdbc:mysql://217.101.44.31/partyDB";
        usernameUrl = "root";
        passwordUrl = "varken";
    }

    @Override
    public PartyModel getPartyByUserId(int userId) {
        PartyModel returnPartyModel = new PartyModel();

        // create our mysql database connection
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "SELECT * FROM partytable;";

            // create the java statement
            try (Statement st = conn.createStatement())
            {
                try (ResultSet rs = st.executeQuery(query))
                {
                    // iterate through the java resultset
                    while (rs.next())
                    {
                        if(rs.getInt("characterIdOne") == userId || rs.getInt("characterIdTwo") == userId){
                            returnPartyModel.setCharacterIdOne(rs.getInt("characterIdOne"));
                            returnPartyModel.setCharacterIdTwo(rs.getInt("characterIdTwo"));
                            return returnPartyModel;
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in PartyContextSQL.getPartyByUserId().");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean createParty(int userIdOne, int userIdTwo) {
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "INSERT INTO partytable(characterIdOne, characterIdTwo) VALUES (?, ?);";

            try(PreparedStatement cst = conn.prepareStatement(query)){
                cst.setInt(1, userIdOne);
                cst.setInt(2, userIdTwo);
                cst.executeUpdate();
                return true;
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in PartyContextSQL.createParty().");
            System.err.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean deleteParty(int userId) {
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String deleteQuery = "DELETE FROM partytable WHERE characterIdOne = ? OR characterIdTwo = ?";

            try(PreparedStatement cst = conn.prepareStatement(deleteQuery)){
                cst.setInt(1, userId);
                cst.setInt(2, userId);
                cst.executeUpdate();

                return true;
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in PartyContextSQL.createParty().");
            System.err.println(e.getMessage());
        }

        return false;
    }
}
