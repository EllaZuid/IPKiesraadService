package com.KiesraadService.controller;

import com.KiesraadService.model.Election;
import com.KiesraadService.model.Party;
import com.KiesraadService.repository.ElectionRepository;
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
    final ElectionRepository electionRepository;

    public MainController(PartyRepository partyRepository, ElectionRepository electionRepository){
        this.partyRepository = partyRepository;
        this.electionRepository = electionRepository;
    }

    @GetMapping(path="/online")
    public String onlineCheck(){
        return "Im online!";
    }


    //PARTY ENDPOINTS
    @PostMapping(path="/createparty")
    public ResponseEntity<Party> createParty(@RequestBody Party party){
        Party partyResult = partyRepository.save(party);
        return new ResponseEntity<Party>(partyResult, HttpStatus.OK);
    }

    @GetMapping(path="/getparty/{partyid}")
    public ResponseEntity<Party> getParty(@PathVariable("partyid") long partyId){
        Party partyResult =  partyRepository.getOne(partyId);
        return new ResponseEntity<Party>(partyResult, HttpStatus.OK);
    }

    @GetMapping(path="/getparties")
    public ResponseEntity<List<Party>> getParties(){
        List<Party> partyList =  partyRepository.findAll();
        return new ResponseEntity<List<Party>>(partyList, HttpStatus.OK);
    }

    //ELECTION ENDPOINTS
    @PostMapping(path="/createelection")
    public ResponseEntity<Election> createElection(@RequestBody Election election){
        Election electionResult = electionRepository.save(election);
        return new ResponseEntity<Election>(electionResult, HttpStatus.OK);
    }

    @GetMapping(path="/getelection/{electionid}")
    public ResponseEntity<Election> getElection(@PathVariable("electionid") long electionId){
        Election electionResult =  electionRepository.getOne(electionId);
        return new ResponseEntity<Election>(electionResult, HttpStatus.OK);
    }

    @GetMapping(path="/getelections/")
    public ResponseEntity<List<Election>> getElections(){
        List<Election> electionList =  electionRepository.findAll();
        return new ResponseEntity<List<Election>>(electionList, HttpStatus.OK);
    }
}
