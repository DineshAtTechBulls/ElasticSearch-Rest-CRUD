package com.ecs.elasticdemo.controller;

import com.ecs.elasticdemo.model.ClashOfClans;
import com.ecs.elasticdemo.services.CocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CocController {

    @Autowired
    private CocService cocService;

    @GetMapping("/")
    public ResponseEntity<?> getCOCList(){
        return cocService.getCOCList();
    }

    @PostMapping("/coc")
    public ResponseEntity<?> insertCOC(@RequestBody ClashOfClans coc){
        return cocService.saveCocData(coc);
    }

    @PutMapping("/coc/{id}")
    public ResponseEntity<?> updateCOC(@PathVariable("id") String id, @RequestBody ClashOfClans coc){
        return cocService.editCocById(id,coc);
    }

    @DeleteMapping("/coc/{id}")
    public ResponseEntity<?> deleteCOC(@PathVariable String id){
        return cocService.deleteCocByID(id);
    }

    @GetMapping("/coc/{id}")
    public ResponseEntity<?> getCocById(@PathVariable("id") String id){
        return cocService.getCocByID(id);
    }

    @GetMapping("/coc/andfilter")
    public ResponseEntity<?> getCocBykingAndQueen(@RequestParam("king") String king, @RequestParam("queen") String queen){
        return cocService.getCocByKingAndQueen(king,queen);
    }

    @GetMapping("/coc/orfilter")
    public ResponseEntity<?> getCocBykingOrQueen(@RequestParam("king") String king, @RequestParam("queen") String queen){
        return cocService.getCocByKingOrQueen(king,queen);
    }

   @GetMapping("/coc/filterbylevel/{arena}")
    public ResponseEntity<?> getCoCByLevelLessthan(@PathVariable("arena") String arena){
        return cocService.getCocbyArenaNotlike(arena);
   }


}
