package com.Herwaarden.Party.Logic.Resource;


import com.Herwaarden.Party.Logic.PartyLogic;
import com.Herwaarden.Party.Model.PartyModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PartyResource {

    // How to make REST at least level 2:
    // https://martinfowler.com/articles/richardsonMaturityModel.html#level0

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("/public/party/get/{userId}")
    public PartyModel getPartyByUserId(@PathVariable("userId") int userId){
        PartyLogic partyLogic = new PartyLogic();

        System.out.println("Following party requested: " + partyLogic.getPartyByUserId(userId));

        return partyLogic.getPartyByUserId(userId);
    }

    //Example body JSON: "{"characterIdOne": "1", "characterIdTwo": "2"}"
    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @PostMapping("party/create/")
    public boolean createParty(@RequestBody PartyModel partyModel){
        PartyLogic partyLogic = new PartyLogic();

        //First deletes party to make sure player won't end up in 2 seperate parties.
        partyLogic.deleteParty(partyModel.getCharacterIdOne());
        partyLogic.deleteParty(partyModel.getCharacterIdTwo());

        return partyLogic.createParty(partyModel.getCharacterIdOne(), partyModel.getCharacterIdTwo());
    }

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @DeleteMapping("/public/party/delete/{userId}")
    public boolean deleteParty(@PathVariable("userId") int userId){
        PartyLogic partyLogic = new PartyLogic();

        System.out.println("Removing party for user: " + userId);

        return partyLogic.deleteParty(userId);
    }
}
