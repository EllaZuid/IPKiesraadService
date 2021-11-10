package com.KiesraadService.controller;

import com.KiesraadService.model.Party;
import com.KiesraadService.repository.PartyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/council")
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
}
