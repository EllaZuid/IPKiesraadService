package com.KiesraadService.controller;

import com.KiesraadService.model.Party;
import com.KiesraadService.repository.PartyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/council")
@CrossOrigin(origins = "*")
public class MainController {

    final PartyRepository partyRepository;

    public MainController(PartyRepository partyRepository){
        this.partyRepository = partyRepository;
    }

    @GetMapping(path="/online")
    public String onlineCheck(){
        return "Im online!";
    }

    @PostMapping(path="/createparty")
    public ResponseEntity<Party> createParty(@RequestBody Party party){
        Party partyResult = partyRepository.save(party);
        return new ResponseEntity<Party>(partyResult, HttpStatus.OK);
    }

    @GetMapping(path="/getparty/{partyid}")
    public ResponseEntity<Party> getParty(@PathVariable long partyId){
        Party partyResult =  partyRepository.getOne(partyId);
        return new ResponseEntity<Party>(partyResult, HttpStatus.OK);
    }

    @GetMapping(path="/getparties")
    public ResponseEntity<List<Party>> getParties(){
        List<Party> partyList =  partyRepository.findAll();
        return new ResponseEntity<List<Party>>(partyList, HttpStatus.OK);
    }
}
