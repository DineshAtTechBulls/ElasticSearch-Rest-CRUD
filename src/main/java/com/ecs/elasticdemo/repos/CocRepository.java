package com.ecs.elasticdemo.repos;

import com.ecs.elasticdemo.model.ClashOfClans;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocRepository extends ElasticsearchRepository<ClashOfClans,String> {
    List<ClashOfClans> findAllByKingAndQueen(String king, String Queen);
    List<ClashOfClans> findAllByKingOrQueen(String king, String Queen);
    List<ClashOfClans> findAllByArenaIsNot(String arena);
}
