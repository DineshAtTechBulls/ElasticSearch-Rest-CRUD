package com.ecs.elasticdemo.services;

import com.ecs.elasticdemo.model.ClashOfClans;
import com.ecs.elasticdemo.repos.CocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CocService {
    @Autowired
    private CocRepository cocRepository;

    public ResponseEntity<?> getCOCList(){
        ResponseEntity<?> result;
        try {
            result = ResponseEntity.ok(cocRepository.findAll());
        }catch (Exception e){
            result = ResponseEntity.badRequest().body(Optional.ofNullable(e.getMessage()));
        }
        return result;
    }

    public ResponseEntity<?> saveCocData(ClashOfClans coc){
        ResponseEntity<?> result;
        try{
            cocRepository.save(coc);
            result = ResponseEntity.ok("success");
        }catch (Exception e){
            result = ResponseEntity.badRequest().body(e.getMessage());
        }
        return result;
    }

    public ResponseEntity<?> editCocById(String id, ClashOfClans coc){
        ResponseEntity<?> result;
        try{
            Optional<ClashOfClans> data = Optional.of(cocRepository.findById(id).get());
            if(data.isPresent()){
                ClashOfClans coc1 = data.get();
                coc1.setKing(coc.getId());
                coc1.setKing(coc.getKing());
                coc1.setQueen(coc.getQueen());
                coc1.setArena(coc.getArena());
                coc1.setLoot(coc.getLoot());
                coc1.setTownhall(coc.getTownhall());
                coc1.setAttack_percent(coc.getAttack_percent());
                cocRepository.save(coc1);
                result = ResponseEntity.ok().build();
            }else
                result = ResponseEntity.badRequest().body("Invalid input");
        }catch (Exception e){
            result = ResponseEntity.badRequest().body(e.getMessage());
        }
        return result;
    }


    public ResponseEntity<?> deleteCocByID(String id) {
        ResponseEntity<?> responseEntity;
        try{
            cocRepository.deleteById(id);
            responseEntity =  !cocRepository.existsById(id) ? ResponseEntity.ok("success") : (ResponseEntity<?>) ResponseEntity.notFound();
        }catch (Exception e){
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    public ResponseEntity<?> getCocByID(String id){
        ResponseEntity<?> responseEntity;
        try{
            responseEntity = ResponseEntity.ok(cocRepository.findById(id));
        }catch (Exception e){
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    public ResponseEntity<?> getCocByKingAndQueen(String king, String queen){
        ResponseEntity<?> responseEntity;
        try{
            responseEntity = ResponseEntity.ok(cocRepository.findAllByKingAndQueen(king,queen));
        }catch (Exception e){
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    public ResponseEntity<?> getCocByKingOrQueen(String king, String queen){
        ResponseEntity<?> responseEntity;
        try{
            responseEntity = ResponseEntity.ok(cocRepository.findAllByKingOrQueen(king,queen));
        }catch (Exception e){
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    public ResponseEntity<?> getCocbyArenaNotlike(String arena){
        ResponseEntity<?> responseEntity;
        try{
            responseEntity = ResponseEntity.ok(cocRepository.findAllByArenaIsNot(arena));
        }catch (Exception e){
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }
}